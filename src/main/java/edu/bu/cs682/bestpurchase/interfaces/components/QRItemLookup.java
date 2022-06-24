package edu.bu.cs682.bestpurchase.interfaces.components;

import edu.bu.cs682.bestpurchase.entities.store.IdType;
import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.awt.image.BufferedImage;

public interface QRItemLookup {
    Either<BestPurchaseAppException, IdType> convertQRCodeToItemId(BufferedImage qrcode);
}
