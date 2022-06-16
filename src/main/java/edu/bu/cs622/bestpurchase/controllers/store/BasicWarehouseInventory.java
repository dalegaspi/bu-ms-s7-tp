package edu.bu.cs622.bestpurchase.controllers.store;

import edu.bu.cs622.bestpurchase.entities.store.IdType;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.Warehouse;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.databases.EmployeeDatabase;
import edu.bu.cs622.bestpurchase.interfaces.databases.ItemDatabase;
import edu.bu.cs622.bestpurchase.interfaces.queues.receivers.AddItemToCartQueueReceiver;
import edu.bu.cs622.bestpurchase.interfaces.queues.receivers.CartCheckoutQueueReceiver;
import io.vavr.Tuple;
import io.vavr.control.Either;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import static edu.bu.cs622.bestpurchase.entities.store.IdType.toIdType;

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

        var items = List.of(
                        Tuple.of(new Item(toIdType("adb8d524-32af-47eb-a192-5e483ef70325", "hotdog"), "Sony",
                                        "Hotdog Multiplexer", 129.99), 42),

                        Tuple.of(new Item(toIdType("4c7b7a66-ed71-11ec-8ea0-0242ac120002", "ketchup"), "Heinz",
                                        "Dehydrated Ketchup", 4.99), 19),

                        Tuple.of(new Item(toIdType("534d02ba-ed71-11ec-8ea0-0242ac120002", "bread"), "Kirkland",
                                        "Soylent Green Bread", 1.99), 11));

        this.itemDatabase.insert(items.stream().map(t -> t._1).collect(Collectors.toList()));
        this.warehouse.insert(items.stream().collect(Collectors.toMap(t -> t._1, t -> t._2)));
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

    @Override
    public Either<BestPurchaseAppException, Collection<Item>> getItems() {
        return warehouse.getItems();
    }
}
