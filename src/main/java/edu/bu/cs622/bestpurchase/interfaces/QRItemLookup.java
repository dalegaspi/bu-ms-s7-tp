package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.IdType;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.awt.image.BufferedImage;

public interface QRItemLookup {
    Either<BestPurchaseAppException, IdType> convertQRCodeToItemId(BufferedImage qrcode);
}
