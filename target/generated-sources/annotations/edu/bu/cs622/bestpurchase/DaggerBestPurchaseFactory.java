package edu.bu.cs622.bestpurchase;

import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import edu.bu.cs622.bestpurchase.controllers.AstroAppController;
import edu.bu.cs622.bestpurchase.controllers.BasicStoreBusinessLayer;
import edu.bu.cs622.bestpurchase.controllers.BasicWarehouseInventory;
import edu.bu.cs622.bestpurchase.controllers.RosieAppController;
import edu.bu.cs622.bestpurchase.entities.Store;
import edu.bu.cs622.bestpurchase.entities.Warehouse;
import edu.bu.cs622.bestpurchase.interfaces.BasicCustomerDatabase;
import edu.bu.cs622.bestpurchase.interfaces.BasicCustomerDatabase_Factory;
import edu.bu.cs622.bestpurchase.interfaces.BasicEmployeeDatabase;
import edu.bu.cs622.bestpurchase.interfaces.BasicEmployeeDatabase_Factory;
import edu.bu.cs622.bestpurchase.interfaces.BasicItemDatabase;
import edu.bu.cs622.bestpurchase.interfaces.BasicItemDatabase_Factory;
import edu.bu.cs622.bestpurchase.interfaces.BasicRecommender;
import edu.bu.cs622.bestpurchase.interfaces.BasicReviewsAPI;
import edu.bu.cs622.bestpurchase.interfaces.InProcCheckoutQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.InProcCheckoutQueueSender_Factory;
import edu.bu.cs622.bestpurchase.interfaces.QueueContext;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerBestPurchaseFactory {
  private DaggerBestPurchaseFactory() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static BestPurchaseFactory create() {
    return new Builder().build();
  }

  public static final class Builder {
    private Builder() {
    }

    public BestPurchaseFactory build() {
      return new BestPurchaseFactoryImpl();
    }
  }

  private static final class BestPurchaseFactoryImpl implements BestPurchaseFactory {
    private final BestPurchaseFactoryImpl bestPurchaseFactoryImpl = this;

    private Provider<QueueContext> getCartCheckoutQueueContextProvider;

    private Provider<InProcCheckoutQueueSender> inProcCheckoutQueueSenderProvider;

    private Provider<BasicItemDatabase> basicItemDatabaseProvider;

    private Provider<BasicEmployeeDatabase> basicEmployeeDatabaseProvider;

    private Provider<BasicCustomerDatabase> basicCustomerDatabaseProvider;

    private BestPurchaseFactoryImpl() {

      initialize();

    }

    private BasicWarehouseInventory basicWarehouseInventory() {
      return new BasicWarehouseInventory(new Warehouse(), inProcCheckoutQueueSenderProvider.get(), basicItemDatabaseProvider.get(), basicEmployeeDatabaseProvider.get());
    }

    private BasicStoreBusinessLayer basicStoreBusinessLayer() {
      return new BasicStoreBusinessLayer(basicWarehouseInventory(), basicEmployeeDatabaseProvider.get(), new Store(), new BasicRecommender(), new BasicReviewsAPI());
    }

    private AstroAppController astroAppController() {
      return new AstroAppController(basicStoreBusinessLayer(), basicCustomerDatabaseProvider.get());
    }

    private RosieAppController rosieAppController() {
      return new RosieAppController(basicWarehouseInventory());
    }

    @SuppressWarnings("unchecked")
    private void initialize() {
      this.getCartCheckoutQueueContextProvider = DoubleCheck.provider(AstroAppModule_GetCartCheckoutQueueContextFactory.create());
      this.inProcCheckoutQueueSenderProvider = DoubleCheck.provider(InProcCheckoutQueueSender_Factory.create(getCartCheckoutQueueContextProvider));
      this.basicItemDatabaseProvider = DoubleCheck.provider(BasicItemDatabase_Factory.create());
      this.basicEmployeeDatabaseProvider = DoubleCheck.provider(BasicEmployeeDatabase_Factory.create());
      this.basicCustomerDatabaseProvider = DoubleCheck.provider(BasicCustomerDatabase_Factory.create());
    }

    @Override
    public Astro buildAstro() {
      return new Astro(astroAppController());
    }

    @Override
    public Rosie buildRosie() {
      return new Rosie(rosieAppController());
    }
  }
}
