package edu.bu.cs622.bestpurchase.interfaces;

import dagger.Module;
import dagger.Provides;

@Module
public class AstroAppModule {
    @Provides
    StoreBusinessLayer buildStoreBusinessLayer() {
        return new BasicStoreBusinessLayer();
    }
}
