package edu.bu.cs622.bestpurchase;

import dagger.internal.DaggerGenerated;
import edu.bu.cs622.bestpurchase.controllers.AstroAppController;
import edu.bu.cs622.bestpurchase.controllers.BasicStoreBusinessLayer;
import edu.bu.cs622.bestpurchase.controllers.BasicWarehouseInventory;
import edu.bu.cs622.bestpurchase.entities.Store;
import edu.bu.cs622.bestpurchase.entities.Warehouse;
import edu.bu.cs622.bestpurchase.interfaces.BasicRecommender;
import edu.bu.cs622.bestpurchase.interfaces.BasicReviewsAPI;
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

    public BestPurchaseFactory build() {
      return new BestPurchaseFactoryImpl();
    }
  }

  private static final class BestPurchaseFactoryImpl implements BestPurchaseFactory {
    private final BestPurchaseFactoryImpl bestPurchaseFactoryImpl = this;

    private BestPurchaseFactoryImpl() {


    }

    private BasicWarehouseInventory basicWarehouseInventory() {
      return new BasicWarehouseInventory(new Warehouse());
    }

    private BasicStoreBusinessLayer basicStoreBusinessLayer() {
      return new BasicStoreBusinessLayer(basicWarehouseInventory(), new Store(), new BasicRecommender(), new BasicReviewsAPI());
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
