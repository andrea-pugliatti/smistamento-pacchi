package org.lessons.java;

public class PaccoUrgente extends Pacco {

    public PaccoUrgente(String code, double weight, Destinazione destination) {
        super(code, weight, destination);
    }

    public double calcolaCostoSpedizione() {
        return this.getWeight() * 2.0;
    }
}
