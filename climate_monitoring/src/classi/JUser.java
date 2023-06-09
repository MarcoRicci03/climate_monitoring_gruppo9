/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

/**
 *
 * Classe per la creazione e la gestione degli operatori autorizzati
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class JUser {

    /**
     * username utente , nome utente, cognome utente, id utente, password utente,  cf utente, mail utente
     */
    private String username, nome, cognome, id, password, cf, mail;
    /**
     * Indica la stazione metereologica a cui è associato l'operatore
     */
    private Integer geoname_id; //Indica la stazione metereologica a cui è associato l'operatore
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
        this.password = "";
        this.cf = "";
        this.geoname_id = 0;
    }

    /**
     * Costruttore con parametri, genera un ogetto JUser.
     *
     * @param elementi vettore di stringhe contenente tutti gli elementi
     * necessari per costruire un oggetto. (Esempio di vettore: String[]
     * elementi = {id, nome, cognome, username, mail, password, cf, geoname_id}
     */
    public JUser(String[] elementi) {
        this.id = elementi[0];
        this.nome = elementi[1];
        this.cognome = elementi[2];
        this.username = elementi[3];
        this.mail = elementi[4];
        this.password = elementi[5];
        this.cf = elementi[6];
        this.geoname_id = Integer.parseInt(elementi[7]);

    }

    /**
     * Costruttore con parametri, genera un oggetto JUser.
     *
     * @param username indica il nome con cui accedere nell'area riservata agli
     * operatori.
     * @param nome indica il nome dell'operatore.
     * @param cognome indica il cognome dell'operatore.
     * @param id codice univoco che indica l'operatore.
     * @param password indica la parola con cui accedere nell'area riservata
     * agli operatori.
     * @param cf indica il codice fiscale dell'operatore.
     * @param mail indica l'email dell'operatore.
     */
    public JUser(String username, String nome, String cognome, String id, String password, String cf, String mail) {
        this.username = username;
        this.nome = nome;
        this.cognome = cognome;
        this.id = id;
        this.password = password;
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
     * Metodo che restituisce l'attributo {@code} password 
     *
     * @return password
     */
    public String getPassword() {
        return password;
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
    public Integer getGeoname_id() {
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

}
