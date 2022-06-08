package edu.bu.cs622.bestpurchase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author dlegaspi@bu.edu
 */
public class App {
    private static Logger logger = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {
        BestPurchaseFactory factory = DaggerBestPurchaseFactory.create();

        var astroApp = factory.buildAstro();
    }
}
