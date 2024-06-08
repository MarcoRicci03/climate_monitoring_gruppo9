/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

/**
 * Classe che rappresenta una stazione con informazioni geografiche e coordinate.
 * Implementa Serializable per consentire la serializzazione dell'oggetto.
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class JStazione implements Serializable {

    /**
     * ID del geoname della stazione.
     */
    @SerializedName("geonameId")
    private Integer geoname_id;

    /**
     * Nome della stazione.
     */
    @SerializedName("name")
    private String nome;

    /**
     * Codice del paese della stazione.
     */
    @SerializedName("countryCode")
    private String country_code;

    /**
     * Nome del paese della stazione.
     */
    @SerializedName("countryName")
    private String country;

    /**
     * Coordinate geografiche della stazione.
     */
    private JCoordinate coordinate;

    /**
     * Costruttore di default che inizializza i campi con valori predefiniti.
     */
    public JStazione() {
        geoname_id = 0;
        nome = "";
        country_code = "";
        coordinate = new JCoordinate();
    }

    /**
     * Costruttore con parametri per inizializzare i campi con valori specifici.
     *
     * @param geoname_id ID del geoname della stazione
     * @param nome Nome della stazione
     * @param country_code Codice del paese della stazione
     * @param country Nome del paese della stazione
     * @param coordinate Coordinate geografiche della stazione
     */
    public JStazione(Integer geoname_id, String nome, String country_code, String country, JCoordinate coordinate) {
        this.geoname_id = geoname_id;
        this.nome = nome;
        this.country_code = country_code;
        this.country = country;
        this.coordinate = coordinate;
    }

    /**
     * Restituisce una rappresentazione in formato stringa dell'oggetto JStazione.
     *
     * @return Stringa che rappresenta l'oggetto JStazione
     */
    @Override
    public String toString() {
        return "geoname_id=" + geoname_id + ", nome=" + nome + ", country_code=" + country_code + ", coordinate=" + coordinate;
    }

    /**
     * Restituisce una rappresentazione in formato CSV dell'oggetto JStazione.
     *
     * @return Stringa in formato CSV che rappresenta l'oggetto JStazione
     */
    public String toStringCsv() {
        return geoname_id + "," + nome + "," + country_code + "," + country + "," + coordinate.getLat() + "," + coordinate.getLon();
    }

    /**
     * Restituisce l'ID del geoname della stazione.
     *
     * @return ID del geoname della stazione
     */
    public Integer getGeoname_id() {
        return geoname_id;
    }

    /**
     * Restituisce il nome della stazione.
     *
     * @return Nome della stazione
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il codice del paese della stazione.
     *
     * @return Codice del paese della stazione
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     * Restituisce le coordinate geografiche della stazione.
     *
     * @return Coordinate geografiche della stazione
     */
    public JCoordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Restituisce il nome del paese della stazione.
     *
     * @return Nome del paese della stazione
     */
    public String getNazione() {
        return country;
    }

    /**
     * Imposta le coordinate geografiche della stazione.
     *
     * @param jCoordinate Nuove coordinate geografiche della stazione
     */
    public void setCoordinate(JCoordinate jCoordinate) {
        this.coordinate = jCoordinate;
    }
}