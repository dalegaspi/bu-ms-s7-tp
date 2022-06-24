package edu.bu.cs682.bestpurchase.interfaces.components;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.common.HybridBinarizer;
import edu.bu.cs682.bestpurchase.entities.store.IdType;
import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;
import io.vavr.control.Try;

import javax.inject.Inject;
import java.awt.image.BufferedImage;
import java.util.UUID;

import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * QR Code Lookup
 */
public class BasicQRItemLookup implements QRItemLookup {
    private static Logger logger = LoggerFactory.getLogger(BasicQRItemLookup.class);

    @Inject
    public BasicQRItemLookup() {
    }

    @Override
    public Either<BestPurchaseAppException, IdType> convertQRCodeToItemId(BufferedImage qrcode) {
        return Try.of(() -> {
            LuminanceSource source = new BufferedImageLuminanceSource(qrcode);
            var bitmap = new BinaryBitmap(new HybridBinarizer(source));

            var result = new MultiFormatReader().decode(bitmap);

            var values = result.getText().split(",");

            assert values.length == 2;

            var id = new IdType(UUID.fromString(values[0]), values[1]);
            logger.debug("Item ID is {}", id);
            return id;
        }).toEither().mapLeft(t -> new BestPurchaseAppException("Unable to read from QR code", t));
    }
}
