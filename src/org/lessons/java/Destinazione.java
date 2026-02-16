package org.lessons.java;

public class Destinazione {
    private String city;
    private String address;

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return String.format("%s, %s", this.getAddress(), this.getCity());
    }
}
