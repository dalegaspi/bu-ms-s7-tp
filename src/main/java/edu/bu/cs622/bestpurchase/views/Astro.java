package edu.bu.cs622.bestpurchase.views;

import edu.bu.cs622.bestpurchase.controllers.app.AstroAppController;
import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;

import javax.inject.Inject;

public class Astro {

    private final AstroAppController appController;

    private Customer customer;
    private ShoppingCart cart;
    private Item selectedItem;

    @Inject
    public Astro(AstroAppController appController) {
        this.appController = appController;
    }

    public AstroAppController getAppController() {
        return appController;
    }

    public void handleAddItemToCart() {
        appController.addItemToCart(cart, selectedItem, 1);
    }
}