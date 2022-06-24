package edu.bu.cs682.bestpurchase.interfaces.reviews;

import edu.bu.cs682.bestpurchase.entities.store.Item;

import java.io.Serializable;

/**
 * Item review
 *
 * @author dlegaspi@bu.edu
 */
public class ItemReview implements Serializable {
    private Item item;
    private String url;

    private int rating;

    private String summary;

    ItemReview(Item item, String url, String summary, int rating) {
        this.item = item;
        this.url = url;
        this.summary = summary;
        setRating(rating);
    }

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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        if (rating > 5 || rating < 1)
            throw new IllegalArgumentException("Rating should be between 1 and 5 inclusive.");
        this.rating = rating;
    }
}
