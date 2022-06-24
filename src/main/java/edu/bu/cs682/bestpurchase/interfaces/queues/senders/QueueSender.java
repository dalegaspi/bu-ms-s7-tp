package edu.bu.cs682.bestpurchase.interfaces.queues.senders;

import edu.bu.cs682.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;

public interface QueueSender<T> {
    Either<CheckoutException, Boolean> send(T item);
}
