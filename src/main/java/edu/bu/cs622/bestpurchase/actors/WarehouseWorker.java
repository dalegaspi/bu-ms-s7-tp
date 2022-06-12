package edu.bu.cs622.bestpurchase.actors;

import edu.bu.cs622.bestpurchase.views.Rosie;
import io.vavr.control.Option;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class WarehouseWorker extends SimulatedActor {
    private static Logger logger = LoggerFactory.getLogger(WarehouseWorker.class);

    private final Rosie rosie;

    @Inject
    public WarehouseWorker(Rosie rosie) {
        this.rosie = rosie;
    }

    @Override
    void doSomething() {
        Try.run(()-> {
            logger.debug("Working...");

            rosie.getAppController()
                    .getWarehouseInventory()
                    .getAddItemToCartQueueReceiver()
                    .receive().map(t -> {
                        logger.info("Item [{}] added to cart with id [{}]", t._1.getDescription(), t._2.getId().getEasyToRememberId());
                        return Option.none();
                    });
        });
    }
}