package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;

public interface CheckoutQueueSender<T> {
    Either<CheckoutException, Boolean> send(T cart);
}
