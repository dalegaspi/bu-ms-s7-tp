package edu.bu.cs622.bestpurchase.entities.store;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

/**
 * Warehouse
 *
 * @author dlegaspi@bu.edu
 */
public class Warehouse implements Serializable {

    private Map<Item, Integer> availableItemQuantity;

    public Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity) {
        return Either.right(0);
    }

    @Inject
    public Warehouse() {

    }
}
