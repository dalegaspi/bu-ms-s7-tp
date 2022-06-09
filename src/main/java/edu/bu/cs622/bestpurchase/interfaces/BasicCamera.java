package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;

/**
 * Camera
 *
 * @author dlegaspi@bu.edu
 */
public class BasicCamera implements Camera {

    @Inject
    public BasicCamera() {

    }

    @Override
    public Either<BestPurchaseAppException, Object> scan() {
        return Either.right(this);
    }
}
