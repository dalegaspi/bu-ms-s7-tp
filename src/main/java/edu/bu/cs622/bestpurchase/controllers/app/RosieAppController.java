package edu.bu.cs622.bestpurchase.controllers.app;

import edu.bu.cs622.bestpurchase.controllers.WarehouseInventory;

import javax.inject.Inject;

public class RosieAppController {

    private final WarehouseInventory warehouseInventory;

    @Inject
    public RosieAppController(WarehouseInventory warehouseInventory) {
        this.warehouseInventory = warehouseInventory;
    }
}
