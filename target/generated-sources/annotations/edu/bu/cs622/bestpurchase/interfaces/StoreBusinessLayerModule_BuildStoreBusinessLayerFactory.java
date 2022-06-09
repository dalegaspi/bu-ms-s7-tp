package edu.bu.cs622.bestpurchase.interfaces;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.bu.cs622.bestpurchase.controllers.StoreBusinessLayer;

import javax.annotation.processing.Generated;

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
public final class StoreBusinessLayerModule_BuildStoreBusinessLayerFactory implements Factory<StoreBusinessLayer> {
  private final AstroAppModule module;

  public StoreBusinessLayerModule_BuildStoreBusinessLayerFactory(AstroAppModule module) {
    this.module = module;
  }

  @Override
  public StoreBusinessLayer get() {
    return buildStoreBusinessLayer(module);
  }

  public static StoreBusinessLayerModule_BuildStoreBusinessLayerFactory create(
      AstroAppModule module) {
    return new StoreBusinessLayerModule_BuildStoreBusinessLayerFactory(module);
  }

  public static StoreBusinessLayer buildStoreBusinessLayer(AstroAppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.buildStoreBusinessLayer());
  }
}
