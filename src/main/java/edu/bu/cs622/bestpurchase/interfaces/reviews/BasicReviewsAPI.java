package edu.bu.cs622.bestpurchase.interfaces.reviews;

import edu.bu.cs622.bestpurchase.controllers.store.WarehouseInventory;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Reviews API
 *
 * @author dlegaspi@bu.edu
 */
public class BasicReviewsAPI implements ReviewsAPI {

    private List<ItemReview> reviews;

    @Inject
    public BasicReviewsAPI(WarehouseInventory inventory) {
        reviews = inventory.getItems().getOrElse(List.of()).stream()
                        .map(item -> new ItemReview(item, "https://www.engadget.com/", "No summary", 3))
                        .toList();
    }

    @Override
    public Either<BestPurchaseAppException, List<ItemReview>> getReviewsForItem(Item item) {
        return Either.right(reviews);
    }

    @Override
    public Either<BestPurchaseAppException, String> getFormattedItemsSummary(Item item, List<ItemReview> reviews) {
        return Either.right(String.format("%s has %d review(s) with average rating of %d/5.", item.getDescription(),
                        reviews.size(),
                (int) reviews.stream().map(ItemReview::getRating).mapToInt(i -> i).average().orElse(0)));
    }
}
