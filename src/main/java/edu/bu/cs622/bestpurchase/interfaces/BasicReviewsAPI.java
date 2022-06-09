package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.ItemReview;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.util.List;

/**
 * Reviews API
 *
 * @author dlegaspi@bu.edu
 */
public class BasicReviewsAPI implements ReviewsAPI {

    @Inject
    public BasicReviewsAPI() {

    }

    @Override
    public Either<BestPurchaseAppException, List<ItemReview>> getReviewsForItem(Item item) {
        return Either.right(List.of());
    }
}
