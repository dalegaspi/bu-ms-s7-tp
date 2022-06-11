package edu.bu.cs622.bestpurchase;

import dagger.Component;
import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.interfaces.CartCheckoutQueueReceiver;
import edu.bu.cs622.bestpurchase.interfaces.CartCheckoutQueueSender;


import javax.inject.Singleton;

/**
 * Dagger2 Factory
 *
 * @author dlegaspi@bu.edu
 */

@Singleton
@Component(modules = { AstroAppModule.class })
public interface BestPurchaseFactory {
    Astro buildAstro();

    Rosie buildRosie();

    CartCheckoutQueueSender buildCartCheckoutQueueSender();

    CartCheckoutQueueReceiver buildCartCheckoutQueueReceiver();
}
