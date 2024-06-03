package classi;

import java.util.ArrayList;

/**
 * Classe singleton che contiene i dati condivisi utilizzati dall'applicazione.
 */
public class DatiCondivisi {
    private static DatiCondivisi instance = null;

    /**
     * Lista di nazioni condivise.
     */
    public ArrayList<JNazione> nazioni;

    /**
     * Interfaccia per la gestione del database.
     */
    public DBInterface gestore_db;

    /**
     * Costruttore privato per il pattern singleton.
     * Inizializza la lista di nazioni.
     */
    private DatiCondivisi() {
        nazioni = new ArrayList<>();
    }

    /**
     * Restituisce l'istanza singleton di DatiCondivisi.
     *
     * @return l'istanza di DatiCondivisi.
     */
    public static DatiCondivisi getInstance() {
        if (instance == null) {
            instance = new DatiCondivisi();
        }
        return instance;
    }
}
