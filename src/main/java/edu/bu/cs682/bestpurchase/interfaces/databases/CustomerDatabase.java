package edu.bu.cs682.bestpurchase.interfaces.databases;

import edu.bu.cs682.bestpurchase.entities.persons.Customer;
import edu.bu.cs682.bestpurchase.entities.store.IdType;
import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.util.Optional;

public interface CustomerDatabase extends EntityDatabase<IdType, Customer> {

    Either<BestPurchaseAppException, Optional<Customer>> searchByUsername(String username);
}
