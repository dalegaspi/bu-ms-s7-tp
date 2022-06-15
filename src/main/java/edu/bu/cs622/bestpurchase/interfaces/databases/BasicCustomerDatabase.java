package edu.bu.cs622.bestpurchase.interfaces.databases;

import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.store.IdType;
import edu.bu.cs622.bestpurchase.entities.persons.CustomerProfile;
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

        // set up the user db
        Customer c = new Customer("Pedro", "Sanchez");
        CustomerProfile p = new CustomerProfile();
        p.setCredentials("pedro", "12345");
        c.setProfile(p);

        data.put(new IdType(), c);
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
