package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.ids.IdType;
import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.entities.store.Store;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.databases.EmployeeDatabase;
import edu.bu.cs622.bestpurchase.interfaces.queues.AddItemToCartQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.queues.CartCheckoutQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.BasicRecommender;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.RecommendedItems;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.Recommender;
import edu.bu.cs622.bestpurchase.interfaces.reviews.BasicReviewsAPI;
import edu.bu.cs622.bestpurchase.interfaces.reviews.ReviewsAPI;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;

/**
 * Default implementation of StoreBusinessLayer
 *
 * @see StoreBusinessLayer
 * @see BasicWarehouseInventory
 * @see BasicReviewsAPI
 * @see BasicRecommender
 * @author dlegaspi@bu.edu
 */
public class BasicStoreBusinessLayer implements StoreBusinessLayer {
    private static Logger logger = LoggerFactory.getLogger(BasicStoreBusinessLayer.class);

    private Store store;
    private Recommender recommender;
    private WarehouseInventory warehouseInventory;

    private ReviewsAPI reviewsAPI;

    private CartCheckoutQueueSender checkoutQueueSender;

    private AddItemToCartQueueSender addItemToCartQueueSender;

    @Inject
    public BasicStoreBusinessLayer(WarehouseInventory warehouseInventory,
                    EmployeeDatabase employeeDatabase,
                    CartCheckoutQueueSender checkoutQueueSender,
                    AddItemToCartQueueSender addItemToCartQueueSender,
                    Store store,
                    Recommender recommender,
                    ReviewsAPI reviewsAPI) {
        logger.debug("Store business layer created.");

        this.warehouseInventory = warehouseInventory;
        this.store = store;
        this.recommender = recommender;
        this.reviewsAPI = reviewsAPI;
        this.checkoutQueueSender = checkoutQueueSender;
        this.addItemToCartQueueSender = addItemToCartQueueSender;
    }

    @Override
    public Either<BestPurchaseAppException, Item> lookupByItemId(IdType id) {
        return null;
    }

    @Override
    public Either<BestPurchaseAppException, String> getItemDetails(Item item) {
        return Either.right(item.getDetails());
    }

    @Override
    public Either<BestPurchaseAppException, BigDecimal> getPriceForItem(Item item) {
        return Either.right(item.getPrice());
    }

    @Override
    public Either<BestPurchaseAppException, RecommendedItems> getRecommendedItems(Item item, Customer customer) {
        return recommender.getRecommendations(item, customer.getProfile());
    }

    @Override
    public Either<BestPurchaseAppException, BigDecimal> computeCartTotals(ShoppingCart cart) {
        return Either.right(new BigDecimal(0));
    }
}
