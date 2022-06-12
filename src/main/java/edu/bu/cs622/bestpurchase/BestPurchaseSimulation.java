package edu.bu.cs622.bestpurchase;

import edu.bu.cs622.bestpurchase.factories.BestPurchaseFactory;
import edu.bu.cs622.bestpurchase.factories.DaggerBestPurchaseFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CompletableFuture;

/**
 * @author dlegaspi@bu.edu
 */
public class BestPurchaseSimulation {
    private static Logger logger = LoggerFactory.getLogger(BestPurchaseSimulation.class);

    public static void main(String[] args) {
        logger.info("BestPurchase Add Item to Cart Use Case Simulation begins.");
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
