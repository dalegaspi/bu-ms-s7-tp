package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.Warehouse;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.CartCheckoutQueueReceiver;
import edu.bu.cs622.bestpurchase.interfaces.CartCheckoutQueueSender;
import edu.bu.cs622.bestpurchase.interfaces.EmployeeDatabase;
import edu.bu.cs622.bestpurchase.interfaces.ItemDatabase;
import io.vavr.control.Either;

import javax.inject.Inject;

/**
 * Warehouse controller
 *
 * @author dlegaspi@bu.edu
 */
public class BasicWarehouseInventory implements WarehouseInventory {

    private Warehouse warehouse;
    private EmployeeDatabase employeeDatabase;

    private ItemDatabase itemDatabase;

    private CartCheckoutQueueReceiver checkoutQueueReceiver;

    @Inject
    public BasicWarehouseInventory(Warehouse warehouse,
                                   CartCheckoutQueueReceiver checkoutQueueReceiver,
                                   ItemDatabase itemDatabase,
                                   EmployeeDatabase employeeDatabase) {
        this.warehouse = warehouse;
        this.employeeDatabase = employeeDatabase;
        this.itemDatabase = itemDatabase;
        this.checkoutQueueReceiver = checkoutQueueReceiver;
    }

    @Override
    public Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity) {
        return warehouse.updateQuantityForItem(item, quantity);
    }

    @Override
    public CartCheckoutQueueReceiver getCheckoutQueueReceiver() {
        return this.checkoutQueueReceiver;
    }
}
