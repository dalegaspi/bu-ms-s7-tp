package edu.bu.cs682.bestpurchase.entities.store;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

/**
 * Item category
 *
 * @author dlegaspi@bu.edu
 */
public class ItemCategory implements Serializable {

    @Inject
    public ItemCategory() {

    }

    private ItemCategory superCategory;
    private List<ItemCategory> subCategories;

    public ItemCategory getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(ItemCategory superCategory) {
        this.superCategory = superCategory;
    }

    public List<ItemCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<ItemCategory> subCategories) {
        this.subCategories = subCategories;
    }
}
