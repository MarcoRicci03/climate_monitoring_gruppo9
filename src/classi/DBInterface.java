/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.util.ArrayList;
import java.rmi.Remote;
import java.rmi.RemoteException;
import classi.*;
import java.io.IOException;
import java.net.InetAddress;
import java.util.Date;

/**
 *
 * @author marco
 */
public interface DBInterface extends Remote {
    ArrayList<JAreaInteresse> loadAree_interesse(String filtro_nome, JCoordinate filtro_coordinate, int filtro_raggio, String id_stazione, int id_area) throws RemoteException;
    ArrayList<JPrevisioni> loadPrevisioni(String geoname_id, int id_area_interesse, boolean dateFromFilter, Date dateFilter) throws RemoteException;

    ArrayList<JStazione> loadStazioni() throws RemoteException;
    ArrayList<JNazione> loadNazioni() throws RemoteException;
    ArrayList<JStazione> getStationGeonameIdfromWS(String cityName) throws IOException, InterruptedException; //carica i geoname_id da webService

    //Controllo che il codice operatore esiste nella tabella codici_operatori
    boolean checkCodiceOperatore(String codice_operatore) throws RemoteException;
    //Controllo che non esista già un utente con lo stesso codice operatore
    boolean checkCodiceOperatoreUsed(String codice_operatore ) throws RemoteException;
    //Controllo che non esista già un utente con lo stesso username, se esiste ritorno id nuovo, se non esiste ritorno 1
    String checkUserAlreadyExistsByUsername(String username) throws RemoteException;

    boolean AddStazione(Integer geoname_id, String nome, String country_code, String country, JCoordinate coordinate) throws RemoteException;
    boolean AddUser(String nome, String cognome, String password, String cf, Integer geoname_id, String codiceOperatore) throws RemoteException;
    boolean AddAreaInteresse(Integer id_area, String geoname_id, String nome) throws RemoteException;
    //in add previsione manca la data dopo id_centro, non so se devo importare la classe date di java.util o altre
    boolean AddPrevisione(Integer id_area, Integer id_centro, String username, Integer vVento, Integer pUmidita, Integer pressione, Integer temperatura, Integer precipitazioni, Integer aGhiacciai, Integer mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) throws RemoteException;

    JUser getUser() throws  RemoteException; //metodo per il log in
    boolean login(InetAddress ip) throws  RemoteException;;
}
