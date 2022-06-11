package edu.bu.cs622.bestpurchase.interfaces.queues;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import org.zeromq.ZMQ;

import javax.inject.Inject;
import javax.inject.Named;

public class InProcAddItemToCartQueueSender extends AbstractInProcQueue<Tuple2<Item, ShoppingCart>>
                implements AddItemToCartQueueSender {
    ZMQ.Socket conn;

    @Inject
    public InProcAddItemToCartQueueSender(@Named("ITEM") InProcQueueContext context) {
        super(context);
        conn = createSenderSocket();
    }

    @Override
    public Either<CheckoutException, Boolean> send(Tuple2<Item, ShoppingCart> itemCart) {
        return send(conn, itemCart);
    }
}
