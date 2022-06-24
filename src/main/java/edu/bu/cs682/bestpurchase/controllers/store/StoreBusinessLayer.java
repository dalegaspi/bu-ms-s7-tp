package edu.bu.cs682.bestpurchase.controllers.store;

import edu.bu.cs682.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs682.bestpurchase.entities.store.IdType;
import edu.bu.cs682.bestpurchase.entities.persons.Customer;
import edu.bu.cs682.bestpurchase.entities.store.Item;
import edu.bu.cs682.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs682.bestpurchase.interfaces.recommenders.RecommendedItems;
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

    Either<BestPurchaseAppException, String> getItemDetails(Item item, CustomerProfile profile);

    Either<BestPurchaseAppException, BigDecimal> getPriceForItem(Item item);

    Either<BestPurchaseAppException, RecommendedItems> getRecommendedItems(Item item, Customer customer);

    Either<BestPurchaseAppException, BigDecimal> computeCartTotals(ShoppingCart cart);

    Either<BestPurchaseAppException, ShoppingCart> addItemToCart(final ShoppingCart cart,
                    final Item item,
                    final int quantity);

    Either<BestPurchaseAppException, Integer> getAvailableQuantity(Item item);
}
