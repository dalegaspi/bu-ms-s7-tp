package edu.bu.cs622.bestpurchase.interfaces.databases;

import edu.bu.cs622.bestpurchase.entities.persons.Customer;
import edu.bu.cs622.bestpurchase.entities.ids.IdType;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.util.Optional;

public interface CustomerDatabase extends EntityDatabase<IdType, Customer> {

    Either<BestPurchaseAppException, Optional<Customer>> searchByUsername(String username);
}
