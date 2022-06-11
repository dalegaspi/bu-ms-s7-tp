package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;

public interface QueueReceiver<T> {
    Either<CheckoutException, T> receive();
}
