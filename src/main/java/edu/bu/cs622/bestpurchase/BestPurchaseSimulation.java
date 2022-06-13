package edu.bu.cs622.bestpurchase;

import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.gui2.*;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import edu.bu.cs622.bestpurchase.factories.BestPurchaseFactory;
import edu.bu.cs622.bestpurchase.factories.DaggerBestPurchaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

/**
 * @author dlegaspi@bu.edu
 */
public class BestPurchaseSimulation {
    private static Logger logger = LoggerFactory.getLogger(BestPurchaseSimulation.class);

    public static void main(String[] args) throws IOException {
        logger.info("BestPurchase Add Item to Cart Use Case Simulation begins.");

        // Setup terminal and screen layers
        Terminal terminal = new DefaultTerminalFactory().createTerminal();
        Screen screen = new TerminalScreen(terminal);
        screen.startScreen();

        // Create panel to hold components
        Panel panel = new Panel();
        panel.setLayoutManager(new GridLayout(2));

        panel.addComponent(new Label("Forename"));
        panel.addComponent(new TextBox());

        panel.addComponent(new Label("Surname"));
        panel.addComponent(new TextBox());

        panel.addComponent(new EmptySpace(new TerminalSize(0,0))); // Empty space underneath labels
        panel.addComponent(new Button("Submit"));

        // Create window to hold the panel
        BasicWindow window = new BasicWindow();
        window.setComponent(panel);

        // Create gui and start gui
        MultiWindowTextGUI gui = new MultiWindowTextGUI(screen, new DefaultWindowManager(), new EmptySpace(TextColor.ANSI.BLUE));
        gui.addWindowAndWait(window);

        BestPurchaseFactory factory = DaggerBestPurchaseFactory.create();

        var shopper = factory.buildShopper();
        var worker = factory.buildWarehouseWorker();

        // start the actual simulation
        var f1 = shopper.start();
        var f2 = worker.start();
        CompletableFuture.allOf(f1, f2).join();

        logger.info("BestPurchase Add Item to Cart Use Case Simulation ends.");
    }
}
