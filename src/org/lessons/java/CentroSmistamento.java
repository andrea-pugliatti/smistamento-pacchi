package org.lessons.java;

public class CentroSmistamento {
    private static Pacco[] nastroTrasportatore = new Pacco[10];
    private static Bin[] bins = new Bin[3];

    public static void smista() {
        for (int i = 0; i < nastroTrasportatore.length; i++) {
            if (nastroTrasportatore[i] == null) {
                continue;
            }

            String paccoCity = nastroTrasportatore[i].getDestination().getCity();
            boolean isAdded = false;

            for (int j = 0; j < bins.length && !isAdded; j++) {
                if (!paccoCity.equals(bins[j].getDestination())) {
                    continue;
                }

                Pacco[] slots = bins[j].getPackages();

                for (int k = 0; k < slots.length; k++) {
                    if (slots[k] == null) {
                        slots[k] = nastroTrasportatore[i];
                        nastroTrasportatore[i] = null;
                        isAdded = true;
                        break;
                    }
                }
            }

        }
    }

    public static void stampaStatoBins() {
        for (Bin bin : bins) {
            System.out.printf("Bin: %s\n", bin);

            for (Pacco pacco : bin.getPackages()) {
                if (pacco == null) {
                    continue;
                }

                System.out.println(pacco.toString());
            }
        }
    }

    public static void main(String[] args) {

        bins[0] = new Bin("Napoli");
        bins[1] = new Bin("Catania");
        bins[2] = new Bin("Torino");

        nastroTrasportatore[0] = new PaccoStandard("1341", 2.3, new Destinazione("Napoli", "via Roma, 21"));

        nastroTrasportatore[2] = new PaccoFragile("414", 1.2, new Destinazione("Catania", "via Albanese, 11"));

        nastroTrasportatore[3] = new PaccoUrgente("5111", 5.1, new Destinazione("Torino", "Corso Giulio Cesare, 121"));

        nastroTrasportatore[4] = new PaccoStandard("31", 11.3, new Destinazione("Torino", "via Annibale, 51"));

        nastroTrasportatore[5] = new PaccoFragile("1511", 1.9, new Destinazione("Torino", "via Roma, 11"));

        nastroTrasportatore[7] = new PaccoStandard("151", 0.8, new Destinazione("Catania", "via Etnea, 121"));

        nastroTrasportatore[8] = new PaccoUrgente("4444", 1.1, new Destinazione("Catania", "via Borromei, 213"));

        nastroTrasportatore[9] = new PaccoStandard("31415", 10.0, new Destinazione("Napoli", "via Repubblica, 211"));

        smista();

        stampaStatoBins();

    }
}
