package edu.bu.cs622.bestpurchase.actors;

import edu.bu.cs622.bestpurchase.views.Rosie;
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
            for (int i = 0; i < 10; i++) {
                logger.debug("Working...");
                Thread.sleep(1000);
            }
        });
    }
}
