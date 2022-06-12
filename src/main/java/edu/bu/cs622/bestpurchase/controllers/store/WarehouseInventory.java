package edu.bu.cs622.bestpurchase.controllers.store;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.queues.receivers.CartCheckoutQueueReceiver;
import io.vavr.control.Either;

import javax.inject.Singleton;


public interface WarehouseInventory {
    Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity);

    CartCheckoutQueueReceiver getCheckoutQueueReceiver();
}
