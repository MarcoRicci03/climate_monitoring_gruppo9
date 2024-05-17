package climate_monitoring_SERVER;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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

    public ResultSet executeQuery(String query) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conn.prepareStatement(query);
            rs = stmt.executeQuery();
            return rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int executeUpdate(String query) {
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(query);
            return stmt.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
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
