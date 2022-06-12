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
        Try.run(() -> {
            var controller = astro.getAppController();

            var customer = controller.authenticate("pedro", "12345");
            pause();

            var cart = customer
                    .map(mc -> mc.map(c -> controller.getStoreBusinessLayer().getShoppingCartFor(c)));
            var item = controller.scanWithCamera().toJavaOptional();
            logger.debug("Scanned item identified? {}", item.isPresent());
            pause();

            item.ifPresent(i -> {
                var details = controller.getStoreBusinessLayer().getItemDetails(i);
                details.map(d -> {
                    logger.info("Item details: {}", d);
                    return d;
                });

                cart.map(mc -> {
                    mc.ifPresent(c -> controller.addItemToCart(c, i, 1));
                    logger.info("Added item to cart.");
                    return mc;
                });
            });
        });
    }
}
