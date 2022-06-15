package edu.bu.cs622.bestpurchase.interfaces.queues.senders;

import edu.bu.cs622.bestpurchase.config.AppConfig;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import edu.bu.cs622.bestpurchase.interfaces.queues.AbstractInProcQueue;
import edu.bu.cs622.bestpurchase.interfaces.queues.InProcQueueContext;
import io.vavr.Tuple2;
import io.vavr.Tuple3;
import io.vavr.control.Either;
import org.zeromq.ZMQ;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

public class InProcAddItemToCartQueueSender extends AbstractInProcQueue<Tuple3<Item, ShoppingCart, Integer>>
                implements AddItemToCartQueueSender {
    ZMQ.Socket conn;

    @Inject
    public InProcAddItemToCartQueueSender(@Named("ITEM") InProcQueueContext context, AppConfig appConfig) {
        super(context, appConfig);
        conn = createSenderSocket();
    }

    @Override
    public Either<CheckoutException, Boolean> send(Tuple3<Item, ShoppingCart, Integer> itemCart) {
        return send(conn, itemCart);
    }
}
