# Centro di Smistamento Pacchi

Obiettivo: Simulare la logica di un centro di smistamento automatizzato. I pacchi arrivano su un nastro trasportatore e devono essere indirizzati nei contenitori (bin) corretti in base alla loro destinazione, applicando i concetti di ereditarietà, composizione e polimorfismo.

## Parte 1: L'Architettura del Sistema

Dovrai creare le seguenti classi per modellare il nostro centro di smistamento.

1. Classi per i Pacchi (Ereditarietà)

    Destinazione: Una semplice classe con attributi citta e indirizzo.

    Pacco (classe astratta):

        Attributi: codice (String), peso (double).

        Composizione: Contiene un oggetto Destinazione.

        Metodo astratto: double calcolaCostoSpedizione().

    PaccoStandard: Estende Pacco. Il costo è peso * 1.0.

    PaccoFragile: Estende Pacco. Il costo è peso * 1.5 + 5.0 (costo fisso per la gestione).

    PaccoUrgente: Estende Pacco. Il costo è peso * 2.0.

2. Classi per il Centro (Composizione)

    Bin: Rappresenta un contenitore di destinazione.

        Attributi: destinazioneAssociata (String, es. "Milano", "Roma").

        Composizione: Contiene un array di Pacco[] pacchiContenuti con una capacità fissa (es. 5).

    CentroSmistamento: La classe principale che orchestra tutto.

        Composizione: Contiene un Pacco[] nastroTrasportatore (es. 10 posti).

        Composizione: Contiene un Bin[] bins (es. 3 bin per "Milano", "Roma", "Napoli").

## Parte 2: Il Problema Logico (Smistamento)

Scopo: Implementare la logica per spostare i pacchi dal nastroTrasportatore al Bin corretto.

Nel main del CentroSmistamento:

    Setup: Crea istanze di Bin per alcune destinazioni. Crea vari tipi di Pacco (Standard, Fragile, Urgente) e posizionali in modo sparso sul nastroTrasportatore.

 Logica Principale: Implementa un metodo smista():

    Scorri l'array nastroTrasportatore.

    Per ogni Pacco trovato:

        Leggi la città della sua Destinazione.

        Trova il Bin corrispondente nell'array bins.

        Aggiungi il pacco nel primo slot libero dell'array pacchiContenuti di quel Bin.

        Rimuovi il pacco dal nastro (impostando la sua posizione a null).

    Verifica: Crea un metodo stampaStatoBins() che mostri il contenuto di ogni bin alla fine dello smistamento, per verificare che la logica abbia funzionato correttamente.

Possibili Estensioni (da discutere dopo aver completato il nucleo)

- Estensione 1 (Medio-Difficile): Smistamento per Priorità

    Problema: I pacchi urgenti devono avere la precedenza. Modifica la logica di smista() in modo che processi prima tutti i PaccoUrgente presenti sul nastro, e solo dopo tutti gli altri. Questo richiede di non scorrere più il nastro una sola volta in modo sequenziale.

- Estensione 2 (Difficile): Gestione "Bin Pieno"

    Problema: Cosa succede se il Bin per Milano è pieno ma sul nastro c'è un altro pacco per Milano?

    Soluzione: Crea un' "area di attesa" (un altro array di Pacco[]). Se un pacco non può essere smistato perché il suo bin è pieno, spostalo nell'area di attesa. Dopo un primo ciclo di smistamento, il sistema deve tentare di smistare i pacchi in attesa, ripetendo il processo finché l'area di attesa non si svuota o non è più possibile smistare nulla.