package edu.bu.cs622.bestpurchase.entities.store;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.*;

/**
 * Warehouse
 *
 * @author dlegaspi@bu.edu
 */
public class Warehouse implements Serializable {

    private Map<Item, Integer> availableItemQuantity;

    public Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity) {

        var currentQuantity = availableItemQuantity.get(item);
        availableItemQuantity.put(item, Math.max(currentQuantity - quantity, 0));
        return Either.right(Optional.ofNullable(availableItemQuantity.get(item)).orElse(0));
    }

    public Either<BestPurchaseAppException, Integer> getQuantityAvailableForItem(Item item) {
        return Either.right(Optional.ofNullable(availableItemQuantity.get(item)).orElse(0));
    }

    @Inject
    public Warehouse() {
        availableItemQuantity = new HashMap<>();
    }

    public Either<BestPurchaseAppException, Integer> insert(Map<Item, Integer> itemQuantities) {
        this.availableItemQuantity.putAll(itemQuantities);

        return Either.right(this.availableItemQuantity.size());
    }
}
