package edu.bu.cs622.bestpurchase.interfaces.queues.senders;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import io.vavr.Tuple2;
import io.vavr.Tuple3;

import javax.inject.Singleton;

public interface AddItemToCartQueueSender extends QueueSender<Tuple3<Item, ShoppingCart, Integer>> {
}
