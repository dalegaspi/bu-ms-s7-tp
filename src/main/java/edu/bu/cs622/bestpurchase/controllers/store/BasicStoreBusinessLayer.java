package edu.bu.cs622.bestpurchase.controllers.store;

import edu.bu.cs622.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs622.bestpurchase.entities.store.IdType;
import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.entities.store.Store;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.databases.EmployeeDatabase;
import edu.bu.cs622.bestpurchase.interfaces.databases.ItemDatabase;
import edu.bu.cs622.bestpurchase.interfaces.queues.senders.AddItemToCartQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.queues.senders.CartCheckoutQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.BasicRecommender;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.RecommendedItems;
import edu.bu.cs622.bestpurchase.interfaces.recommenders.Recommender;
import edu.bu.cs622.bestpurchase.interfaces.reviews.BasicReviewsAPI;
import edu.bu.cs622.bestpurchase.interfaces.reviews.ReviewsAPI;
import io.vavr.Tuple;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.stream.Collectors;

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

    private ItemDatabase itemDatabase;

    @Inject
    public BasicStoreBusinessLayer(WarehouseInventory warehouseInventory,
                    EmployeeDatabase employeeDatabase,
                    ItemDatabase itemDatabase,
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
        this.itemDatabase = itemDatabase;
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
        return this.itemDatabase.lookupById(id)
                        .flatMap(i -> i.isEmpty()
                                        ? Either.left(new BestPurchaseAppException(
                                                        "No available item with id " + id.toString()))
                                        : Either.right(i.get()));
    }

    @Override
    public Either<BestPurchaseAppException, String> getItemDetails(Item item, CustomerProfile profile) {
        var qtyAvailable = getWarehouseInventory().getQuantityAvailableForItem(item);
        var reviewSummary = reviewsAPI
                        .getReviewsForItem(item).flatMap(reviews -> reviewsAPI.getFormattedItemsSummary(item, reviews))
                        .toJavaOptional();
        var recommendedItems = recommender.getRecommendations(item, profile).map(r -> r.getItems().size()).getOrElse(0);
        return qtyAvailable.map(qty -> {
            var details = item.getDetails() + " with [" + qty + "] available.";
            details += String.format("\nAstro recommends %d items to go with this.", recommendedItems);
            if (reviewSummary.isPresent()) {
                details += "\n" + reviewSummary.get();
            }

            return details;
        });
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
        if (cart == null)
            return Either.right(new BigDecimal(0));
        
        var total = cart.getAllItemStatuses().stream().map(s -> s._1.getPrice().multiply(new BigDecimal(s._2.getQuantity()))).mapToDouble(BigDecimal::doubleValue).sum();
        return Either.right(new BigDecimal(total));
    }

    @Override
    public Either<BestPurchaseAppException, ShoppingCart> addItemToCart(ShoppingCart cart, Item item, int quantity) {
        cart.addItemToCart(item, quantity);
        warehouseInventory.updateQuantityForItem(item, quantity);
        return addItemToCartQueueSender.send(Tuple.of(item, cart, quantity))
                        .mapLeft(t -> (BestPurchaseAppException) t)
                        .map(b -> {
                            logger.debug("Item [{}] added to cart notification sent to warehouse",
                                            item.getDescription());
                            return cart;
                        });
    }

    @Override
    public Either<BestPurchaseAppException, Integer> getAvailableQuantity(Item item) {
        return warehouseInventory.getQuantityAvailableForItem(item);
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
