package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.queues.CartCheckoutQueueReceiver;
import io.vavr.control.Either;

public interface WarehouseInventory {
    Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity);

    CartCheckoutQueueReceiver getCheckoutQueueReceiver();
}
