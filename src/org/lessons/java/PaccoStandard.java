package org.lessons.java;

public class PaccoStandard extends Pacco {

    public PaccoStandard(String code, double weight, Destinazione destination) {
        super(code, weight, destination);
    }

    public double calcolaCostoSpedizione() {
        return this.getWeight() * 1.0;
    }
}
