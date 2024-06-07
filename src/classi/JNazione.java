/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * La classe JNazione rappresenta una nazione con il suo nome e codice del paese.
 * Utilizza annotazioni Gson per la serializzazione/deserializzazione JSON.
 * Implementa l'interfaccia Serializable per permettere la serializzazione degli oggetti.
 *
 * <p>Esempio di utilizzo:</p>
 * <pre>
 *     JNazione nazione = new JNazione("IT", "Italia");
 * </pre>
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class JNazione implements Serializable {
    /**
     * Il nome della nazione.
     */
    @SerializedName("nome_nazione")
    private String nome_nazione;
    /**
     * Il codice del paese.
     */
    @SerializedName("country_code")
    private String country_code;

    /**
     * Costruttore che inizializza JNazione con un codice del paese e un nome.
     *
     * @param country_code il codice del paese
     * @param nome         il nome della nazione
     */
    public JNazione(String country_code, String nome) {
        this.country_code = country_code;
        this.nome_nazione = nome;

    }

    /**
     * Restituisce il nome della nazione.
     *
     * @return il nome della nazione
     */
    public String getNome_nazione() {
        return nome_nazione;
    }

    /**
     * Restituisce il codice del paese.
     *
     * @return il codice del paese
     */
    public String getCountry_code() {
        return country_code;
    }
}