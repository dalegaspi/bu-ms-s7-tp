package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.factories.BestPurchaseFactory;
import edu.bu.cs622.bestpurchase.factories.DaggerBestPurchaseFactory;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import io.vavr.Tuple;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutQueueSenderTest {

    static BestPurchaseFactory factory;

    @BeforeAll
    static void init() {
        factory = DaggerBestPurchaseFactory.create();
    }

    @Test
    void testCartCheckoutQueue() {
        var sender = factory.buildCartCheckoutQueueSender();
        var cart = new ShoppingCart();

        var r1 = sender.send(cart);
        assertTrue(r1.isRight() && r1.get());

        var receiver = factory.buildCartCheckoutQueueReceiver();
        var r2 = receiver.receive();
        assertTrue(r2.isRight() && r2.get() != null && r2.get().getId().equals(cart.getId()));
    }

    @Test
    void testAddItemToCartQueue() {
        var sender = factory.buildAddItemToCartQueueSender();
        var cart = new ShoppingCart();
        var item = new Item();
        item.setDescription("foo");

        var r1 = sender.send(Tuple.of(item, cart));
        assertTrue(r1.isRight() && r1.get());

        var receiver = factory.buildAddItemToCartQueueReceiver();
        var r2 = receiver.receive();
        assertTrue(r2.isRight() && r2.get() != null && r2.get()._2.getId().equals(cart.getId()));
    }
}
