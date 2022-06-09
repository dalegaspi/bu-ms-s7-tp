package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.Warehouse;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;

/**
 * Warehouse controller
 *
 * @author dlegaspi@bu.edu
 */
public class WarehouseInventory {

    Warehouse warehouse;

    @Inject
    public WarehouseInventory(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity) {
        return warehouse.updateQuantityForItem(item, quantity);
    }
}
