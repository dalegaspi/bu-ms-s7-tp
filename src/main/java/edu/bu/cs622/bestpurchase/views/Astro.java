package edu.bu.cs622.bestpurchase.views;

import edu.bu.cs622.bestpurchase.controllers.app.AstroAppController;
import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;

import javax.inject.Inject;

public abstract class Astro {
    private final AstroAppController appController;

    public Astro(AstroAppController appController) {
        this.appController = appController;
    }

    public AstroAppController getAppController() {
        return appController;
    }

    abstract boolean handleScanQRCode();

    abstract void run();
}
