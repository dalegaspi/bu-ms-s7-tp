package edu.bu.cs682.bestpurchase.views;

import edu.bu.cs682.bestpurchase.controllers.app.AstroAppController;
import edu.bu.cs682.bestpurchase.entities.persons.Customer;
import edu.bu.cs682.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs682.bestpurchase.entities.store.ShoppingCart;

public abstract class Astro {
    private final AstroAppController appController;

    public Astro(AstroAppController appController) {
        this.appController = appController;
    }

    public AstroAppController getAppController() {
        return appController;
    }

    abstract boolean handleScanQRCode();

    abstract boolean handleAuthentication();

    abstract boolean handleAddItemToCart(ShoppingCart cart, Customer customer, CustomerProfile profile);

    abstract boolean handleScanItem(ShoppingCart cart, Customer customer, CustomerProfile profile);

    abstract void run();

    abstract boolean displayCartContents();
}
