package edu.bu.cs622.bestpurchase.controllers.store;

import edu.bu.cs622.bestpurchase.entities.ids.IdType;
import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.entities.store.Store;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.databases.EmployeeDatabase;
import edu.bu.cs622.bestpurchase.interfaces.queues.senders.AddItemToCartQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.queues.senders.CartCheckoutQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.BasicRecommender;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.RecommendedItems;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.Recommender;
import edu.bu.cs622.bestpurchase.interfaces.reviews.BasicReviewsAPI;
import edu.bu.cs622.bestpurchase.interfaces.reviews.ReviewsAPI;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
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
@Singleton
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
        logger.debug("Basic store business layer created.");

        this.warehouseInventory = warehouseInventory;
        this.store = store;
        this.recommender = recommender;
        this.reviewsAPI = reviewsAPI;
        this.checkoutQueueSender = checkoutQueueSender;
        this.addItemToCartQueueSender = addItemToCartQueueSender;
    }

    private ShoppingCart createShoppingCart() {
        return new ShoppingCart();
    }

    @Override
    public ShoppingCart getShoppingCartFor(Customer customer) {
        store.getActiveShoppers().add(customer);
        if (!customer.hasShoppingCart()) {
            var cart = createShoppingCart();
            customer.setCart(cart);
        }

        return customer.getCart();
    }

    @Override
    public Either<BestPurchaseAppException, Item> lookupByItemId(IdType id) {
        var item = new Item();
        item.setId(id);
        item.setDescription("Hotdog Multiplexer");
        item.setPrice(new BigDecimal("1.99"));
        return Either.right(item);
    }

    @Override
    public Either<BestPurchaseAppException, String> getItemDetails(Item item) {
        var qtyAvailable = getWarehouseInventory().getQuantityAvailableForItem(item);
        return qtyAvailable.map(qty -> item.getDetails() + " with [" + qty + "] available");
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

    public Store getStore() {
        return store;
    }

    public WarehouseInventory getWarehouseInventory() {
        return warehouseInventory;
    }

    public ReviewsAPI getReviewsAPI() {
        return reviewsAPI;
    }

    public CartCheckoutQueueSender getCheckoutQueueSender() {
        return checkoutQueueSender;
    }

    public void setCheckoutQueueSender(CartCheckoutQueueSender checkoutQueueSender) {
        this.checkoutQueueSender = checkoutQueueSender;
    }

    public AddItemToCartQueueSender getAddItemToCartQueueSender() {
        return addItemToCartQueueSender;
    }
}
