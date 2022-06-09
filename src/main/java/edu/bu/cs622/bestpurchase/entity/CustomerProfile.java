package edu.bu.cs622.bestpurchase.entity;

import edu.bu.cs622.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;

public class CustomerProfile {
    private String userName;
    private byte[] passwordHash;

    private Object recommenderData;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    Either<BestPurchaseAppException, Boolean> authenticate() {
        return Either.right(true);
    }
}
