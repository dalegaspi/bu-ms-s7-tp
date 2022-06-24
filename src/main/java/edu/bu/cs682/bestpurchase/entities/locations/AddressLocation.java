package edu.bu.cs682.bestpurchase.entities.locations;

import edu.bu.cs682.bestpurchase.entities.store.IdType;

import java.io.Serializable;

/**
 * Address location
 *
 * @author dlegaspi@bu.edu
 */
public class AddressLocation implements Serializable {
    private IdType id;
    private String address;
    private String city;
    private String zipCode;
    private String country;

    private GPSCoordinates coordinates;

    public IdType getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public GPSCoordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(GPSCoordinates coordinates) {
        this.coordinates = coordinates;
    }
}
