package edu.bu.cs622.bestpurchase.interfaces.hardware;

import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;
import io.vavr.control.Try;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.image.BufferedImage;

/**
 * Camera that returns a static image from resource file
 *
 * @author dlegaspi@bu.edu
 */
public class BasicCameraSimulator implements Camera {

    @Inject
    public BasicCameraSimulator() {

    }

    @Override
    public Either<BestPurchaseAppException, BufferedImage> scan() {
        return Try.of(() -> {
            var stream = this.getClass().getResourceAsStream("/qrcodes/001.png");
            var bufferedImage = ImageIO.read(stream);
            stream.close();
            return bufferedImage;
        }).toEither().mapLeft(t -> new BestPurchaseAppException("Unable to read QR Code", t));
    }
}
