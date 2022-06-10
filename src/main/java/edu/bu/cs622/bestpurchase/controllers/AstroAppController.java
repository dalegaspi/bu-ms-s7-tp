package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.Customer;
import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.CustomerDatabase;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Astro app controller
 *
 * @author dlegaspi@bu.edu
 */
public class AstroAppController {
    private final StoreBusinessLayer storeBusinessLayer;
    private final CustomerDatabase customerDatabase;

    @Inject
    public AstroAppController(StoreBusinessLayer storeBusinessLayer,
                    CustomerDatabase customerDatabase) {
        this.storeBusinessLayer = storeBusinessLayer;
        this.customerDatabase = customerDatabase;
    }

    public Either<BestPurchaseAppException, Optional<Customer>> authenticate(String username, String password) {
        return customerDatabase.searchByUsername(username)
                        .map(customer -> customer.map(Customer::getProfile)
                                        .map(p -> p.authenticate(password).isRight())
                                        .orElse(false) ? customer : Optional.empty());
    }

    public Either<BestPurchaseAppException, ShoppingCart> addItemToCart(final ShoppingCart cart,
                    final Item item,
                    final int quantity) {
        cart.addItemToCart(item, quantity);
        return Either.right(cart);
    }

    public StoreBusinessLayer getStoreBusinessLayer() {
        return storeBusinessLayer;
    }

    public CustomerDatabase getCustomerDatabase() {
        return customerDatabase;
    }
}
