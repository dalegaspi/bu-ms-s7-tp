package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.IdType;
import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;

public class QRItemLookup {

    @Inject
    public QRItemLookup() {
    }

    public Either<BestPurchaseAppException, IdType> convertQRCodeToItemId(Object qrcode) {
        return Either.right(new IdType());
    }
}
