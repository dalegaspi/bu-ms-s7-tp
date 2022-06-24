package edu.bu.cs682.bestpurchase.interfaces.recommenders;

import edu.bu.cs682.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs682.bestpurchase.entities.store.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Recommended items
 *
 * @author dlegaspi@bu.edu
 */
public class RecommendedItems implements Serializable {
    private List<Item> items;
    private CustomerProfile profile;

    public RecommendedItems(CustomerProfile profile, List<Item> items) {
        this.items = new ArrayList<>(items);
        this.profile = profile;
    }

    public CustomerProfile getProfile() {
        return profile;
    }

    public void setProfile(CustomerProfile profile) {
        this.profile = profile;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
