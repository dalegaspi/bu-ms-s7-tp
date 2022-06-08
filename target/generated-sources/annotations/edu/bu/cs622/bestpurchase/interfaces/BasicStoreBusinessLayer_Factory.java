package edu.bu.cs622.bestpurchase.interfaces;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class BasicStoreBusinessLayer_Factory implements Factory<BasicStoreBusinessLayer> {
  @Override
  public BasicStoreBusinessLayer get() {
    return newInstance();
  }

  public static BasicStoreBusinessLayer_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static BasicStoreBusinessLayer newInstance() {
    return new BasicStoreBusinessLayer();
  }

  private static final class InstanceHolder {
    private static final BasicStoreBusinessLayer_Factory INSTANCE = new BasicStoreBusinessLayer_Factory();
  }
}
