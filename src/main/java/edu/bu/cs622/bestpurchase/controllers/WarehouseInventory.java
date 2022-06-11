package edu.bu.cs622.bestpurchase.controllers;

import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.CartCheckoutQueueReceiver;
import edu.bu.cs622.bestpurchase.interfaces.CartCheckoutQueueSender;
import io.vavr.control.Either;

public interface WarehouseInventory {
    Either<BestPurchaseAppException, Integer> updateQuantityForItem(Item item, int quantity);
    CartCheckoutQueueReceiver getCheckoutQueueReceiver();
}
