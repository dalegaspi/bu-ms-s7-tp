package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.Customer;
import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

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

    public Either<BestPurchaseAppException, ShoppingCart> addItemToCart(final ShoppingCart cart,
                    final Item item,
                    final int quantity) {
        cart.addItemToCart(item, quantity);
        return Either.right(cart);
    }
}
