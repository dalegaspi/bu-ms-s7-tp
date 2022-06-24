package edu.bu.cs682.bestpurchase.interfaces.hardware;

import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.awt.image.BufferedImage;

public interface Camera {
    Either<BestPurchaseAppException, BufferedImage> scan();
}
