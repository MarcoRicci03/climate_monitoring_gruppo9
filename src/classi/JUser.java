/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * Classe per la creazione e la gestione degli operatori autorizzati
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class JUser implements Serializable {

    /**
     * username utente , nome utente, cognome utente, id utente, password utente,  cf utente, mail utente, stazione meterologica a cui è associato l'operatore
     */
    private String username, nome, cognome, id, cf, mail, geoname_id;

    /**
     * Indica l'ultima area di interesse di cui l'operatore ha aggiunto una previsione 
     */
    private int id_areaSelezionata; //Indica l'ultima area di interesse di cui l'operatore ha aggiunto una previsione 

    /**
     * Costruttore senza parametri, genera un oggetto JUser impostando a zero tutti
     * gli attributi della classe.
     */
    public JUser() {
        this.id = "";
        this.nome = "";
        this.cognome = "";
        this.username = "";
        this.mail = "";
        this.cf = "";
        this.geoname_id = "";
    }

    /**
     * Costruttore con parametri, genera un oggetto JUser.
     *
     * @param username indica il nome con cui accedere nell'area riservata agli
     * operatori.
     * @param nome indica il nome dell'operatore.
     * @param cognome indica il cognome dell'operatore.
     * @param id codice univoco che indica l'operatore.
     * @param cf indica il codice fiscale dell'operatore.
     * @param mail indica l'email dell'operatore.
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
     * Metodo che restituisce l'attributo {@code} username 
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo che restituisce l'attributo {@code} nome 
     *
     * @return nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo che restituisce l'attributo {@code} cognome 
     *
     * @return cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * Metodo che restituisce l'attributo {@code} id 
     *
     * @return id
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo che restituisce l'attributo {@code} cf (codice fiscale) 
     *
     * @return cf (codice fiscale)
     */
    public String getCf() {
        return cf;
    }

    /**
     * Metodo che restituisce l'attributo {@code} mail 
     *
     * @return mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * Metodo che restituisce l'attributo {@code} Geonema_id
     *
     * @return Geonema_id
     */
    public String getGeoname_id() {
        return geoname_id;
    }

    /**
     * Metodo che restituisce l'attributo {@code} Id_areaSelezionata 
     *
     * @return Id_areaSelezionata
     */
    public int getId_areaSelezionata() {
        return id_areaSelezionata;
    }

    /**
     * Metodo che imposta un nuovo valore  all'attributo {@code} Id_areaSelezionata
     * 
     * @param id_areaSelezionata codice identificativo dell'area
     *
     */
    public void setId_areaSelezionata(int id_areaSelezionata) {
        this.id_areaSelezionata = id_areaSelezionata;
    }

    public static String getMD5(String input){
        MessageDigest md= null;
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
