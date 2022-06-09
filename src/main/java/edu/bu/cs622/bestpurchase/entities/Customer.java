package edu.bu.cs622.bestpurchase.entities;

import java.util.List;

public class Customer extends Person {
    private CustomerProfile profile;
    private Store currentStoreLocation;
    private ShoppingCart cart;
    private AddressLocation billingAddress;
    private List<AddressLocation> shippingAddresses;

    public Customer(String firstName, String lastName) {
        super(firstName, lastName);
    }

    public CustomerProfile getProfile() {
        return profile;
    }

    public void setProfile(CustomerProfile profile) {
        this.profile = profile;
    }

    public Store getCurrentStoreLocation() {
        return currentStoreLocation;
    }

    public void setCurrentStoreLocation(Store currentStoreLocation) {
        this.currentStoreLocation = currentStoreLocation;
    }

    public ShoppingCart getCart() {
        return cart;
    }

    public void setCart(ShoppingCart cart) {
        this.cart = cart;
    }

    public AddressLocation getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(AddressLocation billingAddress) {
        this.billingAddress = billingAddress;
    }

    public List<AddressLocation> getShippingAddresses() {
        return shippingAddresses;
    }

    public void setShippingAddresses(List<AddressLocation> shippingAddresses) {
        this.shippingAddresses = shippingAddresses;
    }
}
