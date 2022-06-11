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
public class InProcCheckoutQueueSender extends AbstractInProcQueue<ShoppingCart> implements CheckoutQueueSender<ShoppingCart> {

    private ZMQ.Socket conn;

    @Inject
    public InProcCheckoutQueueSender() {
        conn = createSenderSocket();
    }


    @Override
    public Either<CheckoutException, Boolean> send(ShoppingCart cart) {
        return send(conn, cart);
    }
}
