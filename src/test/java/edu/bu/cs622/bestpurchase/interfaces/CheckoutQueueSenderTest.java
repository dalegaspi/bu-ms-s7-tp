package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckoutQueueSenderTest {

    @Test
    void send() {
        var sender = new InProcCheckoutQueueSender();
        var cart = new ShoppingCart();

        var r1 = sender.send(cart);
        assertTrue(r1.isRight() && r1.get());

        var receiver = new InProcCheckoutQueueReceiver();
        Either<CheckoutException, ShoppingCart> r2 = receiver.receive();
        ShoppingCart cc = r2.get();
        assertTrue(r2.isRight() && r2.get().getId().equals(cart.getId()));
    }


}