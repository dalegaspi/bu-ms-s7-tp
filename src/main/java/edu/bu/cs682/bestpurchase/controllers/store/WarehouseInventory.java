package edu.bu.cs682.bestpurchase.controllers.store;

import edu.bu.cs682.bestpurchase.entities.store.Item;
import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs682.bestpurchase.interfaces.queues.receivers.AddItemToCartQueueReceiver;
import edu.bu.cs682.bestpurchase.interfaces.queues.receivers.CartCheckoutQueueReceiver;
import io.vavr.control.Either;

import java.util.Collection;

public interface WarehouseInventory {
    Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity);

    Either<BestPurchaseAppException, Integer> getQuantityAvailableForItem(Item item);

    CartCheckoutQueueReceiver getCheckoutQueueReceiver();

    AddItemToCartQueueReceiver getAddItemToCartQueueReceiver();

    Either<BestPurchaseAppException, Collection<Item>> getItems();
}
