package edu.bu.cs622.bestpurchase.interfaces.queues.senders;

import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;

import javax.inject.Singleton;


public interface CartCheckoutQueueSender extends QueueSender<ShoppingCart> {

}
