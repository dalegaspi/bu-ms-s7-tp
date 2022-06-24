package edu.bu.cs682.bestpurchase.exceptions;

/**
 * Base class exception
 *
 * @author dlegaspi@bu.edu
 */
public class BestPurchaseAppException extends Exception {
    public BestPurchaseAppException() {
        super();
    }

    public BestPurchaseAppException(String s) {
        super(s);
    }

    public BestPurchaseAppException(String s, Throwable t) {
        super(s, t);
    }
}
