/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Classe che rappresenta un utente con varie informazioni personali e metodi per la gestione dell'utente.
 * Implementa Serializable per consentire la serializzazione dell'oggetto.
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class JUser implements Serializable {

    /**
     * Username dell'utente.
     */
    private String username;

    /**
     * Nome dell'utente.
     */
    private String nome;

    /**
     * Cognome dell'utente.
     */
    private String cognome;

    /**
     * ID dell'utente.
     */
    private String id;

    /**
     * Codice fiscale dell'utente.
     */
    private String cf;

    /**
     * Email dell'utente.
     */
    private String mail;

    /**
     * ID del geoname associato all'utente.
     */
    private String geoname_id;

    /**
     * Indica l'ultima area di interesse di cui l'operatore ha aggiunto una previsione.
     */
    private int id_areaSelezionata;

    /**
     * Costruttore della classe JUser con parametri.
     *
     * @param username Username dell'utente
     * @param nome Nome dell'utente
     * @param cognome Cognome dell'utente
     * @param id ID dell'utente
     * @param cf Codice fiscale dell'utente
     * @param mail Email dell'utente
     * @param geoname_id ID del geoname associato all'utente
     */
    public JUser(String username, String nome, String cognome, String id, String cf, String mail, String geoname_id) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.cf = cf;
        this.mail = mail;
        this.geoname_id = geoname_id;
    }

    /**
     * Restituisce l'username dell'utente.
     *
     * @return Username dell'utente
     */
    public String getUsername() {
        return username;
    }

    /**
     * Restituisce il nome dell'utente.
     *
     * @return Nome dell'utente
     */
    public String getNome() {
        return nome;
    }

    /**
     * Restituisce il cognome dell'utente.
     *
     * @return Cognome dell'utente
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Restituisce l'ID dell'utente.
     *
     * @return ID dell'utente
     */
    public String getId() {
        return id;
    }

    /**
     * Restituisce il codice fiscale dell'utente.
     *
     * @return Codice fiscale dell'utente
     */
    public String getCf() {
        return cf;
    }

    /**
     * Restituisce l'email dell'utente.
     *
     * @return Email dell'utente
     */
    public String getMail() {
        return mail;
    }

    /**
     * Restituisce l'ID del geoname associato all'utente.
     *
     * @return ID del geoname associato all'utente
     */
    public String getGeoname_id() {
        return geoname_id;
    }

    /**
     * Restituisce l'ID dell'ultima area selezionata dall'utente.
     *
     * @return ID dell'ultima area selezionata
     */
    public int getId_areaSelezionata() {
        return id_areaSelezionata;
    }

    /**
     * Imposta l'ID dell'ultima area selezionata dall'utente.
     *
     * @param id_areaSelezionata Nuovo ID dell'ultima area selezionata
     */
    public void setId_areaSelezionata(int id_areaSelezionata) {
        this.id_areaSelezionata = id_areaSelezionata;
    }

    /**
     * Restituisce l'hash MD5 della stringa di input.
     *
     * @param input La stringa di cui calcolare l'hash MD5
     * @return L'hash MD5 della stringa di input
     */
    public static String getMD5(String input){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());
            byte[] digest = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}
