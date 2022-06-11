package edu.bu.cs622.bestpurchase;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import edu.bu.cs622.bestpurchase.controllers.BasicStoreBusinessLayer;
import edu.bu.cs622.bestpurchase.controllers.BasicWarehouseInventory;
import edu.bu.cs622.bestpurchase.controllers.StoreBusinessLayer;
import edu.bu.cs622.bestpurchase.controllers.WarehouseInventory;
import edu.bu.cs622.bestpurchase.entities.ShoppingCart;
import edu.bu.cs622.bestpurchase.interfaces.*;

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
    abstract Camera getCamera(BasicCamera camera);

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
    //@Named("CART")
    static QueueContext getCartCheckoutQueueContext() {
        return new QueueContext();
    }


    @Binds
    abstract CartCheckoutQueueSender getCheckoutQueueSender(InProcCheckoutQueueSender checkoutQueue);

    @Binds
    abstract CartCheckoutQueueReceiver getCheckoutQueueReceiver(InProcCartCheckoutQueueReceiver checkoutQueue);
}
