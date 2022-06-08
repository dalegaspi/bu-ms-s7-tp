package edu.bu.cs622.bestpurchase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Preconditions;
import edu.bu.cs622.bestpurchase.controller.AstroAppController;
import edu.bu.cs622.bestpurchase.interfaces.AstroAppModule;
import edu.bu.cs622.bestpurchase.interfaces.AstroAppModule_BuildStoreBusinessLayerFactory;
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
    private AstroAppModule astroAppModule;

    private Builder() {
    }

    public Builder astroAppModule(AstroAppModule astroAppModule) {
      this.astroAppModule = Preconditions.checkNotNull(astroAppModule);
      return this;
    }

    public BestPurchaseFactory build() {
      if (astroAppModule == null) {
        this.astroAppModule = new AstroAppModule();
      }
      return new BestPurchaseFactoryImpl(astroAppModule);
    }
  }

  private static final class BestPurchaseFactoryImpl implements BestPurchaseFactory {
    private final AstroAppModule astroAppModule;

    private final BestPurchaseFactoryImpl bestPurchaseFactoryImpl = this;

    private BestPurchaseFactoryImpl(AstroAppModule astroAppModuleParam) {
      this.astroAppModule = astroAppModuleParam;

    }

    private AstroAppController astroAppController() {
      return new AstroAppController(AstroAppModule_BuildStoreBusinessLayerFactory.buildStoreBusinessLayer(astroAppModule));
    }

    @Override
    public Astro buildAstro() {
      return new Astro(astroAppController());
    }
  }
}
