package edu.bu.cs622.bestpurchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dlegaspi@bu.edu
 */
public class BestPurchaseSimulation {
    private static Logger logger = LoggerFactory.getLogger(BestPurchaseSimulation.class);

    public static void setup(Astro astro) {
        astro.getAppController()
    }

    public static void main(String[] args) {
        BestPurchaseFactory factory = DaggerBestPurchaseFactory.create();

        var astroApp = factory.buildAstro();

    }
}
