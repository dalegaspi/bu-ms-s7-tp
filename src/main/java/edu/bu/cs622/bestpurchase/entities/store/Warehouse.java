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
        // todo: a better implementation
        return Either.right(0);
    }

    public Either<BestPurchaseAppException, Integer> getQuantityAvailableForItem(Item item) {
        // todo: a better implementation
        return Either.right(42);
    }

    @Inject
    public Warehouse() {

    }
}
