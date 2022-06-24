package edu.bu.cs682.bestpurchase.interfaces.queues.senders;

import edu.bu.cs682.bestpurchase.entities.store.Item;
import edu.bu.cs682.bestpurchase.entities.store.ShoppingCart;
import io.vavr.Tuple3;

public interface AddItemToCartQueueSender extends QueueSender<Tuple3<Item, ShoppingCart, Integer>> {
}
