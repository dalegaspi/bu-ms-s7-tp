package edu.bu.cs622.bestpurchase.controllers;

import dagger.Binds;
import dagger.Module;

/**
 * IOC for StoreBusinessLayer
 *
 * @see BasicStoreBusinessLayer
 * @see StoreBusinessLayer
 * @author dlegaspi@bu.edu
 */
@Module
public abstract class BasicStoreBusinessLayerModule {

    @Binds
    abstract StoreBusinessLayer getBasicStoreBusinessLayer(BasicStoreBusinessLayer storeBusinessLayer);
}
