package edu.bu.cs622.bestpurchase.exceptions;

public class CheckoutException extends BestPurchaseAppException {
    public CheckoutException() {
    }

    public CheckoutException(String s) {
        super(s);
    }

    public CheckoutException(String s, Throwable t) {
        super(s, t);
    }
}
