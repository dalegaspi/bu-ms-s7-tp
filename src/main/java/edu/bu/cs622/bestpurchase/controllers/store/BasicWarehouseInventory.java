package edu.bu.cs622.bestpurchase.controllers.store;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.Warehouse;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.databases.EmployeeDatabase;
import edu.bu.cs622.bestpurchase.interfaces.databases.ItemDatabase;
import edu.bu.cs622.bestpurchase.interfaces.queues.receivers.AddItemToCartQueueReceiver;
import edu.bu.cs622.bestpurchase.interfaces.queues.receivers.CartCheckoutQueueReceiver;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;


/**
 * Warehouse controller
 *
 * @author dlegaspi@bu.edu
 */
@Singleton
public class BasicWarehouseInventory implements WarehouseInventory {
    private static Logger logger = LoggerFactory.getLogger(BasicWarehouseInventory.class);

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
        logger.debug("Basic warehouse inventory created.");
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
