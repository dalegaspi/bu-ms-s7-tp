package edu.bu.cs622.bestpurchase;

import dagger.Component;
import edu.bu.cs622.bestpurchase.interfaces.AstroAppModule;


@Component(modules = { AstroAppModule.class})
public interface BestPurchaseFactory {
     Astro buildAstro();
}
