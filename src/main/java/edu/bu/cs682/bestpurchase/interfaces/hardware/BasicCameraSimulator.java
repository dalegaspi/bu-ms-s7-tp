package edu.bu.cs682.bestpurchase.interfaces.hardware;

import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;
import io.vavr.control.Try;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.imageio.ImageIO;
import javax.inject.Inject;
import java.awt.image.BufferedImage;

/**
 * Camera that returns a static image from resource file
 *
 * @author dlegaspi@bu.edu
 */
public class BasicCameraSimulator implements Camera {
    private static Logger logger = LoggerFactory.getLogger(BasicCameraSimulator.class);
    @Inject
    public BasicCameraSimulator() {
    }

    @Override
    public Either<BestPurchaseAppException, BufferedImage> scan() {
        return Try.of(() -> {
            var stream = this.getClass().getResourceAsStream("/qrcodes/001.png");
            var bufferedImage = ImageIO.read(stream);
            stream.close();
            logger.debug("Returning scanned QR Code.");
            return bufferedImage;
        }).toEither().mapLeft(t -> new BestPurchaseAppException("Unable to read QR Code", t));
    }
}
