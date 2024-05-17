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

/**
 *
 * @author marco
 */
public interface DBInterface extends Remote {
    ArrayList<JAreaInteresse> loadAree_interesse(String filtro_nome, JCoordinate filtro_coordinate, int filtro_raggio) throws RemoteException;
    ArrayList<JPrevisioni> loadPrevisioni(String geoname_id, int id_area_interesse) throws RemoteException;

    ArrayList<JStazione> loadStazioni() throws RemoteException;
    ArrayList<JNazione> loadNazioni() throws RemoteException;
    ArrayList<JStazione> getStationGeonameIdfromWS(String cityName) throws IOException, InterruptedException; //carica i geoname_id da webService

    boolean checkCodiceOperatore(String codice_operatore) throws RemoteException;

    boolean AddStazione(Integer geoname_id, String nome, String country_code, String country, JCoordinate coordinate) throws RemoteException;
    boolean AddUser(Integer id_utente, String nome, String cognome, String username, String mail, String password, String cf, Integer geoname_id) throws RemoteException;
    boolean AddAreaInteresse(Integer id_area, String geoname_id, String nome) throws RemoteException;
    //in add previsione manca la data dopo id_centro, non so se devo importare la classe date di java.util o altre
    boolean AddPrevisione(Integer id_area, Integer id_centro, String username, Integer vVento, Integer pUmidita, Integer pressione, Integer temperatura, Integer precipitazioni, Integer aGhiacciai, Integer mGhiacciai, String nVento, String nUmidita, String nPRessione, String nTemperatura, String nPrecipitazioni, String nAGhiacciai, String nMGhiacciai) throws RemoteException;

    JUser getUser() throws  RemoteException; //metodo per il log in
    boolean login(InetAddress ip) throws  RemoteException;;
}
