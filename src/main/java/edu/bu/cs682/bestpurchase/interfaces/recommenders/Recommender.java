package edu.bu.cs682.bestpurchase.interfaces.recommenders;

import edu.bu.cs682.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs682.bestpurchase.entities.store.Item;
import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

public interface Recommender {
    Either<BestPurchaseAppException, RecommendedItems> getRecommendations(Item item, CustomerProfile profile);
}
