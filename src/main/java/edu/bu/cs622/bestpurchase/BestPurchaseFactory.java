package edu.bu.cs622.bestpurchase;

import dagger.Component;

import javax.inject.Singleton;

/**
 * Dagger2 Factory
 *
 * @author dlegaspi@bu.edu
 */

@Singleton
@Component(modules = { AstroAppModule.class })
public interface BestPurchaseFactory {
    Astro buildAstro();

    Rosie buildRosie();
}
