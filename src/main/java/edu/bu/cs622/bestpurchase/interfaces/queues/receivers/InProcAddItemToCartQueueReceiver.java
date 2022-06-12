package edu.bu.cs622.bestpurchase.interfaces.queues.receivers;

import edu.bu.cs622.bestpurchase.config.AppConfig;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.CheckoutException;
import edu.bu.cs622.bestpurchase.interfaces.queues.AbstractInProcQueue;
import edu.bu.cs622.bestpurchase.interfaces.queues.InProcQueueContext;
import io.vavr.Tuple2;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.zeromq.ZMQ;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;


@Singleton
public class InProcAddItemToCartQueueReceiver extends AbstractInProcQueue<Tuple2<Item, ShoppingCart>>
                implements AddItemToCartQueueReceiver {

    private static Logger logger = LoggerFactory.getLogger(InProcAddItemToCartQueueReceiver.class);

    ZMQ.Socket conn;

    @Inject
    public InProcAddItemToCartQueueReceiver(@Named("ITEM") InProcQueueContext context, AppConfig appConfig) {
        super(context, appConfig);
        logger.debug("Context address: {}", context.getAddress());
        conn = createReceiverSocket();
    }

    @Override
    public Either<CheckoutException, Tuple2<Item, ShoppingCart>> receive() {
        return receive(conn);
    }
}
