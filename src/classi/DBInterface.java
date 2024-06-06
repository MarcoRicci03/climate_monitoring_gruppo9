package classi;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.IOException;
import java.util.Date;

/**
 * Interfaccia remota per la gestione delle operazioni del database.
 * Fornisce metodi per caricare dati e verificare esistenze nel database.
 *
 * @autor marco_ricci
 * @autor edoardo_rizzi
 * @autor alberto_stagno
 * @autor denis_di_napoli
 */
public interface DBInterface extends Remote {

    /**
     * Carica le aree di interesse dal database in base ai filtri forniti.
     *
     * @param filtro_nome       il nome da filtrare (può essere null).
     * @param filtro_coordinate le coordinate da utilizzare per la ricerca (può essere null).
     * @param filtro_raggio     il raggio per la ricerca basata su coordinate (deve essere maggiore di 0 se utilizzato).
     * @param id_stazione       l'ID della stazione da filtrare (può essere null).
     * @param id_area           l'ID dell'area di interesse da filtrare (può essere -1).
     * @return una lista di aree di interesse che soddisfano i criteri di filtro.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    ArrayList<JAreaInteresse> loadAree_interesse(String filtro_nome, JCoordinate filtro_coordinate, int filtro_raggio, String id_stazione, int id_area) throws RemoteException;

    /**
     * Carica le previsioni dal database in base ai filtri forniti.
     *
     * @param geoname_id        l'ID Geoname dell'area di interesse.
     * @param id_area_interesse l'ID dell'area di interesse.
     * @param dateFromFilter    indica se filtrare le previsioni a partire dalla data corrente.
     * @param dateFilter        la data specifica per cui filtrare le previsioni (può essere null).
     * @return una lista di previsioni che soddisfano i criteri di filtro.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    ArrayList<JPrevisioni> loadPrevisioni(String geoname_id, int id_area_interesse, boolean dateFromFilter, Date dateFilter) throws RemoteException;

    /**
     * Carica le stazioni dal database in base al filtro fornito.
     *
     * @param filtro_id   l'ID della stazione da filtrare (può essere null).
     * @param filtro_nome il nome della stazione da filtrare (può essere null).
     * @param coordinate  le coordinate della stazione da filtrare (può essere null).
     * @param raggio      il raggio per la ricerca basata su coordinate (deve essere maggiore di 0 se utilizzato).
     * @return una lista di stazioni che soddisfano i criteri di filtro.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    ArrayList<JStazione> loadStazioni(String filtro_id, String filtro_nome, JCoordinate coordinate, int raggio) throws RemoteException;

    /**
     * Carica tutte le nazioni dal database.
     *
     * @return una lista di nazioni.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    ArrayList<JNazione> loadNazioni() throws RemoteException;

    /**
     * Ottiene le stazioni Geoname ID dal servizio web in base al nome della città.
     *
     * @param cityName il nome della città per cui cercare le stazioni.
     * @return una lista di stazioni che corrispondono al nome della città.
     * @throws IOException          se si verifica un problema di I/O durante la comunicazione con il servizio web.
     * @throws InterruptedException se il thread viene interrotto durante l'attesa della risposta.
     */
    ArrayList<JStazione> getStationGeonameIdfromWS(String cityName) throws IOException, InterruptedException;

    /**
     * Controlla se il codice operatore esiste nella tabella codici_operatori.
     *
     * @param codice_operatore il codice operatore da verificare.
     * @return true se il codice operatore esiste nel database, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean checkCodiceOperatore(String codice_operatore) throws RemoteException;

    /**
     * Controlla se il codice operatore è già stato utilizzato.
     *
     * @param codice_operatore il codice operatore da verificare.
     * @return true se il codice operatore è già stato utilizzato, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean checkCodiceOperatoreUsed(String codice_operatore) throws RemoteException;

    /**
     * Controlla se esiste già un utente con lo stesso username.
     * Se esiste ritorna l'id nuovo, altrimenti ritorna "1".
     *
     * @param username lo username da verificare.
     * @return l'id nuovo se esiste un utente con lo stesso username, altrimenti "1".
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    String checkUserAlreadyExistsByUsername(String username) throws RemoteException;

    /**
     * Controlla se esiste una stazione con lo stesso geoname_id o nome.
     *
     * @param geoname_id l'ID Geoname della stazione da verificare.
     * @param nome       il nome della stazione da verificare.
     * @return true se esiste una stazione con lo stesso geoname_id o nome, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean checkExistStazione(String geoname_id, String nome) throws RemoteException;

    /**
     * Aggiunge una nuova stazione al database.
     *
     * @param geoname_id   l'ID Geoname della nuova stazione.
     * @param nome         il nome della nuova stazione.
     * @param country_code il codice del paese della nuova stazione.
     * @param coordinate   le coordinate (latitudine e longitudine) della nuova stazione.
     * @return true se la stazione è stata aggiunta con successo, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean AddStazione(String geoname_id, String nome, String country_code, JCoordinate coordinate) throws RemoteException;

    /**
     * Aggiunge un nuovo utente al database.
     *
     * @param nome            il nome dell'utente.
     * @param cognome         il cognome dell'utente.
     * @param password        la password dell'utente.
     * @param cf              il codice fiscale dell'utente.
     * @param geoname_id      l'ID Geoname associato all'utente.
     * @param codiceOperatore il codice operatore dell'utente.
     * @return lo username del nuovo utente se l'inserimento è avvenuto con successo, null altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    String AddUser(String nome, String cognome, String password, String cf, Integer geoname_id, String codiceOperatore) throws RemoteException;


    /**
     * Aggiunge una nuova area di interesse al database.
     *
     * @param geoname_id l'ID Geoname dell'area di interesse.
     * @param nome       il nome dell'area di interesse.
     * @return true se l'area di interesse è stata aggiunta con successo, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean AddAreaInteresse(String nome, String geoname_id) throws RemoteException;

    /**
     * Controlla se un'area di interesse esiste già nel database.
     *
     * @param nome       il nome dell'area di interesse.
     * @param geoname_id l'ID Geoname dell'area di interesse.
     * @return true se l'area di interesse esiste già, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean checkAreaInteresse(String nome, String geoname_id) throws RemoteException;

    /**
     * Aggiunge una nuova previsione al database.
     *
     * @param data            la data della previsione.
     * @param id_area         l'ID dell'area di interesse.
     * @param id_centro       l'ID del centro di previsione.
     * @param username        lo username dell'utente che aggiunge la previsione.
     * @param vVento          velocità del vento.
     * @param pUmidita        percentuale di umidità.
     * @param pressione       valore della pressione atmosferica.
     * @param temperatura     valore della temperatura.
     * @param precipitazioni  quantità di precipitazioni.
     * @param aGhiacciai      attività dei ghiacciai.
     * @param mGhiacciai      movimento dei ghiacciai.
     * @param nVento          nuova velocità del vento.
     * @param nUmidita        nuova percentuale di umidità.
     * @param nPRessione      nuova pressione atmosferica.
     * @param nTemperatura    nuova temperatura.
     * @param nPrecipitazioni nuove precipitazioni.
     * @param nAGhiacciai     nuova attività dei ghiacciai.
     * @param nMGhiacciai     nuovo movimento dei ghiacciai.
     * @return true se la previsione è stata aggiunta con successo, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean AddPrevisione(Date data, Integer id_area, String id_centro, Integer username, String vVento, String pUmidita, String pressione, String temperatura, String precipitazioni, String aGhiacciai, String mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) throws RemoteException;

    /**
     * Modifica una previsione esistente nel database.
     *
     * @param data            la data della previsione.
     * @param id_area         l'ID dell'area di interesse.
     * @param id_centro       l'ID del centro di previsione.
     * @param username        lo username dell'utente che modifica la previsione.
     * @param vVento          velocità del vento.
     * @param pUmidita        percentuale di umidità.
     * @param pressione       valore della pressione atmosferica.
     * @param temperatura     valore della temperatura.
     * @param precipitazioni  quantità di precipitazioni.
     * @param aGhiacciai      attività dei ghiacciai.
     * @param mGhiacciai      movimento dei ghiacciai.
     * @param nVento          nuova velocità del vento.
     * @param nUmidita        nuova percentuale di umidità.
     * @param nPRessione      nuova pressione atmosferica.
     * @param nTemperatura    nuova temperatura.
     * @param nPrecipitazioni nuove precipitazioni.
     * @param nAGhiacciai     nuova attività dei ghiacciai.
     * @param nMGhiacciai     nuovo movimento dei ghiacciai.
     * @return true se la previsione è stata modificata con successo, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean editPrevisione(Date data, Integer id_area, String id_centro, Integer username, String vVento, String pUmidita, String pressione, String temperatura, String precipitazioni, String aGhiacciai, String mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) throws RemoteException;

    /**
     * Rimuove una previsione dal database.
     *
     * @param data      la data della previsione.
     * @param id_area   l'ID dell'area di interesse.
     * @param id_centro l'ID del centro di previsione.
     * @return true se la previsione è stata rimossa con successo, false altrimenti.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    boolean removePrevisione(Date data, Integer id_area, String id_centro) throws RemoteException;

    /**
     * Ottiene le informazioni di un utente dal database.
     * Questo metodo è utilizzato per il login.
     *
     * @param user il nome utente.
     * @param pass la password dell'utente.
     * @return un oggetto JUser contenente le informazioni dell'utente.
     * @throws RemoteException se si verifica un problema di comunicazione remota.
     */
    JUser getUser(String user, String pass) throws RemoteException; //metodo per il log in
}
