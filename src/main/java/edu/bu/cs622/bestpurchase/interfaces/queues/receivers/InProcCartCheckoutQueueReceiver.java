package edu.bu.cs622.bestpurchase.interfaces.queues.receivers;

import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import edu.bu.cs622.bestpurchase.interfaces.queues.AbstractInProcQueue;
import edu.bu.cs622.bestpurchase.interfaces.queues.InProcQueueContext;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZMQ;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Implementation that uses ZeroMQ In-Proc.
 *
 * @author dlegaspi@bu.edu
 */

@Singleton
public class InProcCartCheckoutQueueReceiver extends AbstractInProcQueue<ShoppingCart>
                implements CartCheckoutQueueReceiver {
    private static Logger logger = LoggerFactory.getLogger(InProcCartCheckoutQueueReceiver.class);

    private ZMQ.Socket conn;

    @Inject
    public InProcCartCheckoutQueueReceiver(@Named("CART") InProcQueueContext queueContext) {
        super(queueContext);
        logger.debug("Context address: {}", queueContext.getAddress());
        conn = createReceiverSocket();
    }

    @Override
    public Either<CheckoutException, ShoppingCart> receive() {
        return receive(conn);
    }
}
