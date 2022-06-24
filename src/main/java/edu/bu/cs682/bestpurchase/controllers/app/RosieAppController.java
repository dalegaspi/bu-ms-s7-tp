package edu.bu.cs682.bestpurchase.controllers.app;

import edu.bu.cs682.bestpurchase.controllers.store.WarehouseInventory;

import javax.inject.Inject;

public class RosieAppController {

    private final WarehouseInventory warehouseInventory;

    @Inject
    public RosieAppController(WarehouseInventory warehouseInventory) {
        this.warehouseInventory = warehouseInventory;
    }

    public WarehouseInventory getWarehouseInventory() {
        return warehouseInventory;
    }
}
