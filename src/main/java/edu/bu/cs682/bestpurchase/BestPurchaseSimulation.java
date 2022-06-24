package edu.bu.cs682.bestpurchase;

import edu.bu.cs682.bestpurchase.factories.BestPurchaseFactory;
import edu.bu.cs682.bestpurchase.factories.DaggerBestPurchaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

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
