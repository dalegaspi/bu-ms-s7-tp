package edu.bu.cs622.bestpurchase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import edu.bu.cs622.bestpurchase.controllers.AstroAppController;
import edu.bu.cs622.bestpurchase.controllers.BasicStoreBusinessLayer;
import edu.bu.cs622.bestpurchase.controllers.WarehouseInventory;
import edu.bu.cs622.bestpurchase.entities.Store;
import edu.bu.cs622.bestpurchase.entities.Warehouse;
import edu.bu.cs622.bestpurchase.interfaces.AstroAppModule;
import edu.bu.cs622.bestpurchase.interfaces.Recommender;
import edu.bu.cs622.bestpurchase.interfaces.ReviewsAPI;
import javax.annotation.processing.Generated;

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

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder astroAppModule(AstroAppModule astroAppModule) {
      Preconditions.checkNotNull(astroAppModule);
      return this;
    }

    public BestPurchaseFactory build() {
      return new BestPurchaseFactoryImpl();
    }
  }

  private static final class BestPurchaseFactoryImpl implements BestPurchaseFactory {
    private final BestPurchaseFactoryImpl bestPurchaseFactoryImpl = this;

    private BestPurchaseFactoryImpl() {


    }

    private WarehouseInventory warehouseInventory() {
      return new WarehouseInventory(new Warehouse());
    }

    private BasicStoreBusinessLayer basicStoreBusinessLayer() {
      return new BasicStoreBusinessLayer(warehouseInventory(), new Store(), new Recommender(), new ReviewsAPI());
    }

    private AstroAppController astroAppController() {
      return new AstroAppController(basicStoreBusinessLayer());
    }

    @Override
    public Astro buildAstro() {
      return new Astro(astroAppController());
    }
  }
}
