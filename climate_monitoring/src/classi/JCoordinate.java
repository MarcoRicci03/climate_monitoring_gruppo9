package classi;

/**
 * Classe per la creazione e gestione delle coordinate geografiche.
 *
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class JCoordinate {

    /**
     * Variabile per la latitudine.
     */
    private Float lat;
    /**
     * Variabile per la longitudine.
     */
    private Float lon;

    /**
     * Costruttore senza parametri che imposta a 0 (valore predefinito) le
     * coordinate dell'oggetto.
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
     * Metodo che restituisce una stringa con latitudine e longitudine.
     *
     * @return Latitudine e Longitudine in una sola stringa.
     */
    @Override
    public String toString() {
        return "lat=" + lat + ", lon=" + lon;
    }

    /**
     * Metodo che permette tramite formula matematica di calcolare la distanza
     * in chilometri tra due coordinate, richiede come parametro le coordinate
     * con le quali calcolare la distanza.
     *
     * @param altro Un altro oggetto coordinate, il quale serve per calcolare la
     * distanza tra i due punti geografici.
     * @return Distanza in chilometri in formato Double.
     */
    public double distanzaDa(JCoordinate altro) {
        double dLat = Math.toRadians(altro.lat - lat);
        double dLon = Math.toRadians(altro.lon - lon);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(altro.lat))
                * Math.sin(dLon / 2) * Math.sin(dLon / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = 6371 * c;
        return distance;
    }

    /**
     * Metodo statico che permette di verificare se la stringa passata come
     * parametro puó essere trasformata in oggetto JCoordinate.
     *
     * @param txt Stringa la quale può eventualmente contenere delle coordinate.
     * @return 'true' o 'false' in base alla presenza o meno di coordinate nella
     * stringa.
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
