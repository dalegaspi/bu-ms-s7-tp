package edu.bu.cs622.bestpurchase.interfaces.hardware;

import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.awt.image.BufferedImage;

public interface Camera {
    Either<BestPurchaseAppException, BufferedImage> scan();
}
