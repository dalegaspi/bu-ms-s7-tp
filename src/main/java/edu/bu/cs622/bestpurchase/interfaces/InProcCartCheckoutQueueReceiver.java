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
public class InProcCartCheckoutQueueReceiver extends AbstractInProcQueue<ShoppingCart> implements CartCheckoutQueueReceiver {

    private ZMQ.Socket conn;

    @Inject
    public InProcCartCheckoutQueueReceiver(QueueContext queueContext) {
        super(queueContext);
        conn = createReceiverSocket();
    }

    @Override
    public Either<CheckoutException, ShoppingCart> receive() {
        return receive(conn);
    }
}
