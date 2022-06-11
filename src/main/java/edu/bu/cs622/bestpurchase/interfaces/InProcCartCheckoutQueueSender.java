package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.control.Either;
import org.zeromq.ZMQ;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Implementation that uses ZeroMQ In-Proc.
 *
 * @author dlegaspi@bu.edu
 */
@Singleton
public class InProcCartCheckoutQueueSender extends AbstractInProcQueue<ShoppingCart> implements CartCheckoutQueueSender {

    private ZMQ.Socket conn;

    @Inject
    public InProcCartCheckoutQueueSender(QueueContext context) {
        super(context);
        conn = createSenderSocket();
    }


    @Override
    public Either<CheckoutException, Boolean> send(ShoppingCart cart) {
        return send(conn, cart);
    }
}
