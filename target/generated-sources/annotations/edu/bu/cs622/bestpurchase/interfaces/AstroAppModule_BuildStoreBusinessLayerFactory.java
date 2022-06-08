package edu.bu.cs622.bestpurchase.interfaces;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class AstroAppModule_BuildStoreBusinessLayerFactory implements Factory<StoreBusinessLayer> {
  private final AstroAppModule module;

  public AstroAppModule_BuildStoreBusinessLayerFactory(AstroAppModule module) {
    this.module = module;
  }

  @Override
  public StoreBusinessLayer get() {
    return buildStoreBusinessLayer(module);
  }

  public static AstroAppModule_BuildStoreBusinessLayerFactory create(AstroAppModule module) {
    return new AstroAppModule_BuildStoreBusinessLayerFactory(module);
  }

  public static StoreBusinessLayer buildStoreBusinessLayer(AstroAppModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.buildStoreBusinessLayer());
  }
}
