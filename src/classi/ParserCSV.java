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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 * Classe per la gestione dei file
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class ParserCSV {

    //    /**
//     * file che presenta tutte le stazioni metereologiche create
//     */
    private static final String fStazioni = "dati/.csv"; //file che presenta tutte le stazioni metereologiche create
    //    /**
//     * file che presenta tutte gli utenti inserite
//     */
    private static final String fUtenti = "dati/.csv";
    //    /**
//     * file che presenta tutte le aree di interesse create
//     */
    private static final String fAreeInteresse = "dati/areedinteresse"; //file che presenta tutte le aree di interesse create
    //    /**
//     * file che presenta tutte le nazioni inserite
//     */
    private static final String fNazioni = "dati/.csv";
    //    /**
//     * file che presenta tutti gli operatori registrati
//     */
    private static final String fOperatori = "dati/.csv"; //file che presenta tutti gli operatori registrati
    //    /**
//     * file che presenta tutte le previsioni inserite
//     */
    private static final String fPrevisioni = "dati/.csv"; //file che presenta tutte le previsioni inserite

    //
//    /**
//     * Metodo che restituisce una lista contente tutte le stazioni presenti nel
//     * file stazioni.csv
//     *
//     * @return lista con tutte le stazioni
//     */
    public static ArrayList<JStazione> creaListaStazioni() {
        ArrayList<JStazione> l = new ArrayList<>();
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fStazioni), StandardCharsets.UTF_8);
            for (String s : list) {
                // l.add(new JStazione(s));
            }
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }

    //    /**
//     * Metodo che dato un geoname id restituisce la stazione associata.
//     *
//     * @param id codice identificativo della stazione.
//     * @return restituisce un JLuogo in caso di successo e null in caso di
//     * fallimento.
//     */
    public static JStazione getStazione(int id) {
        ArrayList<JStazione> listaStazioni = creaListaStazioni();
        for (JStazione l : listaStazioni) {
            if (l.getGeoname_id() == id) {
                return l;
            }
        }
        return null;
    }

    //
//    /**
//     * Metodo che crea una nuova stazione, controlla se esiste già, in caso non
//     * esista la salva nel file.
//     *
//     * @param geoname_id codice che indica la stazione metereologica.
//     * @param citta indica la citta in cui è presente la stazione
//     * @param cod_nazione codice identificativo della nazione in cui si trova la
//     * stazione.
//     * @param nazione indica la nazione nella quale si trova la nazione.
//     * @param coordinate indica le coordinate geografiche relative alla città
//     * dove si trova la nazione.
//     * @return restituisce un valore booleano che concorda con l'esito del
//     * metodo
//     */
    public static boolean creaStazione(String geoname_id, String citta, String cod_nazione, String nazione, String coordinate) {
        ArrayList<JStazione> listaStazioni = creaListaStazioni();
        Boolean sentinella = true;
        //cerca per id
        for (int i = 0; i < listaStazioni.size() && sentinella; i++) {
            if (listaStazioni.get(i).getGeoname_id() == Integer.parseInt(geoname_id) || listaStazioni.get(i).getNome().toLowerCase().equals(citta.toLowerCase())) {
                sentinella = false;
            }
        }
        if (sentinella) {
            try {
                FileWriter fileWriter = new FileWriter(new File(fStazioni), true);
                String line = geoname_id + ";" + citta + ";" + cod_nazione + ";" + nazione + ";" + coordinate + "\n";
                //fileWriter.append(line);
                fileWriter.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        } else {
            return false;
        }
    }

    //    /**
//     * Metodo che salva un nuovo utente nel file 'utenti.csv'
//     *
//     * @param nome indica il nome dell'operatore.
//     * @param cognome indica il cognome dell'operatore.
//     * @param pass indica la parola con cui accedere nell'area riservata agli
//     * operatori.
//     * @param cf indica il codice fiscale dell'operatore.
//     * @param id_stazione indica l'id della stazione di cui fa parte l'operatore
//     * @param codiceOperatore codice dell'operatore
//     *
//     * @return restituisce un valore booleano che concorda con l'esito del
//     * metodo
//     */
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
                Integer id = 1;
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
                String line = id + ";" + nome + ";" + cognome + ";" + username + ";" + mail + ";" + pass + ";" + cf + ";" + id_stazione + ";" + codiceOperatore + "\n";
                fileWriter.append(line);
                fileWriter.close();
                JOptionPane.showMessageDialog(null, "Registrazione effettuata.\nEcco il tuo username: " + username + " per accedere assieme alla password.", "Registrazione effettuata", JOptionPane.INFORMATION_MESSAGE);
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Errore nella registrazione.", "Errore", JOptionPane.INFORMATION_MESSAGE);
                return false;
            }
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    //    /**
//     * Metodo che restituisce la lista di tutte le nazioni presenti nel file
//     * 'nazioni.csv'
//     *
//     * @return lista di vettori di stringhe
//     * @throws IOException
//     */
    public static ArrayList<String[]> getNazioni() throws IOException {
        ArrayList<String[]> ar = new ArrayList<String[]>();
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fNazioni), StandardCharsets.UTF_8);
        for (String s : list) {
            String[] elements = s.split(";");
            ar.add(elements);
        }
        return ar;
    }

    /**
     * //     * Metodo che verifica l'esistenza del codice operatore nel file
     * //     * 'operatori.csv'
     * //     *
     * //     * @param codice_operatore identifica l'operatore
     * //     * @return restituisce un valore booleano che concorda con l'esito del
     * //     * metodo
     * //
     */
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

    //    /**
//     * Metodo che restituisce tutte le aree di interesse presenti nel file
//     * 'areedinteresse.csv' con il geoname_id passato come parametro.
//     *
//     * @param geoname_id codice identificativo dell'area d'interesse
//     * @return lista di oggetti JAreeInteresse
//     */
    public static ArrayList<JAreaInteresse> getAreeInteresse(int geoname_id) {
//        ArrayList<JAreaInteresse> ret = new ArrayList<JAreaInteresse>();
//        try {
//            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
//            for (String s : list) {
//                String[] elements = s.split(";");
//                if (Integer.parseInt(elements[2]) == geoname_id) {
//                    ret.add(new JAreaInteresse(Integer.parseInt(elements[0]), Integer.parseInt(elements[2]), elements[1]));
//                }
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return ret;
        return  null;
    }

    //    /**
//     * Metodo che restituisce tutte le aree di interesse presenti nel file
//     * 'areedinteresse.csv'
//     *
//     * @return lista di oggetti JAreeInteresse
//     */
    public static ArrayList<JAreaInteresse> getAllAreeInteresse() {
//        ArrayList<JAreaInteresse> ret = new ArrayList<JAreaInteresse>();
//        try {
//            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
//            for (String s : list) {
//                String[] elements = s.split(";");
//                ret.add(new JAreaInteresse(Integer.parseInt(elements[0]), Integer.parseInt(elements[2]), elements[1]));
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return ret;
        return null;
    }

    //    /**
//     * Metodo che dato un id restitusice il nome dell'area d'interesse.
//     *
//     * @param geoname_id codice identificativo della stazione
//     * @return restituisce una stringa, se l'operazione va a buon fine
//     * restituisce il nome della stazione altrimenti restituisce una stringa
//     * vuota ("")
//     */
    public static String getNomeAreaByGeonameId(int geoname_id) {
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
            for (String temp : list) {
                String[] elements = temp.split(";");
                if (Integer.parseInt(elements[0]) == geoname_id) {
                    return elements[1];
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    //    /**
//     * Metodo che dato un {@code} geoname_id ed un {@code} nome dell'area,
//     * aggiunge una nuova area di interesse nel file 'areedinteresse.csv'
//     *
//     * @param geoname_id codice identificativo della stazione
//     * @param nome nome dell'area da aggiungere
//     * @return restituisce un valore intero, se l'operazione va a buon fine
//     * restituisce l'id della nuova area oppure restituisce '-1' se l'operazione
//     * non va a buon fine
//     */
    public static Integer aggiungiAreaInteresse(Integer geoname_id, String nome) {
        try {
            Integer id = 1;
            Boolean sentinella = true;
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
            for (id = 0; id < list.size(); id++) {
                if (list.get(id).split(";")[1].toLowerCase().equals(nome.toLowerCase())) {
                    sentinella = false;
                }
            }
            id++;
            if (sentinella) {
                FileWriter fileWriter = new FileWriter(new File(fAreeInteresse), true);
                String line = id + ";" + nome + ";" + geoname_id + "\n";
                fileWriter.append(line);
                fileWriter.close();
                return id;
            } else {
                return -1;
            }

        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    //    /**
//     * Metodo che controlla username e password inseriti con quelli nei file.
//     *
//     * @param username nome utente
//     * @param pass password
//     * @return In caso di esito positivo restituisce un oggetto JUser con tutte
//     * le informazioni dell'utente, in caso contrario restituisce null.
//     * @throws IOException
//     */
    public static JUser creaUtenteLoggato(String username, String pass) throws IOException {
//        boolean ris = true;
//        JUser user;
//        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fUtenti), StandardCharsets.UTF_8);
//        for (String s : list) {
//            String[] elements = s.split(";");
//            ris = elements[3].equals(username) && elements[5].equals(pass);
//            if (ris == true) {
//                return user = new JUser(elements);
//            }
//        }
        return null;
    }

    //
//    /**
//     * Metodo che dato un {@code} id_area restituisce tutte le previsioni
//     * relative ad essa.
//     *
//     * @param id_area codice identificativo di un'area di interesse
//     * @return restituisce una lista di JPrevisioni
//     * @throws FileNotFoundException
//     * @throws IOException
//     */
    public static ArrayList<JPrevisioni> creaListaPrevisioni(Integer id_area) throws FileNotFoundException, IOException {
//        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
//        ArrayList<JPrevisioni> l = new ArrayList<>();
//        for (String s : list) {
//            String[] elements = s.split(";");
//            if (Integer.parseInt(elements[2]) == id_area) {
//                String data = elements[0];
//                l.add(new JPrevisioni(data, Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[3], Integer.parseInt(elements[4]), Integer.parseInt(elements[6]), Integer.parseInt(elements[8]), Integer.parseInt(elements[10]), Integer.parseInt(elements[12]), Integer.parseInt(elements[14]), Integer.parseInt(elements[16]), elements[5], elements[7], elements[9], elements[11], elements[13], elements[15], elements[17]));
//            }
//        }
//        return l;
        return null;
    }

    //
//    /**
//     * Metodo che fornita un'area d'interesse e una data, viene generata una
//     * lista delle preivisioni con relative infornazioni e poi viene restituita
//     * all'utente
//     *
//     * @param id_area codice identificativo di un'area di interesse
//     * @param strData indica la data del giorno di cui si vuole sapere le
//     * previsioni
//     * @return restituisce una lista di JPrevisioni
//     * @throws FileNotFoundException
//     * @throws IOException
//     */
    public static ArrayList<JPrevisioni> creaListaPrevisioniByDate(Integer id_area, String strData) throws FileNotFoundException, IOException {
//        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
//        ArrayList<JPrevisioni> l = new ArrayList<>();
//        for (String s : list) {
//            String[] elements = s.split(";");
//
//            if (Integer.parseInt(elements[2]) == id_area && strData.equals(elements[0])) {
//                String data = elements[0];
//                l.add(new JPrevisioni(data, Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[3], Integer.parseInt(elements[4]), Integer.parseInt(elements[6]), Integer.parseInt(elements[8]), Integer.parseInt(elements[10]), Integer.parseInt(elements[12]), Integer.parseInt(elements[14]), Integer.parseInt(elements[16]), elements[5], elements[7], elements[9], elements[11], elements[13], elements[15], elements[17]));
//            }
//        }
//        return l;
        return null;
    }

    //
//    /**
//     * Metodo che aggiunge un previsione al file 'previsioni.csv'
//     *
//     * @param previsione oggetto che indica una previsione metereologica
//     * @return restitusce l'id con cui viene salvata la previsione in caso
//     * l'operazione venga effettuata con successo, altrimenti restituisce -1
//     */
    public static Integer aggiungiPrevisione(JPrevisioni previsione) {
//        try {
//            Integer id = 1;
//            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
//            for (String s : list) {
//                id++;
//            }
//
//            FileWriter fileWriter = new FileWriter(new File(fPrevisioni), true);
//            String line = previsione.toCSV() + "\n";
//            fileWriter.append(line);
//            fileWriter.close();
//            return id;
//
//        } catch (IOException ex) {
//            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
//            return -1;
//        }
        return null;
    }

    //
//    /**
//     * Metodo che fornita una stringa restituisce una lista di JAreaInteresse
//     * che corrispondono interamente o parzialmente alla stringa passata come
//     * parametro.
//     *
//     * @param citta stringa da confrontare con i nomi delle aree
//     * @return in caso di coretto funzionamento restituisce una lista di
//     * JAreaInteresse, altrimenti restituisce null
//     */
    public static ArrayList<JAreaInteresse> cercaPerArea(String citta) {
//        try {
//            ArrayList<JAreaInteresse> aL = new ArrayList<>();
//            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
//            for (String s : list) {
//                String[] elements = s.split(";");
//                if (elements[1].toLowerCase().contains(citta.toLowerCase())) {
//                    aL.add(new JAreaInteresse(Integer.parseInt(elements[0]), Integer.parseInt(elements[2]), elements[1]));
//                }
//            }
//
//            return aL;
//        } catch (IOException ex) {
//            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
//        }
        return null;
    }

    /**
     * Metodo che cerca nel file fStazioni in base al nome passato come
     * parametro e alle coordinate passate come parametro con uno scarto di
     * massimo 20km.
     *
     * @param citta          stringa da confrontare con i nomi delle stazioni
     * @param coordinate     indica le coordinate geografiche in cui si vuole
     *                       trovare una stazione
     * @param scartoDistanza indica il raggio di ricerca a partire dalle
     *                       coordinate
     * @return ritorna una lista di JLuogo in caso vengano trovate
     * corrispondenze, in caso contrario restituisce null.
     */
    public static ArrayList<JStazione> cercaPerStazione(String citta, JCoordinate coordinate, Integer scartoDistanza) {
        try {
            ArrayList<JStazione> aL = new ArrayList<>();
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fStazioni), StandardCharsets.UTF_8);
//            for (String s : list) {
//                JStazione l = new JStazione(s);
//                if (citta != null) {
//                    if (l.getNome().toLowerCase().contains(citta.toLowerCase())) {
//                        aL.add(new JStazione(s));
//                    }
//                } else if (coordinate != null) {
//                    if (l.getCoordinate().distanzaDa(coordinate) < scartoDistanza) {
//                        aL.add(new JStazione(s));
//                    }
//                }
//            }
            return aL;
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
