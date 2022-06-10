package edu.bu.cs622.bestpurchase.interfaces;

import edu.bu.cs622.bestpurchase.entities.Employee;
import edu.bu.cs622.bestpurchase.entities.IdType;
import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Optional;

@Singleton
public class BasicEmployeeDatabase extends AbstractBasicDatabase<IdType, Employee> implements EmployeeDatabase {

    @Inject
    public BasicEmployeeDatabase() {

    }

    @Override
    IdType getPrimaryKey(Employee entity) {
        return entity.getId();
    }
}
