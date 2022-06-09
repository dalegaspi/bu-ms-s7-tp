package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.*;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.math.BigDecimal;

/**
 * Store business layer interface
 *
 * @author dlegaspi@bu.edu
 */
public interface StoreBusinessLayer {
    Either<BestPurchaseAppException, Item> lookupByItemId(IdType id);

    Either<BestPurchaseAppException, String> getItemDetails(Item item);

    Either<BestPurchaseAppException, BigDecimal> getPriceForItem(Item item);

    Either<BestPurchaseAppException, RecommendedItems> getRecommendedItems(Item item, Customer customer);

    Either<BestPurchaseAppException, BigDecimal> computeCartTotals(ShoppingCart cart);
}
