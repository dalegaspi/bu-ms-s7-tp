package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.Customer;
import edu.bu.cs622.bestpurchase.entities.IdType;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import java.util.Collection;
import java.util.Optional;

public interface CustomerDatabase {

    Either<BestPurchaseAppException, Integer> insert(Collection<Customer> customers);

    Either<BestPurchaseAppException, Optional<Customer>> lookupById(IdType customerId);

    Either<BestPurchaseAppException, Optional<Customer>> searchByUsername(String username);
}
