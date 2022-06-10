package edu.bu.cs622.bestpurchase.controllers;

import javax.inject.Inject;

public class RosieAppController {

    private final WarehouseInventory warehouseInventory;

    @Inject
    public RosieAppController(WarehouseInventory warehouseInventory) {
        this.warehouseInventory = warehouseInventory;
    }
}
