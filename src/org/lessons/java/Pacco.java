package org.lessons.java;

import java.security.InvalidParameterException;

public abstract class Pacco {
    private String code;
    private double weight;
    private Destinazione destination;

    public Pacco(String code, double weight, Destinazione destination) {
        if (code == null || destination == null) {
            throw new InvalidParameterException();
        }

        this.code = code;
        this.weight = weight;
        this.destination = destination;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code == null) {
            throw new InvalidParameterException();
        }

        this.code = code;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Destinazione getDestination() {
        return destination;
    }

    public void setDestination(Destinazione destination) {
        if (destination == null) {
            throw new InvalidParameterException();
        }

        this.destination = destination;
    }

    abstract double calcolaCostoSpedizione();

    @Override
    public String toString() {
        return String.format("Code: %s - Weight: %f - Dest: %s", code, weight, destination);
    }

}
