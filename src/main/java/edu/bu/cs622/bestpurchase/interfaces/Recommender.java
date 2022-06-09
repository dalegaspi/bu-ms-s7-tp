package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.CustomerProfile;
import edu.bu.cs622.bestpurchase.entities.Item;
import edu.bu.cs622.bestpurchase.entities.RecommendedItems;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

public interface Recommender {
    Either<BestPurchaseAppException, RecommendedItems> getRecommendations(Item item, CustomerProfile profile);
}
