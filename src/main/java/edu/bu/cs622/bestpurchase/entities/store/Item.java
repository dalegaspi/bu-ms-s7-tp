package edu.bu.cs622.bestpurchase.entities.store;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

/**
 * Item for the store
 *
 * @author dlegaspi@bu.edu
 */
public class Item implements Serializable {
    private IdType id;
    private String description;
    private String unitOfMeasure;
    private BigDecimal price;
    private List<ItemCategory> categories;

    private String brand;

    public Item(IdType id, String brand, String description, double price) {
        this.id = id;
        this.brand = brand;
        this.description = description;
        this.price = BigDecimal.valueOf(price);
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    public String getDescription() {
        return brand + " " + description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<ItemCategory> getCategories() {
        return categories;
    }

    public void setCategories(List<ItemCategory> categories) {
        this.categories = categories;
    }

    public String getDetails() {
        return getDescription() + " @ " + getPrice();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;

        if (obj instanceof Item) {
            return ((Item) obj).getId().equals(this.getId());
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description);
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
