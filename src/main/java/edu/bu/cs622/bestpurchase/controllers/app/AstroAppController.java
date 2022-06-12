package edu.bu.cs622.bestpurchase.controllers.app;

import edu.bu.cs622.bestpurchase.controllers.store.StoreBusinessLayer;
import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.entities.store.ShoppingCart;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import edu.bu.cs622.bestpurchase.interfaces.databases.CustomerDatabase;
import edu.bu.cs622.bestpurchase.interfaces.hardware.Camera;
import edu.bu.cs622.bestpurchase.interfaces.qrcode.QRItemLookup;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.util.Optional;

/**
 * Astro app controller
 *
 * @author dlegaspi@bu.edu
 */
public class AstroAppController {
    private final StoreBusinessLayer storeBusinessLayer;
    private final CustomerDatabase customerDatabase;

    private final Camera camera;

    private final QRItemLookup qrItemLookup;

    @Inject
    public AstroAppController(StoreBusinessLayer storeBusinessLayer,
                    Camera camera,
                    QRItemLookup qrItemLookup,
                    CustomerDatabase customerDatabase) {
        this.storeBusinessLayer = storeBusinessLayer;
        this.customerDatabase = customerDatabase;
        this.camera = camera;
        this.qrItemLookup = qrItemLookup;
    }

    public Either<BestPurchaseAppException, Item> scanWithCamera() {
        var qrCodeImage = camera.scan();
        return qrCodeImage.flatMap(qrItemLookup::convertQRCodeToItemId)
                .flatMap(storeBusinessLayer::lookupByItemId);
    }

    public Either<BestPurchaseAppException, Optional<Customer>> authenticate(String username, String password) {
        return customerDatabase.searchByUsername(username)
                        .map(customer -> customer.map(Customer::getProfile)
                                        .map(p -> p.authenticate(password).isRight())
                                        .orElse(false) ? customer : Optional.empty());
    }

    public Either<BestPurchaseAppException, ShoppingCart> addItemToCart(final ShoppingCart cart,
                    final Item item,
                    final int quantity) {
        cart.addItemToCart(item, quantity);
        return Either.right(cart);
    }

    public StoreBusinessLayer getStoreBusinessLayer() {
        return storeBusinessLayer;
    }

    public CustomerDatabase getCustomerDatabase() {
        return customerDatabase;
    }
}
