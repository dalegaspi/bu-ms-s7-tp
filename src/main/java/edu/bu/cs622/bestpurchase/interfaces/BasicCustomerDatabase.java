package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.Customer;
import edu.bu.cs622.bestpurchase.entities.IdType;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import java.util.*;

public class BasicCustomerDatabase implements CustomerDatabase {

    Map<IdType, Customer> customers;

    @Inject
    public BasicCustomerDatabase() {
        customers = new HashMap<>();
    }

    @Override
    public Either<BestPurchaseAppException, Integer> insert(Collection<Customer> newCustomers) {
        newCustomers.forEach(customer -> customers.put(customer.getId(), customer));

        return Either.right(customers.size());
    }

    @Override
    public Either<BestPurchaseAppException, Optional<Customer>> lookupById(IdType customerId) {
        return Either.right(Optional.ofNullable(customers.get(customerId)));
    }

    @Override
    public Either<BestPurchaseAppException, Optional<Customer>> searchByUsername(String username) {
        return Either.right(customers.values().stream()
                        .filter(c -> c.getProfile().getUserName().equalsIgnoreCase(username))
                        .findAny());
    }
}
