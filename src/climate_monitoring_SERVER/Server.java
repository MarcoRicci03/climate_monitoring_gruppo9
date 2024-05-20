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
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


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
            } else if(id_stazione != null && id_area != -1) {
                whereClause = " WHERE aree_interesse.geoname_id = ? AND aree_interesse.id_area_interesse = ?";
                parameters.add(id_stazione);
                parameters.add(id_area);
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
    public ArrayList<JStazione> loadStazioni() throws RemoteException {
        try {
            String baseQuery = "SELECT stazioni.*, nome_nazione FROM stazioni INNER JOIN nazioni ON stazioni.country_code = nazioni.country_code";
            ResultSet rs = db.executeQuery(baseQuery, null, false);
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
        return false;
    }

    @Override
    public boolean AddStazione(Integer geoname_id, String nome, String country_code, String country, JCoordinate coordinate) throws RemoteException {
        return false;
    }

    @Override
    public boolean AddUser(Integer id_utente, String nome, String cognome, String username, String mail, String password, String cf, Integer geoname_id) throws RemoteException {
        return false;
    }

    @Override
    public boolean AddAreaInteresse(Integer id_area, String geoname_id, String nome) throws RemoteException {
        return false;
    }

    @Override
    public boolean AddPrevisione(Integer id_area, Integer id_centro, String username, Integer vVento, Integer pUmidita, Integer pressione, Integer temperatura, Integer precipitazioni, Integer aGhiacciai, Integer mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) throws RemoteException {
        return false;
    }

    @Override
    public JUser getUser() throws RemoteException {
        //ResultSet rs = db.executeQuery("SELECT * FROM utenti WHERE username = 'admin'");
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