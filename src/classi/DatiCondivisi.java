package classi;

import java.util.ArrayList;

/**
 * Classe singleton che contiene i dati condivisi utilizzati dall'applicazione.
 * <p>
 * Questa classe implementa il pattern Singleton per assicurare che esista solo una
 * istanza di `DatiCondivisi`. Contiene i dati e i metodi necessari per gestire
 * le informazioni condivise, come la gestione del database.
 * </p>
 *
 * <p>Esempio di utilizzo:</p>
 * <pre>
 *     DatiCondivisi dati = DatiCondivisi.getInstance();
 *     dati.gestore_db = new DBInterfaceImplementation();
 * </pre>
 *
 * @autor marco_ricci
 * @autor edoardo_rizzi
 * @autor alberto_stagno
 * @autor denis_di_napoli
 */
public class DatiCondivisi {
    /**
     * L'unica istanza della classe DatiCondivisi.
     */
    private static DatiCondivisi instance = null;

    /**
     * Interfaccia per la gestione del database.
     */
    public DBInterface gestore_db;

    /**
     * Costruttore privato per il pattern singleton.
     * Inizializza la lista di nazioni.
     */
    private DatiCondivisi() {

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
