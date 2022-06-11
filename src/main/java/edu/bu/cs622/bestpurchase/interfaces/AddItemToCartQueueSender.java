package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import io.vavr.Tuple2;

public interface AddItemToCartQueueSender extends QueueSender<Tuple2<Item, ShoppingCart>> {
}
