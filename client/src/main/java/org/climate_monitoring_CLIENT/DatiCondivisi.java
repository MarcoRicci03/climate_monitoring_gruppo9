package org.climate_monitoring_CLIENT;

import classi.*;

/**
 * Classe Singleton che fornisce un'istanza condivisa per la gestione delle interazioni con il database.
 * Questa classe garantisce che esista una sola istanza di DatiCondivisi nell'intera applicazione.
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class DatiCondivisi {

    /**
     * L'unica istanza della classe DatiCondivisi.
     *
     * @see DatiCondivisi
     */
    private static DatiCondivisi instance = null;

    /**
     * Interfaccia del gestore del database per gestire le operazioni sul database.
     *
     * @see DBInterface
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
