package edu.bu.cs622.bestpurchase.entities;

import java.io.Serializable;

/**
 * GPS coordinates
 *
 * @author dlegaspi@bu.edu
 */
public class GPSCoordinates implements Serializable {

    private double longitude;
    private double latitude;

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
