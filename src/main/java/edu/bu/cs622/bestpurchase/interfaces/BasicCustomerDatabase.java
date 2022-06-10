package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.Customer;
import edu.bu.cs622.bestpurchase.entities.IdType;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.*;

@Singleton
public class BasicCustomerDatabase extends AbstractBasicDatabase<IdType, Customer> implements CustomerDatabase {

    @Inject
    public BasicCustomerDatabase() {
        super();
    }

    IdType getPrimaryKey(Customer entity) {
        return entity.getId();
    }

    @Override
    public Either<BestPurchaseAppException, Optional<Customer>> searchByUsername(String username) {
        return Either.right(data.values().stream()
                        .filter(c -> c.getProfile().getUserName().equalsIgnoreCase(username))
                        .findAny());
    }
}
