package edu.bu.cs622.bestpurchase.entity;

import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.util.Map;

public class Warehouse {

    private Map<Item, Integer> availableItemQuantity;

    public Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity) {
        return Either.right(0);
    }

    @Inject
    public Warehouse() {

    }
}
