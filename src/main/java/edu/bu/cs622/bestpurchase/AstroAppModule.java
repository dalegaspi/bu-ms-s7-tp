package edu.bu.cs622.bestpurchase;

import dagger.Binds;
import dagger.Module;
import edu.bu.cs622.bestpurchase.controllers.BasicStoreBusinessLayer;
import edu.bu.cs622.bestpurchase.controllers.BasicWarehouseInventory;
import edu.bu.cs622.bestpurchase.controllers.StoreBusinessLayer;
import edu.bu.cs622.bestpurchase.controllers.WarehouseInventory;
import edu.bu.cs622.bestpurchase.interfaces.*;

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

    @Binds
    abstract CheckoutQueueSender getCheckoutQueue(InProcCheckoutQueueSender checkoutQueue);
}
