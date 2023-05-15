/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 * Classe per la creazione e gestione di stazioni metereologiche.
 *
 * @author marco
 */
public class JLuogo {

    /**
     * Codice identificativo della cittá dove si trova la stazione
     * metereologica.
     */
    private Integer geoname_id;
    /**
     * Nome della cittá dove si trova la stazione metereologica.
     */
    private String nome;
    /**
     * Codice della nazione dove si trova la stazione metereologica.
     */
    private String country_code;
    /**
     * Nome della nazione dove si trova la stazione metereologica.
     */
    private String country;
    /**
     * Coordinate dove si trova la stazione metereologica.
     */
    private JCoordinate coordinate;

    /**
     * Costruttore senza parametri che imposta a 0 (valore predefinito) tutti i
     * valori dell'oggetto.
     */
    public JLuogo() {
        geoname_id = 0;
        nome = "";
        country_code = "";
        coordinate = new JCoordinate();
    }

    /**
     * Costruttore con parametri che imposta l'oggetto con i valori passati
     * tramite paremetri.
     */
    public JLuogo(Integer geoname_id, String nome, String country_code, String country, JCoordinate coordinate) {
        this.geoname_id = geoname_id;
        this.nome = nome;
        this.country_code = country_code;
        this.country = country;
        this.coordinate = coordinate;
    }

    /**
     * Costruttore con parametro che imposta l'oggetto tramite stringa.
     */
    public JLuogo(String fromCSV) {
        String[] elements = fromCSV.split(";");
        geoname_id = Integer.valueOf(elements[0]);
        nome = elements[1];
        country_code = elements[2];
        country = elements[3];
        coordinate = new JCoordinate(Float.valueOf(elements[4].split(",")[0]), Float.valueOf(elements[4].split(",")[1]));
    }

    /**
     * Metodo per ottenere tutte le informazioni dell'oggetto tramite stringa.
     */
    @Override
    public String toString() {
        return "geoname_id=" + geoname_id + ", nome=" + nome + ", country_code=" + country_code + ", coordinate=" + coordinate;
    }

    /**
     * Metodo per ottenere il codice identificativo della cittá dove si trova la
     * stazione metereologica.
     */
    public Integer getGeoname_id() {
        return geoname_id;
    }

    /**
     * Metodo per ottenere il codice identificativo della cittá dove si trova la
     * stazione metereologica.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo per ottenere il codice identificativo della cittá dove si trova la
     * stazione metereologica.
     */
    public String getCountry_code() {
        return country_code;
    }

    /**
     * Metodo per ottenere le coordinate della stazione metereologica.
     */
    public JCoordinate getCoordinate() {
        return coordinate;
    }

}
