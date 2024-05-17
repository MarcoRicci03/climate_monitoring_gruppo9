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
    public ArrayList<JAreaInteresse> loadAree_interesse(String filtro_nome, JCoordinate filtro_coordinate, int filtro_raggio) throws RemoteException {
        try {
            StringBuilder query = new StringBuilder("SELECT aree_interesse.nome, aree_interesse.geoname_id, aree_interesse.id_area_interesse FROM aree_interesse INNER JOIN stazioni ON aree_interesse.geoname_id = stazioni.geoname_id");
            /*
            SELECT aree_interesse.nome, aree_interesse.geoname_id, aree_interesse.id_area_interesse
            FROM aree_interesse INNER JOIN stazioni ON aree_interesse.geoname_id = stazioni.geoname_id
            WHERE ACOS(SIN(RADIANS(filtro_coordinate.getLatitudine())) * SIN(RADIANS(latitudine)) + COS(RADIANS(filtro_coordinate.getLatitudine())) * COS(RADIANS(latitudine)) * COS(RADIANS(filtro_coordinate.getLongitudine() - longitudine))) * 6371 <= RAGGIO
            AND aree_interesse.nome = filtro_nome
             */
            if (filtro_coordinate != null && filtro_raggio > 0) {
                query.append(" WHERE ACOS(SIN(RADIANS(")
                        .append(filtro_coordinate.getLat())
                        .append(")) * SIN(RADIANS(latitudine)) + COS(RADIANS(")
                        .append(filtro_coordinate.getLat())
                        .append(")) * COS(RADIANS(latitudine)) * COS(RADIANS(")
                        .append(filtro_coordinate.getLon())
                        .append(" - longitudine))) * 6371 <= ")
                        .append(filtro_raggio)
                        .append(" AND aree_interesse.nome = '")
                        .append(filtro_nome)
                        .append("'");
            } else if (filtro_nome != null) {
                query.append(" WHERE aree_interesse.nome = '")
                        .append(filtro_nome)
                        .append("'");
            }
            ResultSet rs = db.executeQuery(query.toString());
            ArrayList<JAreaInteresse> aree_interesse = new ArrayList<>();
            while (rs.next()) {
                JAreaInteresse area = new JAreaInteresse(rs.getInt("id_area_interesse"), rs.getInt("geoname_id"), rs.getString("nome"));
                aree_interesse.add(area);
            }
            return aree_interesse;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public ArrayList<JPrevisioni> loadPrevisioni(String geoname_id, int id_area_interesse) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<JStazione> loadStazioni() throws RemoteException {
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
        return null;
    }

    @Override
    public boolean login(InetAddress ip) throws RemoteException {
        if (client_loggati.contains(ip)) {
            return false;
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