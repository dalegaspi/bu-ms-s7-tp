package edu.bu.cs622.bestpurchase.interfaces.queues.receivers;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import io.vavr.Tuple2;

import javax.inject.Singleton;


public interface AddItemToCartQueueReceiver extends QueueReceiver<Tuple2<Item, ShoppingCart>> {
}
