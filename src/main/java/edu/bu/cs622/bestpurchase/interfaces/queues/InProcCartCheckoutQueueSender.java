package edu.bu.cs622.bestpurchase.interfaces.queues;

import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
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
public class InProcCartCheckoutQueueSender extends AbstractInProcQueue<ShoppingCart>
                implements CartCheckoutQueueSender {
    private static Logger logger = LoggerFactory.getLogger(InProcCartCheckoutQueueSender.class);

    private ZMQ.Socket conn;

    @Inject
    public InProcCartCheckoutQueueSender(@Named("CART") InProcQueueContext queueContext) {
        super(queueContext);
        logger.debug("Context address: {}", queueContext.getAddress());
        conn = createSenderSocket();
    }

    @Override
    public Either<CheckoutException, Boolean> send(ShoppingCart cart) {
        return send(conn, cart);
    }
}
