package edu.bu.cs682.bestpurchase.factories;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import edu.bu.cs682.bestpurchase.config.AppConfig;
import edu.bu.cs682.bestpurchase.config.SimpleAppConfig;
import edu.bu.cs682.bestpurchase.controllers.store.BasicStoreBusinessLayer;
import edu.bu.cs682.bestpurchase.controllers.store.BasicWarehouseInventory;
import edu.bu.cs682.bestpurchase.controllers.store.StoreBusinessLayer;
import edu.bu.cs682.bestpurchase.controllers.store.WarehouseInventory;
import edu.bu.cs682.bestpurchase.interfaces.databases.*;
import edu.bu.cs682.bestpurchase.interfaces.databases.*;
import edu.bu.cs682.bestpurchase.interfaces.hardware.BasicCameraSimulator;
import edu.bu.cs682.bestpurchase.interfaces.hardware.Camera;
import edu.bu.cs682.bestpurchase.interfaces.queues.*;
import edu.bu.cs682.bestpurchase.interfaces.components.BasicQRItemLookup;
import edu.bu.cs682.bestpurchase.interfaces.components.QRItemLookup;
import edu.bu.cs682.bestpurchase.interfaces.queues.receivers.AddItemToCartQueueReceiver;
import edu.bu.cs682.bestpurchase.interfaces.queues.receivers.CartCheckoutQueueReceiver;
import edu.bu.cs682.bestpurchase.interfaces.queues.receivers.InProcAddItemToCartQueueReceiver;
import edu.bu.cs682.bestpurchase.interfaces.queues.receivers.InProcCartCheckoutQueueReceiver;
import edu.bu.cs682.bestpurchase.interfaces.queues.senders.AddItemToCartQueueSender;
import edu.bu.cs682.bestpurchase.interfaces.queues.senders.CartCheckoutQueueSender;
import edu.bu.cs682.bestpurchase.interfaces.queues.senders.InProcAddItemToCartQueueSender;
import edu.bu.cs682.bestpurchase.interfaces.queues.senders.InProcCartCheckoutQueueSender;
import edu.bu.cs682.bestpurchase.interfaces.recommenders.BasicRecommender;
import edu.bu.cs682.bestpurchase.interfaces.recommenders.Recommender;
import edu.bu.cs682.bestpurchase.interfaces.reviews.BasicReviewsAPI;
import edu.bu.cs682.bestpurchase.interfaces.reviews.ReviewsAPI;
import edu.bu.cs682.bestpurchase.views.Astro;
import edu.bu.cs682.bestpurchase.views.AstroTextUI;
import edu.bu.cs682.bestpurchase.interfaces.queues.InProcQueueContext;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * Our IOC factory
 *
 * @author dlegaspi@bu.edu
 */
@Module
public abstract class AstroAppModule {

    @Binds
    abstract StoreBusinessLayer getStoreBusinessLayer(BasicStoreBusinessLayer storeBusinessLayer);

    @Binds
    abstract ReviewsAPI getReviewsAPI(BasicReviewsAPI reviewsAPI);

    @Binds
    abstract WarehouseInventory getWarehouseInventory(BasicWarehouseInventory warehouseInventory);

    @Binds
    abstract Recommender getRecommender(BasicRecommender recommender);

    @Binds
    abstract Camera getCamera(BasicCameraSimulator camera);

    @Binds
    abstract QRItemLookup getQRItemLookup(BasicQRItemLookup qrItemLookup);

    @Binds
    abstract CustomerDatabase getCustomerDatabase(BasicCustomerDatabase customerDatabase);

    @Binds
    abstract EmployeeDatabase getEmployeeDatabase(BasicEmployeeDatabase employeeDatabase);

    @Binds
    abstract ItemDatabase getItemDatabase(BasicItemDatabase itemDatabase);

    @Provides
    @Singleton
    @Named("CART")
    static InProcQueueContext getCartCheckoutQueueContext() {
        return new InProcQueueContext();
    }

    @Provides
    @Singleton
    @Named("ITEM")
    static InProcQueueContext getAddItemToCartQueueContext() {
        return new InProcQueueContext();
    }

    @Binds
    abstract AddItemToCartQueueSender getAddItemToCartQueueSender(InProcAddItemToCartQueueSender checkoutQueue);

    @Binds
    abstract AddItemToCartQueueReceiver getAddItemToCartQueueReceiver(InProcAddItemToCartQueueReceiver checkoutQueue);

    @Binds
    abstract CartCheckoutQueueSender getCheckoutQueueSender(InProcCartCheckoutQueueSender checkoutQueue);

    @Binds
    abstract CartCheckoutQueueReceiver getCheckoutQueueReceiver(InProcCartCheckoutQueueReceiver checkoutQueue);

    @Binds
    abstract AppConfig getAppConfig(SimpleAppConfig appConfig);

    @Binds
    abstract Astro getAstro(AstroTextUI astro);
}
