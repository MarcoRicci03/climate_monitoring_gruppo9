package classi;

/**
 * Classe Singleton che fornisce un'istanza condivisa per la gestione delle interazioni con il database.
 * Questa classe garantisce che esista una sola istanza di DatiCondivisi nell'intera applicazione.
 *
 * @autor marco_ricci
 * @autor edoardo_rizzi
 * @autor alberto_stagno
 * @autor denis_di_napoli
 */
public class DatiCondivisi {
    private static DatiCondivisi instance = null;

    /**
     * Interfaccia del gestore del database per gestire le operazioni sul database.
     */
    public DBInterface gestore_db;

    /**
     * Costruttore privato per prevenire l'istanza della classe.
     */
    private DatiCondivisi() {

    }

    /**
     * Restituisce l'istanza Singleton di DatiCondivisi.
     * Se l'istanza non esiste, ne crea una.
     *
     * @return L'istanza Singleton di DatiCondivisi.
     */
    public static DatiCondivisi getInstance() {
        if (instance == null) {
            instance = new DatiCondivisi();
        }
        return instance;
    }
}
