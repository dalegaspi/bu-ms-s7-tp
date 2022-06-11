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
public class InProcCheckoutQueueReceiver extends AbstractInProcQueue<ShoppingCart> implements CheckoutQueueReceiver<ShoppingCart> {

    private ZMQ.Socket conn;

    @Inject
    public InProcCheckoutQueueReceiver() {
        conn = createReceiverSocket();
    }

    @Override
    public Either<CheckoutException, ShoppingCart> receive() {
        return receive(conn);
    }
}