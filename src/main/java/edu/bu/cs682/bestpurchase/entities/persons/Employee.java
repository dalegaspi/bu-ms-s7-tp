package edu.bu.cs682.bestpurchase.entities.persons;

import java.io.Serializable;
import java.util.List;

/**
 * Employee
 *
 * @author dlegaspi@bu.edu
 * @see Person
 */
public class Employee extends Person implements Serializable {
    public Employee(String firstName, String lastName) {
        super(firstName, lastName);
    }

    private String title;
    private Employee supervisor;
    private List<Employee> subordinates;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Employee getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Employee supervisor) {
        this.supervisor = supervisor;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(List<Employee> subordinates) {
        this.subordinates = subordinates;
    }
}
