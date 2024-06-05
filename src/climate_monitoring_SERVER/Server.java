package climate_monitoring_SERVER;

import classi.*;

import com.google.gson.Gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Server extends UnicastRemoteObject implements DBInterface {
    private ArrayList<InetAddress> client_loggati;
    private DatabaseConnection db;

    public Server(DatabaseConnection db) throws RemoteException {
        this.db = db;
        client_loggati = new ArrayList<>();
        System.err.println("Server ready");
    }

    public static void main(String[] args) throws RemoteException {
        Scanner s = new Scanner(System.in);
        String url = "jdbc:postgresql://", user, password;
        if (args.length == 5) {
            //System.out.println("Usage: java -jar <jarfile> <url> <user> <password>");
            //System.exit(1);
            url += args[0] + ":" + args[1] + "/" + args[2] + "?user=" + args[3] + "&password=" + args[4];
        } else {
            System.out.println("Inserire indirizzo del database: ");
            url += s.nextLine();
            System.out.println("Inserire porta del database: ");
            url += ":" + s.nextLine();
            System.out.println("Inserire nome del database: ");
            url += "/" + s.nextLine();
            System.out.println("Inserire username del database: ");
            url += "?user=" + s.nextLine();
            System.out.println("Inserire password del database: ");
            url += "&password=" + new String(s.nextLine());
        }
        DatabaseConnection db = new DatabaseConnection(url);
        DBInterface server = new Server(db);
        Registry r = LocateRegistry.createRegistry(1234);
        r.rebind("GestoreClimateMonitoring", server);
    }

    @Override
    public ArrayList<JAreaInteresse> loadAree_interesse(String filtro_nome, JCoordinate filtro_coordinate, int filtro_raggio, String id_stazione, int id_area) throws RemoteException {
        try {
            String baseQuery = "SELECT aree_interesse.* FROM aree_interesse";
            String whereClause = "";
            ArrayList<Object> parameters = new ArrayList<>();
            if (filtro_coordinate != null && filtro_raggio > 0 && filtro_nome == null) {
                whereClause = " INNER JOIN stazioni ON aree_interesse.geoname_id = stazioni.geoname_id WHERE ACOS(SIN(RADIANS(?)) * SIN(RADIANS(latitudine)) + COS(RADIANS(?)) * COS(RADIANS(latitudine)) * COS(RADIANS(? - longitudine))) * 6371 <= ?";
                parameters.add(filtro_coordinate.getLat());
                parameters.add(filtro_coordinate.getLat());
                parameters.add(filtro_coordinate.getLon());
                parameters.add(filtro_raggio);
            } else if (filtro_nome != null && filtro_coordinate == null && filtro_raggio == -1) {
                whereClause = " WHERE aree_interesse.nome LIKE ?";
                parameters.add(filtro_nome);
            } else if (id_stazione != null) {
                whereClause = " WHERE aree_interesse.geoname_id = ?";
                parameters.add(id_stazione);
                if (id_area != -1) {
                    whereClause += " AND aree_interesse.id_area_interesse = ?";
                    parameters.add(id_area);
                }
            }

            ResultSet rs = db.executeQuery(baseQuery + whereClause, parameters.toArray(), parameters.size() > 0);
            if (rs != null) {
                ArrayList<JAreaInteresse> aree_interesse = new ArrayList<>();
                while (rs.next()) {
                    aree_interesse.add(new JAreaInteresse(rs.getInt("id_area_interesse"), rs.getString("geoname_id"), rs.getString("nome")));
                }
                return aree_interesse;
            }
        } catch (Exception ex) {
            System.err.println("Errore nel caricamento delle aree d'interesse: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<JPrevisioni> loadPrevisioni(String geoname_id, int id_area_interesse, boolean dateFromFilter, Date dateFilter) throws RemoteException {
        try {
            String baseQuery = "SELECT previsioni.*, utenti.username FROM previsioni INNER JOIN utenti ON utenti.id_utente = previsioni.id_utente WHERE previsioni.geoname_id = ? AND previsioni.id_area_interesse = ?";
            baseQuery += dateFromFilter ? " AND previsioni.data >= CURRENT_DATE" : "";
            baseQuery += dateFilter != null ? " AND previsioni.data = ?" : "";
            ResultSet rs = db.executeQuery(baseQuery, new Object[]{geoname_id, id_area_interesse, dateFilter != null ? dateFilter : null}, true);
            if (rs != null) {
                ArrayList<JPrevisioni> previsioni = new ArrayList<>();
                while (rs.next()) {
                    JPrevisioni previsione = new JPrevisioni(rs.getInt("id_area_interesse"), rs.getInt("geoname_id"), rs.getDate("data"), rs.getString("username"), rs.getInt("valorevento"), rs.getInt("valoreumidita"), rs.getInt("valorepressione"), rs.getInt("valoretemperatura"), rs.getInt("valoreprecipitazioni"), rs.getInt("valorealtghiacciai"), rs.getInt("valoremassaghiacciai"), rs.getString("notavento"), rs.getString("notaumidita"), rs.getString("notapressione"), rs.getString("notatemperatura"), rs.getString("notaprecipitazioni"), rs.getString("notaaltghiacciai"), rs.getString("notamassaghiacciai"));
                    previsioni.add(previsione);
                }
                return previsioni;
            }
        } catch (Exception ex) {
            System.err.println("Errore nel caricamento delle previsioni: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<JStazione> loadStazioni(String filtro_id) throws RemoteException {
        try {
            String baseQuery = "SELECT stazioni.*, nome_nazione FROM stazioni INNER JOIN nazioni ON stazioni.country_code = nazioni.country_code";
            String whereClause = "";
            ArrayList<Object> parameters = new ArrayList<>();
            if (filtro_id != null) {
                whereClause += " WHERE geoname_id = ?";
                parameters.add(filtro_id);
            }
            ResultSet rs = db.executeQuery(baseQuery + whereClause, parameters.toArray(), parameters.size() > 0);
            if (rs != null) {
                ArrayList<JStazione> stazioni = new ArrayList<>();
                while (rs.next()) {
                    JStazione stazione = new JStazione(rs.getInt("geoname_id"), rs.getString("nome"), rs.getString("country_code"), rs.getString("nome_nazione"), new JCoordinate(rs.getFloat("latitudine"), rs.getFloat("longitudine")));
                    stazioni.add(stazione);
                }
                return stazioni;
            }
        } catch (Exception ex) {
            System.err.println("Errore nel caricamento delle stazioni: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<JNazione> loadNazioni() throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<JStazione> getStationGeonameIdfromWS(String cityName) throws RemoteException, IOException, InterruptedException {
        ArrayList<JStazione> stazioni = new ArrayList<>();
        String url = "http://api.geonames.org/searchJSON?lang=it&username=gexebit147&maxRows=5&country=IT&name_equals=" + cityName;
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        Gson gson = new Gson();
        JsonArray jsonArray = gson.fromJson(response.body(), JsonObject.class).getAsJsonArray("geonames");
        if (jsonArray == null) {
            return stazioni;
        }
        for (int i = 0; i < jsonArray.size(); i++) {
            JsonObject jsonObject = jsonArray.get(i).getAsJsonObject();
            JStazione stazione = gson.fromJson(jsonObject, JStazione.class);
            stazione.setCoordinate(new JCoordinate(jsonObject.get("lat").getAsFloat(), jsonObject.get("lng").getAsFloat()));
            stazioni.add(stazione);
        }
        return stazioni;
    }

    @Override
    public boolean checkCodiceOperatore(String codice_operatore) throws RemoteException {
        try {
            String baseQuery = "SELECT codice FROM codici_operatori WHERE codice = ?";
            ResultSet rs = db.executeQuery(baseQuery, new Object[]{codice_operatore}, true);
            if (rs != null) {
                if (rs.isBeforeFirst()) {
                    return true;
                }
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Errore nel controllo del codice operatore: " + ex.getMessage());
        }
        return false;
    }

    public boolean checkCodiceOperatoreUsed(String codice_operatore) throws RemoteException {
        try {
            String baseQuery = "SELECT codice_operatore FROM utenti WHERE codice_operatore = ?";
            ResultSet rs = db.executeQuery(baseQuery, new Object[]{codice_operatore}, true);
            if (rs != null) {
                if (rs.isBeforeFirst()) {
                    return true;
                }
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Errore nel controllo dell'esistenza del codice operatore: " + ex.getMessage());
        }
        return false;
    }

    public String checkUserAlreadyExistsByUsername(String username) throws RemoteException {
        try {
            String baseQuery = "SELECT max(username) as max_username FROM utenti WHERE username LIKE ?";
            ResultSet rs = db.executeQuery(baseQuery, new Object[]{username}, true);
            if (rs != null) {
                if (rs.isBeforeFirst()) {
                    rs.next();
                    String maxUsername = rs.getString("max_username");
                    if (maxUsername != null) {
                        StringBuilder numeroStr = new StringBuilder();
                        for (char c : maxUsername.toCharArray()) {
                            if (Character.isDigit(c)) {
                                numeroStr.append(c);
                            }
                        }
                        return numeroStr.length() > 0 ? numeroStr.toString() : "1";
                    }
                    return "1";
                }
                return "1";
            }
        } catch (Exception ex) {
            System.err.println("Errore nel controllo dell'utente già esistente con lo stesso username: " + ex.getMessage());
        }
        return "1";
    }


    @Override
    public boolean AddStazione(Integer geoname_id, String nome, String country_code, String country, JCoordinate coordinate) throws RemoteException {
        return false;
    }

    @Override
    public String AddUser(String nome, String cognome, String password, String cf, Integer geoname_id, String codiceOperatore) throws RemoteException {
        try {
            boolean checkCodiceOperatoreUsato = checkCodiceOperatoreUsed(codiceOperatore);
            if (!checkCodiceOperatoreUsato) {
                String username = nome.substring(0, 1) + "_" + cognome;
                String idNuovoUtente = checkUserAlreadyExistsByUsername(username + "%");
                System.out.println("Id nuovo utente: " + idNuovoUtente);

                username += idNuovoUtente;
                String email = username + "@mail.com";

                String baseQuery = "INSERT INTO utenti (nome,cognome,username,email,codice_operatore,codice_fiscale,geoname_id,password) VALUES (?,?,?,?,?,?,?,?)";
                int rs = db.executeUpdate(baseQuery, new Object[]{nome, cognome, username, email, codiceOperatore, cf, geoname_id, password}, true);
                System.out.println(rs);
                if (rs != -1) {
                    if (rs == 1) {
                        return username;
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Errore nell'aggiunta dell'utente: " + ex.getMessage());
        }
        return null;
    }

    @Override
    public boolean AddAreaInteresse(String nome, String geoname_id) throws RemoteException {
        String baseQuery = "INSERT INTO public.aree_interesse (nome, geoname_id) VALUES(?,?);";
        int rs = db.executeUpdate(baseQuery, new Object[]{nome, geoname_id}, true);
        return rs > 0;
    }

    @Override
    public boolean checkAreaInteresse(String nome, String geoname_id) throws RemoteException {
        String baseQuery = "SELECT id_area_interesse FROM aree_interesse WHERE LOWER(nome)=? AND geoname_id = ?";
        try {
            ResultSet rs = db.executeQuery(baseQuery, new Object[]{nome.toLowerCase(), geoname_id}, true);
            return rs.next() && rs.getInt("id_area_interesse") > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean AddPrevisione(Date data, Integer id_area, Integer id_centro, Integer username, String vVento, String pUmidita, String pressione, String temperatura, String precipitazioni, String aGhiacciai, String mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) throws RemoteException {
        String baseQuery = "INSERT INTO public.previsioni (" +
            "data, geoname_id, id_area_interesse, id_utente, valorevento, notavento, " +
            "valoreumidita, notaumidita, valorepressione, notapressione, " +
            "valoretemperatura, notatemperatura, valoreprecipitazioni, notaprecipitazioni, " +
            "valorealtghiacciai, notaaltghiacciai, valoremassaghiacciai, notamassaghiacciai) " +
            "VALUES(?, ?, ?, ?, ?::enum_valore, ?, ?::enum_valore, ?, ?::enum_valore, ?, ?::enum_valore, ?, ?::enum_valore, ?, ?::enum_valore, ?, ?::enum_valore, ?);";

        int rs = db.executeUpdate(baseQuery, new Object[]{
            data, 
            id_centro, 
            id_area, 
            username, 
            vVento, 
            nVento, 
            pUmidita, 
            nUmidita, 
            pressione, 
            nPRessione, 
            temperatura, 
            nTemperatura, 
            precipitazioni, 
            nPrecipitazioni, 
            aGhiacciai, 
            nAGhiacciai, 
            mGhiacciai, 
            nMGhiacciai
        }, true);
        return rs != -1;
    }

    @Override
    public JUser getUser(String user, String pass) throws RemoteException {
        String baseQuery = "SELECT * FROM utenti WHERE username = ? AND password = ?";
        ResultSet rs = db.executeQuery(baseQuery, new Object[]{user, pass}, true);
        if (rs != null) {
            try {
                if (rs.next()) {
                    return new JUser(user, rs.getString("nome"), rs.getString("cognome"), rs.getString("id_utente"), rs.getString("codice_fiscale"), rs.getString("email"), rs.getString("geoname_id"));
                }
            } catch (Exception ex) {
                System.err.println("Errore nel caricamento dell'utente: " + ex.getMessage());
            }
        }
        return null;
    }

    @Override
    public boolean login(InetAddress ip) throws RemoteException {
        if (client_loggati.contains(ip)) {
            //return false;
        }
        client_loggati.add(ip);
        System.out.println(client_loggati.get(0));
        return true;
    }
    
    
    /*
        String url = "jdbc:postgresql://localhost:5432/db_CM";
        String user = "postgres";
        String password = "root";
     */
}