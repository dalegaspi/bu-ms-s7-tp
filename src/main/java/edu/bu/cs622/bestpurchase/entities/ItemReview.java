package edu.bu.cs622.bestpurchase.entities;

/**
 * Item review
 *
 * @author dlegaspi@bu.edu
 */
public class ItemReview {
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
