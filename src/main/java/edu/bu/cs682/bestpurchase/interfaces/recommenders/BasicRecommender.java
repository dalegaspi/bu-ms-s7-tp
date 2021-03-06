package edu.bu.cs682.bestpurchase.interfaces.recommenders;

import edu.bu.cs682.bestpurchase.controllers.store.WarehouseInventory;
import edu.bu.cs682.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs682.bestpurchase.entities.store.Item;
import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;

public class BasicRecommender implements Recommender {

    WarehouseInventory inventory;

    @Inject
    public BasicRecommender(WarehouseInventory warehouseInventory) {
        this.inventory = warehouseInventory;
    }

    @Override
    public Either<BestPurchaseAppException, RecommendedItems> getRecommendations(Item item, CustomerProfile profile) {
        return inventory.getItems()
                        .map(list -> list.stream().filter(i -> !i.equals(item)).toList())
                        .map(list -> new RecommendedItems(profile, list));
    }
}
