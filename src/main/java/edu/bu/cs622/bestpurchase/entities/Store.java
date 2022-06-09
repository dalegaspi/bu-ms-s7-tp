package edu.bu.cs622.bestpurchase.entities;

import javax.inject.Inject;
import java.util.List;

public class Store {
    @Inject
    public Store() {

    }

    private Warehouse warehouse;
    private AddressLocation location;
    private List<Employee> employees;
    private List<Employee> activeShoppers;

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

    public List<Employee> getActiveShoppers() {
        return activeShoppers;
    }

    public void setActiveShoppers(List<Employee> activeShoppers) {
        this.activeShoppers = activeShoppers;
    }
}
