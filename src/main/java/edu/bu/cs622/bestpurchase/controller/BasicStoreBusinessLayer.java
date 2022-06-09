package edu.bu.cs622.bestpurchase.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

public class BasicStoreBusinessLayer implements StoreBusinessLayer {
    private static Logger logger = LoggerFactory.getLogger(BasicStoreBusinessLayer.class);

    @Inject
    public BasicStoreBusinessLayer(WarehouseInventory warehouseInventory) {
        logger.debug("Store business layer created.");
    }
}
