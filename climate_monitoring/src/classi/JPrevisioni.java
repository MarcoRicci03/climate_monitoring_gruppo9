/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe per la creazione e la gestione delle previsioni
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class JPrevisioni {

    private Integer id_area;
    private Integer id_centro;
    private Date data;
    private String username;
    private Integer vVento;         // Velocità del vento (km/h), suddivisa in fasce
    private Integer pUmidita;       // % di Umidità, suddivisa in fasce
    private Integer pressione;      // In hPa, suddivisa in fasce
    private Integer temperatura;    // In °C, suddivisa in fasce
    private Integer precipitazioni; // in mm, espressa in fasce
    private Integer aGhiacciai;     // Altitudine dei ghiacciai in m, suddivisa in fasce
    private Integer mGhiacciai;     // Massa dei ghiacciai in kg, suddivisisa in fasce

// Note scritte dall'operatore che ha inserito la previsione
    private String nVento;
    private String nUmidita;
    private String nPressione;
    private String nTemperatura;
    private String nPrecipitazioni;
    private String nAGhiacciai;
    private String nMGhiacciai;

    /**
     * Metodo che restituisce l'attributo <code> nVento </code>
     *
     * @return nVento
     */
    public String getnVento() {
        return nVento;
    }

    /**
     * Metodo che restituisce l'attributo <code> nUmidita </code>
     *
     * @return nUmidita
     */
    public String getnUmidita() {
        return nUmidita;
    }

    /**
     * Metodo che restituisce l'attributo <code> nPressione </code>
     *
     * @return nPressione
     */
    public String getnPressione() {
        return nPressione;
    }

    /**
     * Metodo che restituisce l'attributo <code> nTemperatura </code>
     *
     * @return nTemperatura
     */
    public String getnTemperatura() {
        return nTemperatura;
    }

    /**
     * Metodo che restituisce l'attributo <code> nPrecipitazioni </code>
     *
     * @return nPrecipitazioni
     */
    public String getnPrecipitazioni() {
        return nPrecipitazioni;
    }

    /**
     * Metodo che restituisce l'attributo <code> nAGhiacciai </code>
     *
     * @return nAGhiacciai
     */
    public String getnAGhiacciai() {
        return nAGhiacciai;
    }

    /**
     * Metodo che restituisce l'attributo <code> nMGhiacciai </code>
     *
     * @return nMGhiacciai
     */
    public String getnMGhiacciai() {
        return nMGhiacciai;
    }

    /**
     * Metodo che restituisce l'attributo <code> cognome </code>
     *
     * @return cognome
     */
    public Integer getId_area() {
        return id_area;
    }

    /**
     * Metodo che restituisce l'attributo <code> Id_centro </code>
     *
     * @return Id_centro
     */
    public Integer getId_centro() {
        return id_centro;
    }

    /**
     * Metodo che restituisce l'attributo <code> Data </code>
     *
     * @return Data
     */
    public Date getData() {
        return data;
    }

    /**
     * Metodo che restituisce l'attributo <code> Username </code>
     *
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Metodo che restituisce l'attributo <code> vVento </code>
     *
     * @return vVento
     */
    public Integer getvVento() {
        return vVento;
    }

    /**
     * Metodo che restituisce l'attributo <code> pUmidita </code>
     *
     * @return pUmidita
     */
    public Integer getpUmidita() {
        return pUmidita;
    }

    /**
     * Metodo che restituisce l'attributo <code> Pressione </code>
     *
     * @return Pressione
     */
    public Integer getPressione() {
        return pressione;
    }

    /**
     * Metodo che restituisce l'attributo <code> Temperatura </code>
     *
     * @return Temperatura
     */
    public Integer getTemperatura() {
        return temperatura;
    }

    /**
     * Metodo che restituisce l'attributo <code> Precipitazioni </code>
     *
     * @return Precipitazioni
     */
    public Integer getPrecipitazioni() {
        return precipitazioni;
    }

    /**
     * Metodo che restituisce l'attributo <code> aGhiacciai </code>
     *
     * @return aGhiacciai
     */
    public Integer getaGhiacciai() {
        return aGhiacciai;
    }

    /**
     * Metodo che restituisce l'attributo <code> mGhiacciai </code>
     *
     * @return mGhiacciai
     */
    public Integer getmGhiacciai() {
        return mGhiacciai;
    }

    /**
     * Costruttore senza parametri della classe JPrevisioni, genera un oggetto
     * JPreivisioni con tutti gli attributi impostati a '0' o null.
     */
    public JPrevisioni() {
        this.id_area = 0;
        this.data = new Date();
        this.vVento = 0;
        this.pUmidita = 0;
        this.pressione = 0;
        this.temperatura = 0;
        this.aGhiacciai = 0;
        this.mGhiacciai = 0;
        this.id_centro = 0;
        this.username = "";
        this.precipitazioni = 0;
    }

    /**
     * Costruttore JPrevisioni con tutti i parametri, genera un oggetto
     * JPrevisioni.
     *
     * @param data indica la data in cui è stata inserita la previsione passando
     * un ogetto di tipo 'Date' (formato della data gg/mm/aaaa).
     * @param id_centro indica la stazione metereologica da cui è stata inserita
     * la previsione.
     * @param id_area indica l'area di interesse relativa alla stazione
     * metereologica.
     * @param vVento velocità del vento (km/h), suddivisa in fasce.
     * @param pUmidita percentuale di Umidità, suddivisa in fasce.
     * @param pressione in hPa, suddivisa in fasce.
     * @param temperatura in °C, suddivisa in fasce.
     * @param precipitazioni in mm, espressa in fasce.
     * @param aGhiacciai altitudine dei ghiacciai in m, suddivisa in fasce.
     * @param mGhiacciaia massa dei ghiacciai in kg, suddivisisa in fasce.
     */
    public JPrevisioni(Integer id_area, Integer id_centro, Date data, String username, Integer vVento, Integer pUmidita, Integer pressione, Integer temperatura, Integer precipitazioni, Integer aGhiacciai, Integer mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) {
        this.id_area = id_area;
        this.id_centro = id_centro;
        this.data = data;
        this.username = username;
        this.vVento = vVento;
        this.pUmidita = pUmidita;
        this.pressione = pressione;
        this.temperatura = temperatura;
        this.precipitazioni = precipitazioni;
        this.aGhiacciai = aGhiacciai;
        this.mGhiacciai = mGhiacciai;
        this.nVento = nVento;
        this.nUmidita = nUmidita;
        this.nPressione = nPRessione;
        this.nTemperatura = nTemperatura;
        this.nPrecipitazioni = nPrecipitazioni;
        this.nAGhiacciai = nAGhiacciai;
        this.nMGhiacciai = nMGhiacciai;
    }

    /**
     * Costruttore JPrevisioni con tutti i parametri, genera un oggetto
     * JPrevisioni.
     *
     * @param data indica la data in cui è stata inserita la previsione passando
     * una stringa (formato della data gg/mm/aaaa).
     * @param id_centro indica la stazione metereologica da cui è stata inserita
     * la previsione.
     * @param id_area indica l'area di interesse relativa alla stazione
     * metereologica.
     * @param vVento velocità del vento (km/h), suddivisa in fasce.
     * @param pUmidita percentuale di Umidità, suddivisa in fasce.
     * @param pressione in hPa, suddivisa in fasce.
     * @param temperatura in °C, suddivisa in fasce.
     * @param precipitazioni in mm, espressa in fasce.
     * @param aGhiacciai altitudine dei ghiacciai in m, suddivisa in fasce.
     * @param mGhiacciaia massa dei ghiacciai in kg, suddivisisa in fasce.
     */
    public JPrevisioni(String data, int id_centro, int id_area, String username, int vVento, int pUmidita, int pressione, int temperatura, int precipitazioni, int aGhiacciai, int mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = formatter.parse(data);
        } catch (ParseException ex) {
            Logger.getLogger(JPrevisioni.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.data = date;
        this.id_centro = id_centro;
        this.id_area = id_area;
        this.username = username;
        this.vVento = vVento;
        this.pUmidita = pUmidita;
        this.pressione = pressione;
        this.temperatura = temperatura;
        this.precipitazioni = precipitazioni;
        this.aGhiacciai = aGhiacciai;
        this.mGhiacciai = mGhiacciai;
        this.nVento = nVento;
        this.nUmidita = nUmidita;
        this.nPressione = nPRessione;
        this.nTemperatura = nTemperatura;
        this.nPrecipitazioni = nPrecipitazioni;
        this.nAGhiacciai = nAGhiacciai;
        this.nMGhiacciai = nMGhiacciai;

    }

    /**
     * Metodo che restituisce una stringa contente tutti gli attributi dell'
     * oggetto separati da una ','. (Esempio
     * dd/mm/yyyy,id_centro,vVento,pUmidita,pressione,temperatura,precipitazioni,aGhiacchiai,mGhiacciai).
     *
     * @return Ritorna una stringa contente i valori degli attributi dell'
     * oggetto separati da una ','.
     */
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data) + "," + id_centro + "," + vVento + "," + pUmidita + "," + pressione + "," + temperatura + "," + precipitazioni + "," + aGhiacciai + "," + mGhiacciai + "," + 
                                                         nVento + "," + nUmidita + "," + nPressione + "," + nTemperatura + "," + nPrecipitazioni + "," + nAGhiacciai + "," + nMGhiacciai;
    }

    /**
     * Metodo che restituisce una stringa contente tutti gli attributi
     * dell'oggetto separati da un ';'. (Esempio
     * dd/mm/yyyy;id_centro;vVento;pUmidita;pressione;temperatura;precipitazioni;aGhiacchiai;mGhiacciai).
     *
     * @return Ritorna una stringa contente i valori degli attributi dell'
     * oggetto separati da un ';'.
     */
    public String toCSV() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data) + ";" + id_centro + ";" + id_area + ";" + username + ";" + vVento + ";" + nVento + ";" + pUmidita + ";" + nUmidita + ";" + pressione + ";" + nPressione + ";" + temperatura + ";" + nTemperatura + ";" + precipitazioni + ";" + nPrecipitazioni + ";" + aGhiacciai + ";" + nAGhiacciai + ";" + mGhiacciai + ";" + nMGhiacciai;
    }

    /* COSTRUTTORE CON PARAMETRI VECCHIO
        public JPrevisioni(Date data, int id_centro, int id_area, String username, int vVento, int pUmidita, int pressione, int temperatura, int precipitazioni, int aGhiacciai, int mGhiacciai) {
        this.data = data;
        this.id_centro = id_centro;
        this.id_area = id_area;
        this.username = username;
        this.vVento = vVento;
        this.pUmidita = pUmidita;
        this.pressione = pressione;
        this.temperatura = temperatura;
        this.precipitazioni = precipitazioni;
        this.aGhiacciai = aGhiacciai;
        this.mGhiacciai = mGhiacciai;
    }
     */
}
