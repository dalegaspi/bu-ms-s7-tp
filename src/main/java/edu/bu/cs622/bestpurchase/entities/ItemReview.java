package edu.bu.cs622.bestpurchase.entities;

import java.io.Serializable;

/**
 * Item review
 *
 * @author dlegaspi@bu.edu
 */
public class ItemReview implements Serializable {
    private Item item;
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
