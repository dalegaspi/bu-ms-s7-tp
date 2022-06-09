package edu.bu.cs622.bestpurchase.entities;

import javax.inject.Inject;
import java.util.List;

/**
 * Item category
 *
 * @author dlegaspi@bu.edu
 */
public class ItemCategory {

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
