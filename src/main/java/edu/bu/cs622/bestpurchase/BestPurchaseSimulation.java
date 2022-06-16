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

        BestPurchaseFactory factory = DaggerBestPurchaseFactory.create();
        var worker = factory.buildWarehouseWorker();
        var f2 = worker.start();

        // var shopper = factory.buildShopper();

        var astro = factory.buildAstro();

        // start the actual simulation
        // var f1 = shopper.start();

        // CompletableFuture.allOf(f2).join();

        logger.info("BestPurchase Add Item to Cart Use Case Simulation ends.");
    }
}
