/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class ParserCSV {

    private static final String fStazioni = "dati/stazioni.csv";
    private static final String fUtenti = "dati/utenti.csv";
    private static final String fAreeInteresse = "dati/areedinteresse.csv";
    private static final String fNazioni = "dati/nazioni.csv";
    private static final String fOperatori = "dati/operatori.csv";
    private static final String fPrevisioni = "dati/previsioni.csv";

    public static ArrayList<JLuogo> creaLista() throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fStazioni), StandardCharsets.UTF_8);
        ArrayList<JLuogo> l = new ArrayList<>();
        for (String s : list) {
            String[] elements = s.split(";");
            l.add(new JLuogo(Integer.valueOf(elements[0]), elements[1], elements[2], elements[3], new JCoordinate(Float.valueOf(elements[4].split(",")[0]), Float.valueOf(elements[4].split(",")[1]))));
        }
        return l;
    }

    public static boolean creaStazione(String geoname_id, String citta, String cod_nazione, String nazione, String coordinate) {
        try {
            FileWriter fileWriter = new FileWriter(new File(fStazioni), true);
            String line = geoname_id + ";" + citta + ";" + cod_nazione + ";" + nazione + ";" + coordinate + "\n";
            fileWriter.append(line);
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static boolean esisteUtente(String username, String pass) throws IOException {
        boolean ris = true;
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fUtenti), StandardCharsets.UTF_8);
        for (String s : list) {
            String[] elements = s.split(";");
            ris = elements[3].equals(username) && elements[5].equals(pass);
            if (ris == true) {
                return true;
            }
        }
        return false;
    }

    public static boolean registraUtente(String nome, String cognome, String pass, String cf, Integer id_stazione) {
        try {
            String username = nome.substring(0, 1) + "_" + cognome;
            Integer id = 0;
            Integer cont = 1;
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fUtenti), StandardCharsets.UTF_8);
            for (String s : list) {
                id++;
                String[] elements = s.split(";");
                if (elements[3].contains(username)) {
                    cont++;
                }
            }
            username += cont.toString();

            System.out.println(username);
            //scrivo su file
            String mail = username + "@mail.com";
            FileWriter fileWriter = new FileWriter(new File(fUtenti), true);
            String line = id + ";" + nome + ";" + cognome + ";" + username + ";" + mail + ";" + pass + ";" + cf + ";" + id_stazione + "\n";
            fileWriter.append(line.toString());
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    public static ArrayList<String[]> getNazioni() throws IOException {
        ArrayList<String[]> ar = new ArrayList<String[]>();
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fNazioni), StandardCharsets.UTF_8);
        int cont = 0;
        for (String s : list) {
            String[] elements = s.split(";");
            ar.add(elements);
        }
        return ar;
    }

    public static boolean checkCodiceOperatore(String codice_operatore) {
        codice_operatore = codice_operatore.trim();
        Boolean ret = false;
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fOperatori), StandardCharsets.UTF_8);
            for (String line : list) {
                if (line.equals(codice_operatore)) {
                    ret = true;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public static ArrayList<JAreaInteresse> getAreeInteresse(Integer geoname_id) {
        ArrayList<JAreaInteresse> ret = new ArrayList<JAreaInteresse>();
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
            for (String s : list) {
                String[] elements = s.split(";");
                if (Integer.parseInt(elements[2]) == geoname_id) {
                    ret.add(new JAreaInteresse(Integer.parseInt(elements[0]), Integer.parseInt(elements[2]), elements[1]));
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public static Integer aggiungiAreaInteresse(Integer geoname_id, String nome) {
        try {
            Integer id = 1;
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
            for (String s : list) {
                id++;
            }

            FileWriter fileWriter = new FileWriter(new File(fAreeInteresse), true);
            String line = id + ";" + nome + ";" + geoname_id + "\n";
            fileWriter.append(line);
            fileWriter.close();
            return id;

        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    ///Restituisce oggetto User con tutte le info
    public static JUser creaUtenteLoggato(String username, String pass) throws IOException{
        boolean ris = true;
        JUser user;
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fUtenti), StandardCharsets.UTF_8);
        for (String s : list) {
            String[] elements = s.split(";");
            ris = elements[3].equals(username) && elements[5].equals(pass);
            if (ris == true) {
                return user=new JUser(elements);
            }       
        }
        return null;
    }
    
    public static ArrayList<JPrevisioni> creaListaPrevisioni() throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
        ArrayList<JPrevisioni> l = new ArrayList<>();
        for (String s : list) {
            String[] elements = s.split(";");
            Date data=new Date(elements[0]);
            l.add(new JPrevisioni(data,Integer.parseInt(elements[1]),Integer.parseInt(elements[2]),elements[3],Integer.parseInt(elements[4]),Integer.parseInt(elements[5]),Integer.parseInt(elements[6]),Integer.parseInt(elements[7]),Integer.parseInt(elements[8]),Integer.parseInt(elements[9]),Integer.parseInt(elements[10])));
        }
        return l;
    }
    public static List<String[]> creaListaPrevisioniFromCSV(ArrayList<JPrevisioni> lista){
        ArrayList<JPrevisioni> list =lista;
        List<String[]> listaPrev=new ArrayList<>();
        for (JPrevisioni prev : list){
            String[] elements=prev.toString().split(",");
            listaPrev.add(elements);
        }
        return listaPrev;
        
    }
}
