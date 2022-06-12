package edu.bu.cs622.bestpurchase.interfaces.qrcode;

import edu.bu.cs622.bestpurchase.entities.ids.IdType;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.awt.image.BufferedImage;

public interface QRItemLookup {
    Either<BestPurchaseAppException, IdType> convertQRCodeToItemId(BufferedImage qrcode);
}
