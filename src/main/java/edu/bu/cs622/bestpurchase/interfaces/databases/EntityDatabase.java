package edu.bu.cs622.bestpurchase.interfaces.databases;

import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.util.Collection;
import java.util.Optional;

public interface EntityDatabase<K, V> {
    Either<BestPurchaseAppException, Integer> insert(Collection<V> customers);

    Either<BestPurchaseAppException, Optional<V>> lookupById(K customerId);
}
