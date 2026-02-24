package org.lessons.java;

public class CentroSmistamento {
    private static Pacco[] nastroTrasportatore = new Pacco[20];
    private static Pacco[] waitingArea = new Pacco[10];
    private static Bin[] bins = new Bin[3];

    public static void smistaPacco(Pacco[] source, int index, boolean isWaitingArea) {
        String paccoCity = source[index].getDestination().getCity();
        boolean isAdded = false;

        for (int i = 0; i < bins.length && !isAdded; i++) {
            if (!paccoCity.equals(bins[i].getDestination())) {
                continue;
            }

            Pacco[] slots = bins[i].getPackages();

            for (int j = 0; j < slots.length; j++) {
                if (slots[j] == null) {
                    slots[j] = source[index];
                    source[index] = null;
                    isAdded = true;
                    break;
                }
            }
        }

        if (!isAdded && !isWaitingArea) {
            for (int i = 0; i < waitingArea.length; i++) {
                if (waitingArea[i] == null) {
                    waitingArea[i] = source[index];
                    source[index] = null;
                    isAdded = false;
                    break;
                }
            }
        }
    }

    public static void smista() {
        for (int i = 0; i < nastroTrasportatore.length; i++) {
            if (nastroTrasportatore[i] == null || !(nastroTrasportatore[i] instanceof PaccoUrgente)) {
                continue;
            }
            smistaPacco(nastroTrasportatore, i, false);
        }

        for (int i = 0; i < nastroTrasportatore.length; i++) {
            if (nastroTrasportatore[i] == null) {
                continue;
            }
            smistaPacco(nastroTrasportatore, i, false);
        }

        for (int i = 0; i < waitingArea.length; i++) {
            if (waitingArea[i] == null) {
                continue;
            }
            smistaPacco(waitingArea, i, true);
        }
    }

    public static void stampaStatoBins() {
        for (Bin bin : bins) {
            System.out.println("Bin: " + bin);
            for (Pacco pacco : bin.getPackages()) {
                if (pacco != null) {
                    System.out.println(" + " + pacco);
                }
            }
            System.out.println();
        }
    }

    public static void stampaStatoWaitingArea() {
        System.out.println("Area di attesa: ");
        for (Pacco pacco : waitingArea) {
            if (pacco != null) {
                System.out.println(" + " + pacco);
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {

        bins[0] = new Bin("Napoli");
        bins[1] = new Bin("Catania");
        bins[2] = new Bin("Torino");

        nastroTrasportatore[0] = new PaccoStandard("1341", 2.3, new Destinazione("Napoli", "via Roma, 21"));
        nastroTrasportatore[1] = new PaccoStandard("31415", 10.0, new Destinazione("Napoli", "via Repubblica, 211"));
        nastroTrasportatore[11] = new PaccoStandard("451", 1.5, new Destinazione("Napoli", "via Roma, 11"));
        nastroTrasportatore[14] = new PaccoStandard("665", 1.0, new Destinazione("Napoli", "via Roma, 11"));
        nastroTrasportatore[16] = new PaccoStandard("1121", 1.0, new Destinazione("Napoli", "via Roma, 11"));
        nastroTrasportatore[17] = new PaccoStandard("131", 1.0, new Destinazione("Napoli", "via Roma, 11"));

        nastroTrasportatore[2] = new PaccoFragile("414", 1.2, new Destinazione("Catania", "via Albanese, 11"));
        nastroTrasportatore[3] = new PaccoStandard("151", 0.8, new Destinazione("Catania", "via Etnea, 121"));
        nastroTrasportatore[4] = new PaccoUrgente("4444", 1.1, new Destinazione("Catania", "via Borromei, 213"));

        nastroTrasportatore[5] = new PaccoUrgente("5111", 5.1, new Destinazione("Torino", "Corso Giulio Cesare, 121"));
        nastroTrasportatore[6] = new PaccoStandard("31", 11.3, new Destinazione("Torino", "via Annibale, 51"));
        nastroTrasportatore[7] = new PaccoFragile("1511", 1.9, new Destinazione("Torino", "via Roma, 11"));
        nastroTrasportatore[8] = new PaccoStandard("111", 4.5, new Destinazione("Torino", "via Po, 4"));
        nastroTrasportatore[9] = new PaccoStandard("222", 3.2, new Destinazione("Torino", "via Cavour, 15"));
        nastroTrasportatore[10] = new PaccoStandard("333", 2.1, new Destinazione("Torino", "via Fellini, 251"));

        smista();
        stampaStatoBins();
        stampaStatoWaitingArea();

        bins[0].getPackages()[0] = null;
        smista();
        System.out.println("Dopo aver rimosso un pacco dal bin di Napoli\n");
        stampaStatoBins();
        stampaStatoWaitingArea();
    }
}
