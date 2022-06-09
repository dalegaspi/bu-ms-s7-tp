package edu.bu.cs622.bestpurchase;

import dagger.Component;
import edu.bu.cs622.bestpurchase.interfaces.AstroAppModule;
import edu.bu.cs622.bestpurchase.controllers.BasicStoreBusinessLayerModule;

@Component(modules = { AstroAppModule.class, BasicStoreBusinessLayerModule.class })
public interface BestPurchaseFactory {
    Astro buildAstro();
}
