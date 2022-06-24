package edu.bu.cs682.bestpurchase.interfaces.queues.receivers;

import edu.bu.cs682.bestpurchase.entities.store.Item;
import edu.bu.cs682.bestpurchase.entities.store.ShoppingCart;
import io.vavr.Tuple3;

public interface AddItemToCartQueueReceiver extends QueueReceiver<Tuple3<Item, ShoppingCart, Integer>> {
}
