package edu.bu.cs622.bestpurchase.interfaces.queues.receivers;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import edu.bu.cs622.bestpurchase.interfaces.queues.AbstractInProcQueue;
import edu.bu.cs622.bestpurchase.interfaces.queues.InProcQueueContext;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import org.zeromq.ZMQ;

import javax.inject.Inject;
import javax.inject.Named;

public class InProcAddItemToCartQueueReceiver extends AbstractInProcQueue<Tuple2<Item, ShoppingCart>>
                implements AddItemToCartQueueReceiver {

    ZMQ.Socket conn;

    @Inject
    public InProcAddItemToCartQueueReceiver(@Named("ITEM") InProcQueueContext context) {
        super(context);
        conn = createReceiverSocket();
    }

    @Override
    public Either<CheckoutException, Tuple2<Item, ShoppingCart>> receive() {
        return receive(conn);
    }
}
