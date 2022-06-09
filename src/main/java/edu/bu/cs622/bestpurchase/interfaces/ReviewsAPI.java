package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.ItemReview;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.util.List;

public interface ReviewsAPI {
    Either<BestPurchaseAppException, List<ItemReview>> getReviewsForItem(Item item);
}
