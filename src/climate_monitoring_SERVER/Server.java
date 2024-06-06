package climate_monitoring_SERVER;

import classi.*;

import com.google.gson.Gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.net.URLEncoder;
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
    /**
     * Connessione al database utilizzata per le operazioni di accesso ai dati.
     */
    private DatabaseConnection db;

    /**
     * Costruttore della classe Server.
     * Inizializza la connessione al database e segnala che il server è pronto.
     *
     * @param db la connessione al database da utilizzare per le operazioni di accesso ai dati.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    public Server(DatabaseConnection db) throws RemoteException {
        this.db = db;
        System.err.println("Server ready");
    }

    /**
     * Punto di ingresso principale dell'applicazione server.
     * Configura la connessione al database e avvia il server RMI.
     *
     * @param args argomenti della riga di comando che includono URL del database, porta, nome, username e password.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
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

    /**
     * Carica le aree di interesse dal database in base ai filtri forniti.
     *
     * @param filtro_nome       il nome da filtrare (può essere null).
     * @param filtro_coordinate le coordinate da utilizzare per la ricerca (può essere null).
     * @param filtro_raggio     il raggio per la ricerca basata su coordinate (deve essere maggiore di 0 se utilizzato).
     * @param id_stazione       l'ID della stazione da filtrare (può essere null).
     * @param id_area           l'ID dell'area di interesse da filtrare (può essere -1).
     * @return una lista di aree di interesse che soddisfano i criteri di filtro, o null se si verifica un errore.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
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
                whereClause = " WHERE LOWER(aree_interesse.nome) LIKE LOWER(?)";
                parameters.add("%" + filtro_nome.toLowerCase() + "%");
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

    /**
     * Carica le previsioni dal database in base ai filtri forniti.
     *
     * @param geoname_id        l'ID Geoname dell'area di interesse.
     * @param id_area_interesse l'ID dell'area di interesse.
     * @param dateFromFilter    indica se filtrare le previsioni a partire dalla data corrente.
     * @param dateFilter        la data specifica per cui filtrare le previsioni (può essere null).
     * @return una lista di previsioni che soddisfano i criteri di filtro, o null se si verifica un errore.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    @Override
    public ArrayList<JPrevisioni> loadPrevisioni(String geoname_id, int id_area_interesse, boolean dateFromFilter, Date dateFilter) throws RemoteException {
        try {
            String baseQuery = "SELECT previsioni.*, utenti.username FROM previsioni INNER JOIN utenti ON utenti.id_utente = previsioni.id_utente WHERE previsioni.geoname_id = ? AND previsioni.id_area_interesse = ?";
            baseQuery += dateFromFilter ? " AND previsioni.data >= CURRENT_DATE" : "";
            baseQuery += dateFilter != null ? " AND previsioni.data = ?" : "";
            baseQuery += " ORDER BY previsioni.data DESC";
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

    /**
     * Carica le stazioni dal database in base al filtro fornito.
     *
     * @param filtro_id l'ID della stazione da filtrare (può essere null).
     * @return una lista di stazioni che soddisfano i criteri di filtro, o null se si verifica un errore.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
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

    /**
     * Carica tutte le nazioni dal database.
     *
     * @return una lista di nazioni, o null se si verifica un errore.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    @Override
    public ArrayList<JNazione> loadNazioni() throws RemoteException {
        try {
            String baseQuery = "SELECT * FROM nazioni";
            ArrayList<Object> parameters = new ArrayList<>();
            ResultSet rs = db.executeQuery(baseQuery, parameters.toArray(), parameters.size() > 0);
            if (rs != null) {
                ArrayList<JNazione> nazioni = new ArrayList<>();
                while (rs.next()) {
                    JNazione nazione = new JNazione(rs.getString("country_code"), rs.getString("nome_nazione"));
                    nazioni.add(nazione);
                }
                return nazioni;
            }
        } catch (Exception ex) {
            System.err.println("Errore nel caricamento delle nazioni: " + ex.getMessage());
        }
        return null;
    }

    /**
     * Ottiene le stazioni Geoname ID dal servizio web in base al nome della città.
     *
     * @param cityName il nome della città per cui cercare le stazioni.
     * @return una lista di stazioni che corrispondono al nome della città.
     * @throws RemoteException      se si verifica un problema di comunicazione remota.
     * @throws IOException          se si verifica un problema di I/O durante la comunicazione con il servizio web.
     * @throws InterruptedException se il thread viene interrotto durante l'attesa della risposta.
     */
    @Override
    public ArrayList<JStazione> getStationGeonameIdfromWS(String cityName) throws RemoteException, IOException, InterruptedException {
        ArrayList<JStazione> stazioni = new ArrayList<>();
        String url = "http://api.geonames.org/searchJSON?lang=en&username=gexebit147&maxRows=8&name_equals=" + URLEncoder.encode(cityName, "UTF-8");
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

    /**
     * Verifica se il codice operatore esiste nel database.
     *
     * @param codice_operatore il codice operatore da verificare.
     * @return true se il codice operatore esiste nel database, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
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

    /**
     * Verifica se il codice operatore è già stato utilizzato nel database.
     *
     * @param codice_operatore il codice operatore da verificare.
     * @return true se il codice operatore è già stato utilizzato, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
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

    /**
     * Verifica se esiste già un utente con lo stesso username nel database.
     * Restituisce il numero più alto trovato nell'username, o "1" se nessun numero è trovato.
     *
     * @param username lo username da verificare.
     * @return una stringa rappresentante il numero più alto trovato nell'username, o "1" se nessun numero è trovato o in caso di errore.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
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

    /**
     * Verifica se esiste già una stazione con lo stesso geoname_id o nome nel database.
     *
     * @param geoname_id l'ID Geoname della stazione da verificare.
     * @param nome       il nome della stazione da verificare.
     * @return true se esiste già una stazione con lo stesso geoname_id o nome, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    @Override
    public boolean checkExistStazione(String geoname_id, String nome) throws RemoteException {
        try {
            String baseQuery = "SELECT geoname_id, nome FROM stazioni WHERE geoname_id = ? OR nome = ?";
            ResultSet rs = db.executeQuery(baseQuery, new Object[]{geoname_id, nome}, true);
            if (rs != null) {
                if (rs.isBeforeFirst()) {
                    return true;
                }
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Errore nel controllo dell'esistenza di una stazione già presente: " + ex.getMessage());
        }
        return false;
    }

    /**
     * Aggiunge una nuova stazione al database.
     * Verifica se esiste già una stazione con lo stesso geoname_id o nome prima di inserirla.
     *
     * @param geoname_id   l'ID Geoname della nuova stazione.
     * @param nome         il nome della nuova stazione.
     * @param country_code il codice del paese della nuova stazione.
     * @param coordinate   le coordinate (latitudine e longitudine) della nuova stazione.
     * @return true se la stazione è stata aggiunta con successo, false se la stazione esiste già o se si verifica un errore.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    @Override
    public boolean AddStazione(String geoname_id, String nome, String country_code, JCoordinate coordinate) throws RemoteException {
        try {
            //controllo l'esistenza di una stazione con lo stesso geoname_id - nome
            boolean isStazioneUsata = checkExistStazione(geoname_id, nome);
            if (!isStazioneUsata) {
                //inserisco la stazione
                String baseQuery = "INSERT INTO stazioni (geoname_id,nome,country_code,latitudine,longitudine) VALUES (?,?,?,?,?)";
                int rs = db.executeUpdate(baseQuery, new Object[]{geoname_id, nome, country_code, coordinate.getLat(), coordinate.getLon()}, true);
                return rs != -1 && rs == 1;
            } else {
                return false;
            }
        } catch (Exception ex) {
            System.err.println("Errore nell'aggiunta della stazione: " + ex.getMessage());
        }
        return false;
    }

    /**
     * Aggiunge un nuovo utente al database.
     * Verifica se il codice operatore è già stato utilizzato prima di inserire il nuovo utente.
     *
     * @param nome il nome dell'utente.
     * @param cognome il cognome dell'utente.
     * @param password la password dell'utente.
     * @param cf il codice fiscale dell'utente.
     * @param geoname_id l'ID Geoname associato all'utente.
     * @param codiceOperatore il codice operatore dell'utente.
     * @return lo username del nuovo utente se l'inserimento è avvenuto con successo, null altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    @Override
    public String AddUser(String nome, String cognome, String password, String cf, Integer geoname_id, String codiceOperatore) throws RemoteException {
        try {
            boolean checkCodiceOperatoreUsato = checkCodiceOperatoreUsed(codiceOperatore);
            if (!checkCodiceOperatoreUsato) {
                String username = nome.substring(0, 1) + "_" + cognome;
                String idNuovoUtente = checkUserAlreadyExistsByUsername(username + "%");
                username += idNuovoUtente;
                String email = username + "@mail.com";

                String baseQuery = "INSERT INTO utenti (nome,cognome,username,email,codice_operatore,codice_fiscale,geoname_id,password) VALUES (?,?,?,?,?,?,?,?)";
                int rs = db.executeUpdate(baseQuery, new Object[]{nome, cognome, username, email, codiceOperatore, cf, geoname_id, password}, true);
                return rs == 1 ? username : null;
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

    /**
     * Recupera un utente dal database in base allo username e alla password forniti.
     *
     * @param user lo username dell'utente.
     * @param pass la password dell'utente.
     * @return un oggetto JUser che rappresenta l'utente se le credenziali sono corrette, null altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    @Override
    public boolean AddPrevisione(Date data, Integer id_area, String id_centro, Integer username, String vVento, String pUmidita, String pressione, String temperatura, String precipitazioni, String aGhiacciai, String mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) throws RemoteException {
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
    public boolean editPrevisione(Date data, Integer id_area, String id_centro, Integer username, String vVento, String pUmidita, String pressione, String temperatura, String precipitazioni, String aGhiacciai, String mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) throws RemoteException {
        
        String baseQuery = "UPDATE public.previsioni SET " +
                            "valorevento = ?::enum_valore, notavento = ?, " +
                            "valoreumidita = ?::enum_valore, notaumidita = ?, " +
                            "valorepressione = ?::enum_valore, notapressione = ?, " +
                            "valoretemperatura = ?::enum_valore, notatemperatura = ?, " +
                            "valoreprecipitazioni = ?::enum_valore, notaprecipitazioni = ?, " +
                            "valorealtghiacciai = ?::enum_valore, notaaltghiacciai = ?, " +
                            "valoremassaghiacciai = ?::enum_valore, notamassaghiacciai = ? " +
                            "WHERE data = ? AND geoname_id = ? AND id_area_interesse = ? AND id_utente = ?;";

        
        int rs = db.executeUpdate(baseQuery, new Object[]{
            vVento,              // valorevento
            nVento,              // notavento
            pUmidita,            // valoreumidita
            nUmidita,            // notaumidita
            pressione,           // valorepressione
            nPRessione,          // notapressione
            temperatura,         // valoretemperatura
            nTemperatura,        // notatemperatura
            precipitazioni,      // valoreprecipitazioni
            nPrecipitazioni,     // notaprecipitazioni
            aGhiacciai,          // valorealtghiacciai
            nAGhiacciai,         // notaaltghiacciai
            mGhiacciai,          // valoremassaghiacciai
            nMGhiacciai,         // notamassaghiacciai
            data,                // data
            id_centro,           // geoname_id
            id_area,             // id_area_interesse
            username             // id_utente
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
    public boolean removePrevisione(Date data, Integer id_area, String id_centro) throws RemoteException {
         String baseQuery = "DELETE FROM public.previsioni " +
                            "WHERE data = ? AND geoname_id = ? AND id_area_interesse = ?;";

        
        int rs = db.executeUpdate(baseQuery, new Object[]{
            data,                // data
            id_centro,           // geoname_id
            id_area,             // id_area_interesse
        }, true);
        return rs != -1;
    }
}