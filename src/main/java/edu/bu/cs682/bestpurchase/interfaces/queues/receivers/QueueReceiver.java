package edu.bu.cs682.bestpurchase.interfaces.queues.receivers;

import edu.bu.cs682.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;

public interface QueueReceiver<T> {
    Either<CheckoutException, T> receive();
}
