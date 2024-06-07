package classi;

import java.io.Serializable;

/**
 * Classe per la creazione e gestione delle coordinate geografiche.

 * @autor marco_ricci
 * @autor edoardo_rizzi
 * @autor alberto_stagno
 * @autor denis_di_napoli
 */
public class JCoordinate implements Serializable {

    /**
     * Variabile per la latitudine.
     */
    private Float lat;
    /**
     * Variabile per la longitudine.
     */
    private Float lon;

    /**
     * Costruttore senza parametri che imposta a zero (valore predefinito) le
     * coordinate.
     */
    public JCoordinate() {
        lat = 0.0f;
        lon = 0.0f;
    }

    /**
     * Costruttore con parametri che imposta le coordinate del nostro oggetto ai
     * valori passati tramite parametro con due variabili formato float.
     *
     * @param lat Latitudine in format Float
     * @param lon Longitudine in formato Float
     */
    public JCoordinate(Float lat, Float lon) {
        this.lat = lat;
        this.lon = lon;
    }

    /**
     * Costruttore con parametri che imposta a le coordinate del nostro oggetto
     * ai valori passati tramite parametro con una variabile formato stringa.
     *
     * @param txt Latitudine e Longitudine in formato stringa divise da una ','.
     */
    public JCoordinate(String txt) {
        String[] v = txt.split(",");
        lat = Float.parseFloat(v[0]);
        lon = Float.parseFloat(v[1]);
    }

    /**
     * Metodo che permette di ottenere la latitudine.
     *
     * @return Latitudine in formato Float.
     */
    public Float getLat() {
        return lat;
    }

    /**
     * Metodo che permette di ottenere la longitudine.
     *
     * @return Longitudine in formato Float.
     */
    public Float getLon() {
        return lon;
    }

    /**
     * Metodo che restituisce una stringa con latitudine e longitudine divise da
     * ','.
     *
     * @return Latitudine e Longitudine in una sola stringa.
     */
    @Override
    public String toString() {
        return "lat=" + lat + ", lon=" + lon;
    }

    /**
     * Metodo statico che permette di verificare se la stringa passata come
     * parametro puó essere trasformata in oggetto JCoordinate.
     *
     * @param txt Stringa la quale può eventualmente contenere delle coordinate.
     * @return 'true' o 'false' in base alla presenza o meno di coordinate
     * valide nella stringa.
     */
    public static boolean sonoCoordinate(String txt) {
        if (txt.contains(",")) {
            String[] v = txt.split(",");
            if (v.length == 2) {
                try {
                    Float f1 = Float.parseFloat(v[0]);
                    Float f2 = Float.parseFloat(v[1]);
                } catch (NumberFormatException pe) {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }
}
