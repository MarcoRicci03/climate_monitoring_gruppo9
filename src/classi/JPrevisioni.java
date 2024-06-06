/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe per la creazione e la gestione delle previsioni.
 * <p>
 * Questa classe rappresenta una previsione meteorologica con vari attributi
 * come data, velocità del vento, umidità, pressione, temperatura, ecc.
 * </p>
 *
 * <p>Esempio di utilizzo:</p>
 * <pre>
 *     JPrevisioni previsione = new JPrevisioni("12/06/2024", 1, 1, "username", 20, 80, 1013, 25, 5, 2000, 5000, "Note vento", "Note umidità", "Note pressione", "Note temperatura", "Note precipitazioni", "Note altitudine ghiacciai", "Note massa ghiacciai");
 * </pre>
 *
 * @autor marco_ricci
 * @autor edoardo_rizzi
 * @autor alberto_stagno
 * @autor denis_di_napoli
 */
public class JPrevisioni implements Serializable {

    /**
     * Id area previsione
     */
    private Integer id_area;
    /**
     * Id centro previsione
     */
    private Integer id_centro;
    /**
     * Data della previsione
     */
    private Date data;
    /**
     * Username associato alla previsione
     */
    private String username;
    /**
     * Velocità del vento (km/h), suddivisa in fasce
     */
    private Integer vVento;         // Velocità del vento (km/h), suddivisa in fasce
    /**
     * % di Umidità, suddivisa in fasce
     */
    private Integer pUmidita;       // % di Umidità, suddivisa in fasce
    /**
     * In hPa, suddivisa in fasce
     */
    private Integer pressione;      // In hPa, suddivisa in fasce
    /**
     * In °C, suddivisa in fasce
     */
    private Integer temperatura;    // In °C, suddivisa in fasce
    /**
     * in mm, espressa in fasce
     */
    private Integer precipitazioni; // in mm, espressa in fasce
    /**
     * Altitudine dei ghiacciai in m, suddivisa in fasce
     */
    private Integer aGhiacciai;     // Altitudine dei ghiacciai in m, suddivisa in fasce
    /**
     * Massa dei ghiacciai in kg, suddivisisa in fasce
     */
    private Integer mGhiacciai;     // Massa dei ghiacciai in kg, suddivisisa in fasce

// Note scritte dall'operatore che ha inserito la previsione
    /**
     * Note Vento scritte dall'operatore che ha inserito la previsione
     */
    private String nVento;
    /**
     * Note Umidita scritte dall'operatore che ha inserito la previsione
     */
    private String nUmidita;
    /**
     * Note Pressione scritte dall'operatore che ha inserito la previsione
     */
    private String nPressione;
    /**
     * Note Temperatura scritte dall'operatore che ha inserito la previsione
     */
    private String nTemperatura;
    /**
     * Note Precipitazioni scritte dall'operatore che ha inserito la previsione
     */
    private String nPrecipitazioni;
    /**
     * Note Ghiacciai scritte dall'operatore che ha inserito la previsione
     */
    private String nAGhiacciai;
    /**
     * Note Massa ghiacciai scritte dall'operatore che ha inserito la previsione
     */
    private String nMGhiacciai;

    /**
     * Metodo che restituisce l'attributo <code> nVento </code>
     *
     * @return Note nVento
     */
    public String getnVento() {
        return nVento;
    }

    /**
     * Metodo che restituisce l'attributo <code> nUmidita </code>
     *
     * @return Note nUmidita
     */
    public String getnUmidita() {
        return nUmidita;
    }

    /**
     * Metodo che restituisce l'attributo <code> nPressione </code>
     *
     * @return Note nPressione
     */
    public String getnPressione() {
        return nPressione;
    }

    /**
     * Metodo che restituisce l'attributo <code> nTemperatura </code>
     *
     * @return Note nTemperatura
     */
    public String getnTemperatura() {
        return nTemperatura;
    }

    /**
     * Metodo che restituisce l'attributo <code> nPrecipitazioni </code>
     *
     * @return Note nPrecipitazioni
     */
    public String getnPrecipitazioni() {
        return nPrecipitazioni;
    }

    /**
     * Metodo che restituisce l'attributo <code> nAGhiacciai </code>
     *
     * @return Note nAGhiacciai
     */
    public String getnAGhiacciai() {
        return nAGhiacciai;
    }

    /**
     * Metodo che restituisce l'attributo <code> nMGhiacciai </code>
     *
     * @return Note nMGhiacciai
     */
    public String getnMGhiacciai() {
        return nMGhiacciai;
    }

    /**
     * Metodo che restituisce l'attributo <code> id_area </code>
     *
     * @return id_area
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
     * JPrevisioni con tutti gli attributi impostati a zero o a stringa vuota.
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
     * @param username username dell'operatore che ha inserito la previsione.
     * @param data indica la data in cui è stata inserita la previsione passando
     * un ogetto di tipo 'Date' (formato della data gg/mm/aaaa).
     * @param id_centro contiene l'id della stazione metereologica da cui è
     * stata inserita la previsione.
     * @param id_area indica l'area di interesse relativa alla stazione
     * metereologica.
     * @param vVento velocità del vento (km/h), suddivisa in fasce.
     * @param pUmidita percentuale di Umidità, suddivisa in fasce.
     * @param pressione in hPa, suddivisa in fasce.
     * @param temperatura in °C, suddivisa in fasce.
     * @param precipitazioni in mm, espressa in fasce.
     * @param aGhiacciai altitudine dei ghiacciai in m, suddivisa in fasce.
     * @param mGhiacciai massa dei ghiacciai in kg, suddivisisa in fasce.
     * @param nVento note riguardanti il vento.
     * @param nUmidita note riguardanti l'umidità.
     * @param nPRessione note riguardanti la pressione.
     * @param nTemperatura note riguardanti la temperatura.
     * @param nPrecipitazioni note riguardanti le precipitazioni.
     * @param nAGhiacciai note riguardanti l'altitudine dei ghiacciai.
     * @param nMGhiacciai note riguardanti la massa dei ghiacciai.
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
     * @param username username dell'utente che ha inserito la previsione
     * @param vVento velocità del vento (km/h), suddivisa in fasce.
     * @param pUmidita percentuale di Umidità, suddivisa in fasce.
     * @param pressione in hPa, suddivisa in fasce.
     * @param temperatura in °C, suddivisa in fasce.
     * @param precipitazioni in mm, espressa in fasce.
     * @param aGhiacciai altitudine dei ghiacciai in m, suddivisa in fasce.
     * @param mGhiacciai massa dei ghiacciai in kg, suddivisisa in fasce.
     * @param nVento note riguardanti il vento.
     * @param nUmidita note riguardanti l'umiditá.
     * @param nPRessione note riguardanti la pressione.
     * @param nTemperatura note riguardanti la temperatura.
     * @param nPrecipitazioni note riguardanti le precipitazioni.
     * @param nAGhiacciai note riguardanti l'altitudine dei ghiacciai.
     * @param nMGhiacciai note riguardanti la massa dei ghiacciai.
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
     * dd/mm/yyyy,id_centro,vVento,pUmidita,pressione,temperatura,precipitazioni,aGhiacchiai,mGhiacciai,nVento,nUmidita,nPressione,nTemperatura,nPrecipitazioni,nAGhiacciai,nMGhiacciai).
     *
     * @return Ritorna una stringa contente i valori degli attributi dell'
     * oggetto separati da una ','.
     */
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data) + "," + id_centro + "," + vVento + "," + pUmidita + "," + pressione + "," + temperatura + "," + precipitazioni + "," + aGhiacciai + "," + mGhiacciai + ","
                + nVento + "," + nUmidita + "," + nPressione + "," + nTemperatura + "," + nPrecipitazioni + "," + nAGhiacciai + "," + nMGhiacciai;
    }

    /**
     * Metodo che restituisce una stringa contente tutti gli attributi
     * dell'oggetto separati da un ';'. (Esempio
     * dd/mm/yyyy;id_centro;vVento;pUmidita;pressione;temperatura;precipitazioni;aGhiacchiai;mGhiacciai;nVento;nUmidita;nPressione;nTemperatura;nPrecipitazioni;nAGhiacciai;nMGhiacciai).
     *
     * @return Ritorna una stringa contente i valori degli attributi dell'
     * oggetto separati da un ';'.
     */
    public String toCSV() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data) + ";" + id_centro + ";" + id_area + ";" + username + ";" + vVento + ";" + nVento + ";" + pUmidita + ";" + nUmidita + ";" + pressione + ";" + nPressione + ";" + temperatura + ";" + nTemperatura + ";" + precipitazioni + ";" + nPrecipitazioni + ";" + aGhiacciai + ";" + nAGhiacciai + ";" + mGhiacciai + ";" + nMGhiacciai;
    }
}
