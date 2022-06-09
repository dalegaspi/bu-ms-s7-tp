package edu.bu.cs622.bestpurchase.entities;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ShoppingCart {
    private IdType id;
    private Map<Item, ItemCartStatus> items;
    private List<Employee> fulfillers;

    public ShoppingCart() {
        items = new HashMap<>();
        fulfillers = new ArrayList<>();
    }

    public IdType getId() {
        return id;
    }

    public void setId(IdType id) {
        this.id = id;
    }

    public void addItemToCart(Item item, int quantity) {
        items.put(item, new ItemCartStatus(quantity, false));
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public Collection<Item> getAllItems() {
        return items.keySet();
    }

    public boolean isFulfilled() {
        return items.values().stream().allMatch(ItemCartStatus::isFulfilled);
    }

    public void updateQuantityAndStateForItem(Item item, boolean isFulfilled, int quantity) {
        Optional.of(items.get(item)).ifPresent(i -> {
            i.setFulfilled(isFulfilled);
            i.setQuantity(quantity);
        });
    }
}