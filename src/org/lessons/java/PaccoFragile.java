package org.lessons.java;

public class PaccoFragile extends Pacco {

    public PaccoFragile(String code, double weight, Destinazione destination) {
        super(code, weight, destination);
    }

    @Override
    public double calcolaCostoSpedizione() {
        return this.getWeight() * 1.5 + 5.0;
    }
}
