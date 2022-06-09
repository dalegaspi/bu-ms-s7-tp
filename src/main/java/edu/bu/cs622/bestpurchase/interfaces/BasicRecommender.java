package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.CustomerProfile;
import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.RecommendedItems;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;

public class BasicRecommender implements Recommender {

    @Inject
    public BasicRecommender() {

    }

    @Override
    public Either<BestPurchaseAppException, RecommendedItems> getRecommendations(Item item, CustomerProfile profile) {
        return Either.right(new RecommendedItems());
    }
}
