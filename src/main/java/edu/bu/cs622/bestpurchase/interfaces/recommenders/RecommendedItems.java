package edu.bu.cs622.bestpurchase.interfaces.recommenders;

import edu.bu.cs622.bestpurchase.entities.persons.CustomerProfile;
import edu.bu.cs622.bestpurchase.entities.store.Item;

import java.io.Serializable;
import java.util.List;

/**
 * Recommended items
 *
 * @author dlegaspi@bu.edu
 */
public class RecommendedItems implements Serializable {
    private List<Item> items;
    private CustomerProfile profile;

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
