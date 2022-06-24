package edu.bu.cs682.bestpurchase.interfaces.databases;

import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public abstract class AbstractBasicDatabase<K, V> implements EntityDatabase<K, V> {
    protected Map<K, V> data;

    abstract K getPrimaryKey(V entity);

    public AbstractBasicDatabase() {
        data = new HashMap<>();
    }

    public Either<BestPurchaseAppException, Integer> insert(Collection<V> entities) {
        entities.forEach(e -> data.put(getPrimaryKey(e), e));

        return Either.right(data.size());
    }

    public Either<BestPurchaseAppException, Optional<V>> lookupById(K id) {
        return Either.right(Optional.ofNullable(data.get(id)));
    }
}
