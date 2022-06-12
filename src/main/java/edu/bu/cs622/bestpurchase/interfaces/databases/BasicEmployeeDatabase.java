package edu.bu.cs622.bestpurchase.interfaces.databases;

import edu.bu.cs622.bestpurchase.entities.persons.Employee;
import edu.bu.cs622.bestpurchase.entities.ids.IdType;

import javax.inject.Inject;
import javax.inject.Singleton;

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
