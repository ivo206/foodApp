package com.ivo.rakar.foodapp.restaurant.domain.models;

public class Location {

    private String locationName;
    private double longitude;
    private double latitude;

    public Location() {
    }

    public Location(String name, double longitude, double latitude) {
        this.locationName = name;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

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
