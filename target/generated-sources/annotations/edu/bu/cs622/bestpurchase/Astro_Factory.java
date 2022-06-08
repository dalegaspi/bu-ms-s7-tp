package edu.bu.cs622.bestpurchase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import edu.bu.cs622.bestpurchase.controller.AstroAppController;
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
public final class Astro_Factory implements Factory<Astro> {
  private final Provider<AstroAppController> appControllerProvider;

  public Astro_Factory(Provider<AstroAppController> appControllerProvider) {
    this.appControllerProvider = appControllerProvider;
  }

  @Override
  public Astro get() {
    return newInstance(appControllerProvider.get());
  }

  public static Astro_Factory create(Provider<AstroAppController> appControllerProvider) {
    return new Astro_Factory(appControllerProvider);
  }

  public static Astro newInstance(AstroAppController appController) {
    return new Astro(appController);
  }
}
