package edu.bu.cs622.bestpurchase.interfaces.queues.receivers;

import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;

public interface QueueReceiver<T> {
    Either<CheckoutException, T> receive();
}
