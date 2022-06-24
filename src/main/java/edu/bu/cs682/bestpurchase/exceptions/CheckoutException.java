package edu.bu.cs682.bestpurchase.exceptions;

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
