package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.zeromq.ZMQ;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;

/**
 * Implementation that uses ZeroMQ In-Proc.
 *
 * @author dlegaspi@bu.edu
 */
@Singleton
public class InProcCheckoutQueueSender extends AbstractInProcQueue implements CheckoutQueueSender {

    private ZMQ.Socket conn;

    @Inject
    public InProcCheckoutQueueSender() {
        conn = createSenderSocket();
    }

    @Override
    public Either<CheckoutException, Void> send(ShoppingCart cart) {
        return Try.run(() -> {
            var outputStream = new ByteArrayOutputStream();
            var objectOutput = new ObjectOutputStream(outputStream);
            objectOutput.writeObject(cart);

            var bytes = outputStream.toByteArray();
            objectOutput.close();
            outputStream.close();

            conn.send(bytes);
        }).toEither().mapLeft(t -> new CheckoutException("ShoppingCart send error", t));
    }
}
