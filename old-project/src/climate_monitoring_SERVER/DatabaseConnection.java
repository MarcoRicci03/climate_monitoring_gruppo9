package climate_monitoring_SERVER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Classe che gestisce la connessione al database e l'esecuzione di query e aggiornamenti.
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class DatabaseConnection {

    /**
     * Connessione al database.
     */
    private Connection conn = null;

    /**
     * Costruttore della classe DatabaseConnection.
     * Stabilisce una connessione al database utilizzando l'URL fornito.
     *
     * @param url l'URL per la connessione al database.
     */
    public DatabaseConnection(String url) {
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Chiude la connessione al database.
     */
    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Verifica se la connessione al database è attiva.
     *
     * @return true se la connessione è attiva, false altrimenti.
     */
    public boolean isConnected() {
        return conn != null;
    }

    /**
     * Riconnette al database utilizzando l'URL fornito.
     *
     * @param url l'URL per la riconnessione al database.
     * @return true se la riconnessione è avvenuta con successo, false altrimenti.
     */
    public boolean reconnect(String url) {
        try {
            conn = DriverManager.getConnection(url);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Esegue una query sul database.
     *
     * @param query     la query da eseguire.
     * @param params    i parametri da utilizzare nella query.
     * @param hasParams indica se la query ha parametri.
     * @return il ResultSet contenente i risultati della query, o null se si verifica un errore.
     */
    public ResultSet executeQuery(String query, Object[] params, boolean hasParams) {
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            if (hasParams && (params != null && params.length > 0)) {
                for (int i = 0; i < params.length; i++) {
                    if (params[i] == null) continue;
                    Object p = params[i];
                    switch (p.getClass().getSimpleName()) {
                        case "Integer":
                            stmt.setInt(i + 1, (Integer) p);
                            break;
                        case "String":
                            stmt.setString(i + 1, (String) p);
                            break;
                        case "Double":
                            stmt.setDouble(i + 1, (Double) p);
                            break;
                        case "Float":
                            stmt.setFloat(i + 1, (Float) p);
                            break;
                        case "Boolean":
                            stmt.setBoolean(i + 1, (Boolean) p);
                            break;
                        case "Long":
                            stmt.setLong(i + 1, (Long) p);
                            break;
                        case "ArrayList":
                            ArrayList<String> list = (ArrayList<String>) p;
                            for (int j = 0; j < list.size(); j++) {
                                stmt.setString(j + 1, list.get(j));
                            }
                            break;
                        case "Date":
                            //formato yyyy-mm-dd
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String strData = sdf.format((Date) p);
                            java.sql.Date data = java.sql.Date.valueOf(strData);
                            stmt.setDate(i + 1, data);
                            break;
                        default:
                            throw new IllegalArgumentException("Tipo non riconosciuto: " + p.getClass().getSimpleName());
                    }
                }
            }
            return stmt.executeQuery();
        } catch (Exception ex) {
            System.out.println("Errore: " + ex.getMessage());
        }
        return null;
    }

    /**
     * Esegue un aggiornamento sul database.
     *
     * @param query     la query di aggiornamento da eseguire.
     * @param params    i parametri da utilizzare nella query.
     * @param hasParams indica se la query ha parametri.
     * @return il numero di righe affette dall'aggiornamento, o -1 se si verifica un errore.
     */
    public int executeUpdate(String query, Object[] params, boolean hasParams) {
        try {
            PreparedStatement stmt = conn.prepareStatement(query);
            if (hasParams && (params != null && params.length > 0)) {
                for (int i = 0; i < params.length; i++) {
                    if (params[i] == null) continue;
                    Object p = params[i];
                    switch (p.getClass().getSimpleName()) {
                        case "Integer":
                            stmt.setInt(i + 1, (Integer) p);
                            break;
                        case "String":
                            stmt.setString(i + 1, (String) p);
                            break;
                        case "Double":
                            stmt.setDouble(i + 1, (Double) p);
                            break;
                        case "Float":
                            stmt.setFloat(i + 1, (Float) p);
                            break;
                        case "Boolean":
                            stmt.setBoolean(i + 1, (Boolean) p);
                            break;
                        case "Long":
                            stmt.setLong(i + 1, (Long) p);
                            break;
                        case "ArrayList":
                            ArrayList<String> list = (ArrayList<String>) p;
                            for (int j = 0; j < list.size(); j++) {
                                stmt.setString(j + 1, list.get(j));
                            }
                            break;
                        case "Date":
                            //formato yyyy-mm-dd
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            String strData = sdf.format((Date) p);
                            java.sql.Date data = java.sql.Date.valueOf(strData);
                            System.out.println(data);
                            stmt.setDate(i + 1, data);
                            break;
                        default:
                            throw new IllegalArgumentException("Tipo non riconosciuto: " + p.getClass().getSimpleName());
                    }
                }
            }
            return stmt.executeUpdate();
        } catch (Exception ex) {
            System.out.println("Errore: " + ex.getMessage());
        }
        return -1;
    }

    /**
     * Prepara una dichiarazione SQL da eseguire sul database.
     *
     * @param query la query da preparare.
     * @return un PreparedStatement per la query fornita.
     */
    public PreparedStatement prepareStatement(String query) {
        try {
            return conn.prepareStatement(query);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
