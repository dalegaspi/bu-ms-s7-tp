package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.*;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.Recommender;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.math.BigDecimal;

public class BasicStoreBusinessLayer implements StoreBusinessLayer {
    private static Logger logger = LoggerFactory.getLogger(BasicStoreBusinessLayer.class);

    private Store store;
    private Recommender recommender;
    private WarehouseInventory warehouseInventory;

    @Inject
    public BasicStoreBusinessLayer(WarehouseInventory warehouseInventory, Store store, Recommender recommender) {
        logger.debug("Store business layer created.");

        this.warehouseInventory = warehouseInventory;
        this.store = store;
        this.recommender = recommender;
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
