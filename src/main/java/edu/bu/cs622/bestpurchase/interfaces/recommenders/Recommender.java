package edu.bu.cs622.bestpurchase.interfaces.recommenders;

import edu.bu.cs622.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs622.bestpurchase.entities.store.Item;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

public interface Recommender {
    Either<BestPurchaseAppException, RecommendedItems> getRecommendations(Item item, CustomerProfile profile);
}
