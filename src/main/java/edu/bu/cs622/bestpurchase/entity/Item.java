package edu.bu.cs622.bestpurchase.entity;

import java.math.BigDecimal;
import java.util.List;

public class Item {
    private IdType id;
    private String description;
    private String unitOfMeasure;
    private BigDecimal price;
    private List<ItemCategory> categories;

    public IdType getId() {
        return id;
    }

    public String getDescription() {
        return description;
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
}
