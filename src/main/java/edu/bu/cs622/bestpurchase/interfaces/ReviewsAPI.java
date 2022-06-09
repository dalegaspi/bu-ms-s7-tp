package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.ItemReview;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.util.List;

public class ReviewsAPI {

    @Inject
    public ReviewsAPI() {

    }

    public Either<BestPurchaseAppException, List<ItemReview>> getReviewsForItem(Item item) {
        return Either.right(List.of());
    }
}
