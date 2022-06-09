package edu.bu.cs622.bestpurchase;

import dagger.Component;

/**
 * Dagger2 Factory
 *
 * @author dlegaspi@bu.edu
 */
@Component(modules = { AstroAppModule.class })
public interface BestPurchaseFactory {
    Astro buildAstro();
}
