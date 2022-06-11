package edu.bu.cs622.bestpurchase.entities.persons;

import edu.bu.cs622.bestpurchase.entities.ids.IdType;

import java.io.Serializable;

/**
 * Person
 *
 * @author dlegaspi@bu.edu
 */
public abstract class Person implements Serializable {
    private IdType id;
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
