package edu.bu.cs622.bestpurchase.controller;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.bu.cs622.bestpurchase.interfaces.StoreBusinessLayer;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class AstroAppController_Factory implements Factory<AstroAppController> {
  private final Provider<StoreBusinessLayer> storeBusinessLayerProvider;

  public AstroAppController_Factory(Provider<StoreBusinessLayer> storeBusinessLayerProvider) {
    this.storeBusinessLayerProvider = storeBusinessLayerProvider;
  }

  @Override
  public AstroAppController get() {
    return newInstance(storeBusinessLayerProvider.get());
  }

  public static AstroAppController_Factory create(
      Provider<StoreBusinessLayer> storeBusinessLayerProvider) {
    return new AstroAppController_Factory(storeBusinessLayerProvider);
  }

  public static AstroAppController newInstance(StoreBusinessLayer storeBusinessLayer) {
    return new AstroAppController(storeBusinessLayer);
  }
}
