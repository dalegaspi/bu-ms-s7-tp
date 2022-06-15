package edu.bu.cs622.bestpurchase.controllers.store;

import edu.bu.cs622.bestpurchase.entities.store.IdType;
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
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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

        // prime the item db and warehouse with just one item
        var item = new Item();
        item.setId(new IdType(UUID.fromString("adb8d524-32af-47eb-a192-5e483ef70325"), "hotdog"));
        item.setDescription("Hotdog Multiplexer");
        item.setPrice(new BigDecimal("1.99"));
        this.itemDatabase.insert(List.of(item));
        this.warehouse.insert(Map.of(item, 42));
    }

    @Override
    public Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity) {
        return warehouse.updateQuantityForItem(item, quantity);
    }

    @Override
    public Either<BestPurchaseAppException, Integer> getQuantityAvailableForItem(Item item) {
        return warehouse.getQuantityAvailableForItem(item);
    }

    @Override
    public CartCheckoutQueueReceiver getCheckoutQueueReceiver() {
        return this.checkoutQueueReceiver;
    }

    @Override
    public AddItemToCartQueueReceiver getAddItemToCartQueueReceiver() {
        return this.addItemToCartQueueReceiver;
    }
}
