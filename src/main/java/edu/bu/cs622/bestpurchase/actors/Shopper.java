package edu.bu.cs622.bestpurchase.actors;

import edu.bu.cs622.bestpurchase.views.Astro;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class Shopper extends SimulatedActor {

    private static Logger logger = LoggerFactory.getLogger(Shopper.class);

    private final Astro astro;

    @Inject
    public Shopper(Astro astro) {
        this.astro = astro;
    }
    @Override
    void doSomething() {
        Try.run(()-> {
            for (int i = 0; i < 10; i++) {
                logger.debug("Shopping...");
                Thread.sleep(1000);
            }
        });
    }
}
