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

    public static ArrayList<JLuogo> creaListaStazioni() {
        ArrayList<JLuogo> l = new ArrayList<>();
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fStazioni), StandardCharsets.UTF_8);
            for (String s : list) {
                l.add(new JLuogo(s));
            }
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
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

    public static boolean registraUtente(String nome, String cognome, String pass, String cf, Integer id_stazione, String codiceOperatore) {
        try {
            boolean ris = false;
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fUtenti), StandardCharsets.UTF_8);
            String s1;
            for (int i = 0; i < list.size() && !ris; i++) {
                s1 = list.get(i);
                String[] elements = s1.split(";");
                ris = elements[8].equals(codiceOperatore);
            }
            if (!ris) {
                String username = nome.substring(0, 1) + "_" + cognome;
                Integer id = 0;
                Integer cont = 1;
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
            } else {
                return false;
            }
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
    public static ArrayList<JAreaInteresse> getAllAreeInteresse() {
        ArrayList<JAreaInteresse> ret = new ArrayList<JAreaInteresse>();
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
            for (String s : list) {
                String[] elements = s.split(";");
                ret.add(new JAreaInteresse(Integer.parseInt(elements[0]), Integer.parseInt(elements[2]), elements[1]));                
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
    public static JUser creaUtenteLoggato(String username, String pass) throws IOException {
        boolean ris = true;
        JUser user;
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fUtenti), StandardCharsets.UTF_8);
        for (String s : list) {
            String[] elements = s.split(";");
            ris = elements[3].equals(username) && elements[5].equals(pass);
            if (ris == true) {
                return user = new JUser(elements);
            }
        }
        return null;
    }

    public static ArrayList<JPrevisioni> creaListaPrevisioni(Integer id_area) throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
        ArrayList<JPrevisioni> l = new ArrayList<>();
        for (String s : list) {
            String[] elements = s.split(";");
            if (Integer.parseInt(elements[2]) == id_area) {
                String data = elements[0];
                l.add(new JPrevisioni(data, Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[3], Integer.parseInt(elements[4]), Integer.parseInt(elements[5]), Integer.parseInt(elements[6]), Integer.parseInt(elements[7]), Integer.parseInt(elements[8]), Integer.parseInt(elements[9]), Integer.parseInt(elements[10])));
            }
        }
        return l;
    }

    public static Integer aggiungiPrevisione(JPrevisioni previsione) {
        try {
            Integer id = 1;
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
            for (String s : list) {
                id++;
            }

            FileWriter fileWriter = new FileWriter(new File(fPrevisioni), true);
            String line = previsione.toCSV() + "\n";
            fileWriter.append(line);
            fileWriter.close();
            return id;

        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public static ArrayList<JAreaInteresse> cercaPerArea(String citta) {
        try {
            ArrayList<JAreaInteresse> aL = new ArrayList<>();
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
            for (String s : list) {
                String[] elements = s.split(";");
                if (elements[1].toLowerCase().contains(citta.toLowerCase())) {
                    aL.add(new JAreaInteresse(Integer.parseInt(elements[0]), Integer.parseInt(elements[2]), elements[1]));
                }
            }

            return aL;
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static ArrayList<JLuogo> cercaPerStazione(String citta, JCoordinate coordinate, Integer scartoDistanza) {
        try {
            ArrayList<JLuogo> aL = new ArrayList<>();
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fStazioni), StandardCharsets.UTF_8);
            for (String s : list) {
                JLuogo l = new JLuogo(s);
                if (citta != null) {
                    if (l.getNome().toLowerCase().contains(citta.toLowerCase())) {
                        aL.add(new JLuogo(s));
                    }
                } else if (coordinate != null) {
                    if (l.getCoordinate().distanzaDa(coordinate) < scartoDistanza) {
                        aL.add(new JLuogo(s));
                    }
                }
            }
            return aL;
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
