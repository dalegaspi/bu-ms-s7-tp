package edu.bu.cs622.bestpurchase;

import edu.bu.cs622.bestpurchase.controllers.AstroAppController;
import edu.bu.cs622.bestpurchase.entities.Customer;
import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.ShoppingCart;

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
