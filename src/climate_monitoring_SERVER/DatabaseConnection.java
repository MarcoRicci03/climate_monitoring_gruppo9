package climate_monitoring_SERVER;

import com.sun.tools.jconsole.JConsoleContext;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DatabaseConnection {
    private Connection conn = null;

    public DatabaseConnection(String url) {
        try {
            conn = DriverManager.getConnection(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public boolean isConnected() {
        return conn != null;
    }

    public boolean reconnect(String url) {
        try {
            conn = DriverManager.getConnection(url);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ResultSet executeQuery(String query, Object[] params, boolean hasParams) {
        ResultSet rs = null;
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

    public int executeUpdate(String query,Object[] params, boolean hasParams) {
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
                            stmt.setDate(i + 1, (java.sql.Date) p);
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

    public PreparedStatement prepareStatement(String query) {
        try {
            return conn.prepareStatement(query);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
}
