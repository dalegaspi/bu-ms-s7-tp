package edu.bu.cs622.bestpurchase.entities.store;

import java.io.Serializable;

/**
 * Item cart status
 *
 * @author dlegaspi@bu.edu
 */
public class ItemCartStatus implements Serializable {
    private int quantity;
    private boolean isFulfilled;

    public ItemCartStatus(int quantity, boolean isFulfilled) {
        this.quantity = quantity;
        this.isFulfilled = isFulfilled;
    }

    public boolean isFulfilled() {
        return isFulfilled;
    }

    public void setFulfilled(boolean fulfilled) {
        isFulfilled = fulfilled;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
