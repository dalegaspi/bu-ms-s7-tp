package edu.bu.cs622.bestpurchase.controllers;

import javax.inject.Inject;

/**
 * Astro app controller
 *
 * @author dlegaspi@bu.edu
 */
public class AstroAppController {
    private StoreBusinessLayer storeBusinessLayer;

    @Inject
    public AstroAppController(StoreBusinessLayer storeBusinessLayer) {
        this.storeBusinessLayer = storeBusinessLayer;
    }
}
