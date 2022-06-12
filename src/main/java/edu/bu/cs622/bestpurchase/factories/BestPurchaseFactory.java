package edu.bu.cs622.bestpurchase.factories;

import dagger.Component;
import edu.bu.cs622.bestpurchase.actors.Shopper;
import edu.bu.cs622.bestpurchase.actors.WarehouseWorker;
import edu.bu.cs622.bestpurchase.interfaces.queues.receivers.AddItemToCartQueueReceiver;
import edu.bu.cs622.bestpurchase.interfaces.queues.senders.AddItemToCartQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.queues.receivers.CartCheckoutQueueReceiver;
import edu.bu.cs622.bestpurchase.interfaces.queues.senders.CartCheckoutQueueSender;
import edu.bu.cs622.bestpurchase.views.Astro;
import edu.bu.cs622.bestpurchase.views.Rosie;

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

    AddItemToCartQueueSender buildAddItemToCartQueueSender();

    AddItemToCartQueueReceiver buildAddItemToCartQueueReceiver();

    Shopper buildShopper();

    WarehouseWorker buildWarehouseWorker();
}
