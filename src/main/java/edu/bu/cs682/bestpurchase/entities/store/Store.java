package edu.bu.cs682.bestpurchase.entities.store;

import edu.bu.cs682.bestpurchase.entities.locations.AddressLocation;
import edu.bu.cs682.bestpurchase.entities.persons.Customer;
import edu.bu.cs682.bestpurchase.entities.persons.Employee;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Store
 *
 * @author dlegaspi@bu.edu
 */
public class Store implements Serializable {
    @Inject
    public Store() {
        activeShoppers = new ArrayList<>();
        employees = new ArrayList<>();
    }

    private Warehouse warehouse;
    private AddressLocation location;
    private List<Employee> employees;
    private List<Customer> activeShoppers;

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    public AddressLocation getLocation() {
        return location;
    }

    public void setLocation(AddressLocation location) {
        this.location = location;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Customer> getActiveShoppers() {
        return activeShoppers;
    }

    public void setActiveShoppers(List<Customer> activeShoppers) {
        assert activeShoppers != null;

        this.activeShoppers = activeShoppers;
    }
}
