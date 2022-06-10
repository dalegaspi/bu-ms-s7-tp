package edu.bu.cs622.bestpurchase.exceptions;

public class AuthenticationException extends BestPurchaseAppException {
    public AuthenticationException() {
    }

    public AuthenticationException(String s) {
        super(s);
    }

    public AuthenticationException(String s, Throwable t) {
        super(s, t);
    }
}
