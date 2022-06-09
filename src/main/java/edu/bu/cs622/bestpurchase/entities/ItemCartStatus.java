package edu.bu.cs622.bestpurchase.entities;

public class ItemCartStatus {
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
