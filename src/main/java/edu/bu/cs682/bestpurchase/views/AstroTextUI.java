package edu.bu.cs682.bestpurchase.views;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialogBuilder;
import com.googlecode.lanterna.gui2.table.Table;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import edu.bu.cs682.bestpurchase.controllers.app.AstroAppController;
import edu.bu.cs682.bestpurchase.entities.persons.Customer;
import edu.bu.cs682.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs682.bestpurchase.entities.store.Item;
import edu.bu.cs682.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.util.regex.Pattern;

import static com.googlecode.lanterna.gui2.GridLayout.createHorizontallyFilledLayoutData;

/**
 * @se
 */
public class AstroTextUI extends Astro {
    private static Logger logger = LoggerFactory.getLogger(AstroTextUI.class);

    @Inject
    public AstroTextUI(AstroAppController appController) {
        super(appController);
    }

    @Override
    boolean handleScanQRCode() {
        var item = getAppController().scanWithCamera().toJavaOptional();
        logger.debug("Scanned item identified? {}", item.isPresent());

        item.ifPresent(i -> {
            selectedItem = i;
            var details = getAppController().getStoreBusinessLayer().getItemDetails(i, customer.getProfile());
            details.map(d -> {
                logger.info("Item details: {}", d);
                selectedItemDetails = d;
                return d;
            });
        });

        return item.isPresent();
    }

    @Override
    boolean handleAuthentication() {
        var authenticated = false;
        Either<BestPurchaseAppException, Tuple3<ShoppingCart, Customer, CustomerProfile>> rc;
        do {
            var creds = getCredentials();
            rc  = authenticate(creds._1, creds._2);
            authenticated = rc.isRight();
            if (!authenticated)
                MessageDialog.showMessageDialog(gui, "Login", "Invalid username/password!");

        } while (!authenticated);

        rc.map(t -> {
            removeExitButton();
            return handleScanItem(t._1, t._2, t._3);
        });

        return true;
    }

    Either<BestPurchaseAppException, Tuple3<ShoppingCart, Customer, CustomerProfile>> authenticate(String username, String password) {
        var customer = getAppController().authenticate(username, password);

        return customer.flatMap(mc -> {
            mc.ifPresent(c -> {
                this.customer = c;
                this.cart = getAppController().getStoreBusinessLayer().getShoppingCartFor(c);
            });
            return mc.isEmpty() ? Either.left(new BestPurchaseAppException("No customer found")) :
                    Either.right(Tuple.of(this.cart, this.customer, this.customer.getProfile()));
        });
    }

    private Customer customer;

    private Button shopActionButton;

    private Button quitButton;

    private WindowBasedTextGUI gui;

    private Screen screen;

    private Terminal terminal;

    private Label messageLabel;

    private Panel panel;

    private Item selectedItem;

    private String selectedItemDetails;

    private ShoppingCart cart;

    Table<String> cartContents;

    Tuple2<String, String> getCredentials() {
        var username = new TextInputDialogBuilder()
                        .setTitle("Login")
                        .setDescription("Enter username")
                        .setValidationPattern(Pattern.compile(".+"), "Username cannot be empty!")
                        .build()
                        .showDialog(gui);

        var password = new TextInputDialogBuilder()
                        .setPasswordInput(true)
                        .setTitle("Login")
                        .setDescription("Enter password")
                        .build()
                        .showDialog(gui);

        return Tuple.of(username, password);
    }

    int getItemQuantity() {
        return Integer.parseInt(new TextInputDialogBuilder()
                        .setTitle("Item Quantity")
                        .setDescription("Enter item quantity")
                        .setValidationPattern(Pattern.compile("\\d*[1-9]\\d*"), "Please enter a number greater than 0.")
                        .build()
                        .showDialog(gui));
    }

    void replaceActionButton(Button newButton) {
        panel.removeComponent(shopActionButton);
        shopActionButton = newButton;
        panel.addComponent(shopActionButton);
    }

    void removeExitButton() {
        panel.removeComponent(quitButton);
    }

    void addExitButton() {
        panel.addComponent(quitButton);
    }

    @Override
    boolean handleAddItemToCart(ShoppingCart cart, Customer customer, CustomerProfile profile) {
        messageLabel.setText(selectedItemDetails);
        replaceActionButton(new Button("Add Item to Cart", () -> {
            var qty = getItemQuantity();

            MessageDialog.showMessageDialog(gui, "Item", String.format("%d items added to cart.", qty));
            getAppController().addItemToCart(cart, selectedItem, qty);
            logger.info("Added item to cart [{}].", cart.getId().getEasyToRememberId());
            handleScanItem(cart, customer, profile);
        }));

        return true;
    }

    @Override
    boolean handleScanItem(ShoppingCart cart, Customer customer, CustomerProfile profile) {
        messageLabel.setText(String.format("Hi, %s!\nClick on the 'Scan QR Code with Camera' to scanning your item(s)!",
                        customer.getFirstName()));
        panel.removeComponent(shopActionButton);
        shopActionButton = new Button("Scan QR Code with Camera", () -> {
            var rc = handleScanQRCode();
            if (rc) {
                MessageDialog.showMessageDialog(gui, "Camera", "QR Code scan operation succeeded.");

                int warehouseQty = getAppController().getStoreBusinessLayer().getAvailableQuantity(selectedItem)
                                .toJavaOptional().orElse(0);
                if (warehouseQty == 0) {
                    MessageDialog.showMessageDialog(gui, "Error",
                                    String.format("There are no more available %s", selectedItem.getDescription()));
                } else {
                    removeExitButton();
                    handleAddItemToCart(cart, customer, profile);
                }
            } else {
                MessageDialog.showMessageDialog(gui, "Camera", "QR Code scan operation failed.");
            }
        });

        displayCartContents();
        panel.addComponent(shopActionButton);
        addExitButton();

        return true;
    }

    @Inject
    @Override
    public void run() {
        try {
            terminal = new DefaultTerminalFactory().createTerminal();
            screen = new TerminalScreen(terminal);
            screen.startScreen();
            gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
            // Create panel to hold components
            panel = new Panel();
            panel.setLayoutManager(new GridLayout(2));

            messageLabel = new Label("Hi, my name is Astro!\nWelcome to BestPurchase!");
            shopActionButton = new Button("Login", this::handleAuthentication);

            quitButton = new Button("Exit", () -> System.exit(0));

            cartContents = new Table<>("Quantity", "Item", "Price");
            panel.addComponent(messageLabel, createHorizontallyFilledLayoutData(2));
            panel.addComponent(new Label(""), createHorizontallyFilledLayoutData(2));
            panel.addComponent(cartContents, createHorizontallyFilledLayoutData(2));
            panel.addComponent(new Label(""), createHorizontallyFilledLayoutData(2));
            panel.addComponent(shopActionButton);
            panel.addComponent(quitButton);


            // Create window to hold the panel
            BasicWindow window = new BasicWindow();
            window.setComponent(panel);

            // Create gui and start gui

            displayCartContents();
            gui.addWindowAndWait(window);
        } catch (Exception e) {
            logger.debug("Unable to initialize UI", e);
        }
    }

    @Override
    boolean displayCartContents() {
        cartContents.getTableModel().clear();

        if (cart != null) {
            cart.getAllItemStatuses().forEach(i -> {
                cartContents.getTableModel().addRow(String.valueOf(i._2.getQuantity()),
                        i._1.getDescription(),
                        String.valueOf(i._1.getPrice()));
            });
        }

        var total = getAppController().getStoreBusinessLayer().computeCartTotals(cart).toJavaOptional().orElse(new BigDecimal(0));
        cartContents.getTableModel().addRow("Total", "", String.format("%.2f", total));

        Try.run(() -> gui.updateScreen());
        return true;
    }
}
