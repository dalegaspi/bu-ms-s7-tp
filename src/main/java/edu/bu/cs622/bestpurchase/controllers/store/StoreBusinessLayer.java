package edu.bu.cs622.bestpurchase.controllers.store;

import edu.bu.cs622.bestpurchase.entities.store.IdType;
import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.RecommendedItems;
import io.vavr.control.Either;

import java.math.BigDecimal;

/**
 * Store business layer interface
 *
 * @author dlegaspi@bu.edu
 */
public interface StoreBusinessLayer {
    ShoppingCart getShoppingCartFor(Customer customer);
    Either<BestPurchaseAppException, Item> lookupByItemId(IdType id);

    Either<BestPurchaseAppException, String> getItemDetails(Item item);

    Either<BestPurchaseAppException, BigDecimal> getPriceForItem(Item item);

    Either<BestPurchaseAppException, RecommendedItems> getRecommendedItems(Item item, Customer customer);

    Either<BestPurchaseAppException, BigDecimal> computeCartTotals(ShoppingCart cart);

     Either<BestPurchaseAppException, ShoppingCart> addItemToCart(final ShoppingCart cart,
                                                                        final Item item,
                                                                        final int quantity);

     Either<BestPurchaseAppException, Integer> getAvailableQuantity(Item item);
}
