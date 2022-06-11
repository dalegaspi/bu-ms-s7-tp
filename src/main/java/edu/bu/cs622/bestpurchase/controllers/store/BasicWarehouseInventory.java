package edu.bu.cs622.bestpurchase.controllers.store;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.Warehouse;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.databases.EmployeeDatabase;
import edu.bu.cs622.bestpurchase.interfaces.databases.ItemDatabase;
import edu.bu.cs622.bestpurchase.interfaces.queues.AddItemToCartQueueReceiver;
import edu.bu.cs622.bestpurchase.interfaces.queues.CartCheckoutQueueReceiver;
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

    private AddItemToCartQueueReceiver addItemToCartQueueReceiver;

    @Inject
    public BasicWarehouseInventory(Warehouse warehouse,
                    CartCheckoutQueueReceiver checkoutQueueReceiver,
                    AddItemToCartQueueReceiver addItemToCartQueueReceiver,
                    ItemDatabase itemDatabase,
                    EmployeeDatabase employeeDatabase) {
        this.warehouse = warehouse;
        this.employeeDatabase = employeeDatabase;
        this.itemDatabase = itemDatabase;
        this.checkoutQueueReceiver = checkoutQueueReceiver;
        this.addItemToCartQueueReceiver = addItemToCartQueueReceiver;
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
