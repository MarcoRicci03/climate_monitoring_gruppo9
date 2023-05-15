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
 *
 * @author marco
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
    public JPrevisioni(String data, int id_centro, int id_area, String username, int vVento, int pUmidita, int pressione, int temperatura, int precipitazioni, int aGhiacciai, int mGhiacciai) {
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
    }

    /**
     * Metodo che restituisce una stringa contente tutti gli attributi del
     * oggetto separati da una ','. (Esempio
     * dd/mm/yyyy,id_centro,vVento,pUmidita,pressione,temperatura,precipitazioni,aGhiacchiai,mGhiacciai).
     *
     * @return Ritorna una stringa contente i valori degli attributi dell'
     * oggetto separati da una ','.
     */
    @Override
    public String toString() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data) + "," + id_centro + "," + vVento + "," + pUmidita + "," + pressione + "," + temperatura + "," + precipitazioni + "," + aGhiacciai + "," + mGhiacciai;
    }

    /**
     * Metodo che restituisce una stringa contente tutti gli attributi del
     * oggetto separati da un ';'. (Esempio
     * dd/mm/yyyy;id_centro;vVento;pUmidita;pressione;temperatura;precipitazioni;aGhiacchiai;mGhiacciai).
     *
     * @return Ritorna una stringa contente i valori degli attributi dell'
     * oggetto separati da un ';'.
     */
    public String toCSV() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(data) + ";" + id_centro + ";" + id_area + ";" + username + ";" + vVento + ";" + pUmidita + ";" + pressione + ";" + temperatura + ";" + precipitazioni + ";" + aGhiacciai + ";" + mGhiacciai;
    }

}
