package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.BestPurchaseFactory;
import edu.bu.cs622.bestpurchase.DaggerBestPurchaseFactory;
import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;
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
        Either<CheckoutException, ShoppingCart> r2 = receiver.receive();
        assertTrue(r2.isRight() && r2.get() != null && r2.get().getId().equals(cart.getId()));
    }
}