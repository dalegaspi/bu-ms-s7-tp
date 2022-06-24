package edu.bu.cs682.bestpurchase.entities.persons;

import edu.bu.cs682.bestpurchase.exceptions.BestPurchaseAppException;
import io.vavr.control.Either;
import io.vavr.control.Try;

import java.io.Serializable;
import java.security.MessageDigest;
import java.util.Arrays;

/**
 * Customer profile
 *
 * @author dlegaspi@bu.edu
 * @see Person
 */
public class CustomerProfile implements Serializable {

    private String userName;
    private byte[] passwordHash;

    private Object recommenderData;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Either<BestPurchaseAppException, Boolean> authenticate(String password) {
        return createHash(password).map(hash -> Arrays.equals(passwordHash, hash));
    }

    public static Either<BestPurchaseAppException, byte[]> createHash(String data) {
        return Try.of(() -> MessageDigest.getInstance("MD5"))
                        .toEither()
                        .mapLeft(t -> new BestPurchaseAppException("Unable to create MD5 MessageDigest", t))
                        .map(d -> {
                            d.update(data.getBytes());
                            return d.digest();
                        });
    }

    public Either<BestPurchaseAppException, Void> setCredentials(String username, String password) {
        this.setUserName(username);
        return createHash(password).map(hash -> {
            this.passwordHash = hash;
            return null;
        });
    }

    public Object getRecommenderData() {
        return recommenderData;
    }

    public void setRecommenderData(Object recommenderData) {
        this.recommenderData = recommenderData;
    }
}
