package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.zeromq.ZContext;
import org.zeromq.ZMQ;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;

/**
 * Implementation that uses ZeroMQ In-Proc.
 *
 * @author dlegaspi@bu.edu
 */
@Singleton
public class InProcCheckoutQueueReceiver extends AbstractInProcQueue implements CheckoutQueueReceiver {

    private ZMQ.Socket conn;

    @Inject
    public InProcCheckoutQueueReceiver() {
        conn = createReceiverSocket();
    }

    @Override
    public Either<CheckoutException, ShoppingCart> receive() {

        return Try.of(() -> {
            var bytes = conn.recv();
            var inputStream = new ByteArrayInputStream(bytes);
            var objectInput = new ObjectInputStream(inputStream);

            var cart = (ShoppingCart) objectInput.readObject();
            return cart;
        }).toEither().mapLeft(t -> new CheckoutException("ShoppingCart receive error", t));
    }

}
