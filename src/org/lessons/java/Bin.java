package org.lessons.java;

public class Bin {
    private String destination;
    private Pacco[] packages;

    public Bin(String destination) {
        this.destination = destination;
        this.packages = new Pacco[5];
    }

    public String getDestination() {
        return this.destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Pacco[] getPackages() {
        return this.packages;
    }

    public void setPackages(Pacco[] packages) {
        this.packages = packages;
    }

    @Override
    public String toString() {
        return String.format("%s", destination);
    }
}
