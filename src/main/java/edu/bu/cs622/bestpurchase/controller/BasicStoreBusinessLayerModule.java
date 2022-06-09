package edu.bu.cs622.bestpurchase.controller;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class BasicStoreBusinessLayerModule {

    @Binds
    abstract StoreBusinessLayer getBasicStoreBusinessLayer(BasicStoreBusinessLayer storeBusinessLayer);
}
