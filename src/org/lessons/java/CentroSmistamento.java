package org.lessons.java;

public class CentroSmistamento {
    private Pacco[] nastroTrasportatore;
    private Bin[] bins;

    public CentroSmistamento() {
        this.nastroTrasportatore = new Pacco[10];
        this.bins = new Bin[3];
    }

    public Pacco[] getNastroTrasportatore() {
        return this.nastroTrasportatore;
    }

    public void setNastroTrasportatore(Pacco[] nastroTrasportatore) {
        this.nastroTrasportatore = nastroTrasportatore;
    }

    public Bin[] getBins() {
        return this.bins;
    }

    public void setBins(Bin[] bins) {
        this.bins = bins;
    }
}
