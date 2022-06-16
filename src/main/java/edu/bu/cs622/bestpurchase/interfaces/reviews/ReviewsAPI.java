package edu.bu.cs622.bestpurchase.interfaces.reviews;

import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.util.List;

public interface ReviewsAPI {
    Either<BestPurchaseAppException, List<ItemReview>> getReviewsForItem(Item item);

    Either<BestPurchaseAppException, String> getFormattedItemsSummary(Item item, List<ItemReview> reviews);

}
