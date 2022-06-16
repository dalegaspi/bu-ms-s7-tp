package edu.bu.cs622.bestpurchase.views;

import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.gui2.dialogs.MessageDialog;
import com.googlecode.lanterna.gui2.dialogs.TextInputDialogBuilder;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import edu.bu.cs622.bestpurchase.controllers.app.AstroAppController;
import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import io.vavr.Tuple;
import io.vavr.Tuple2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.regex.Pattern;

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
        do {
            var creds = getCredentials();
            authenticated = authenticate(creds._1, creds._2);
            if (!authenticated)
                MessageDialog.showMessageDialog(gui, "Login", "Invalid username/password!");
        } while (!authenticated);

        removeExitButton();
        setActionToScan();

        return true;
    }

    boolean authenticate(String username, String password) {
        var customer = getAppController().authenticate(username, password);

        customer.map(mc -> {
            mc.ifPresent(c -> {
                this.customer = c;
                this.cart = getAppController().getStoreBusinessLayer().getShoppingCartFor(c);
            });
            return mc;
        });

        return customer.isRight() && customer.get().isPresent();
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

    void setActionToAddToCart() {
        messageLabel.setText(selectedItemDetails);
        replaceActionButton(new Button("Add Item to Cart", () -> {
            var qty = getItemQuantity();

            MessageDialog.showMessageDialog(gui, "Item", String.format("%d items added to cart.", qty));
            getAppController().addItemToCart(cart, selectedItem, qty);
            logger.info("Added item to cart [{}].", cart.getId().getEasyToRememberId());
            setActionToScan();
        }));
    }

    void setActionToScan() {
        messageLabel.setText(String.format("Hi, %s!\nClick on the button to start scanning your item!",
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
                    setActionToAddToCart();
                }
            } else {
                MessageDialog.showMessageDialog(gui, "Camera", "QR Code scan operation failed.");
            }
        });

        panel.addComponent(shopActionButton);
        addExitButton();
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

            panel.addComponent(messageLabel, GridLayout.createHorizontallyFilledLayoutData(2));
            panel.addComponent(shopActionButton);
            panel.addComponent(quitButton);

            // Create window to hold the panel
            BasicWindow window = new BasicWindow();
            window.setComponent(panel);

            // Create gui and start gui

            gui.addWindowAndWait(window);
        } catch (Exception e) {
            logger.debug("Unable to initialize UI", e);
        }
    }
}
