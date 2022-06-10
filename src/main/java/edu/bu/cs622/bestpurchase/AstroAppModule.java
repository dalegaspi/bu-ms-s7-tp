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
    abstract StoreBusinessLayer getBasicStoreBusinessLayer(BasicStoreBusinessLayer storeBusinessLayer);

    @Binds
    abstract ReviewsAPI getBasicReviewsAPI(BasicReviewsAPI reviewsAPI);

    @Binds
    abstract WarehouseInventory getBasicWarehouseInventory(BasicWarehouseInventory warehouseInventory);

    @Binds
    abstract Recommender getBasicRecommender(BasicRecommender recommender);

    @Binds
    abstract Camera getBasicCamera(BasicCamera camera);

    @Binds
    abstract QRItemLookup getBasicQRItemLookup(BasicQRItemLookup qrItemLookup);

    @Binds
    abstract CustomerDatabase getBasicCustomerDatabase(BasicCustomerDatabase customerDatabase);

    @Binds
    abstract EmployeeDatabase getBasicEmployeeDatabase(BasicEmployeeDatabase employeeDatabase);

    @Binds
    abstract ItemDatabase getBasicItemDatabase(BasicItemDatabase itemDatabase);
}
