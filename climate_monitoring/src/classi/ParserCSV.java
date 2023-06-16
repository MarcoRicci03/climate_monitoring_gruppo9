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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Classe per la gestione dei file
 *
 * @author marco_ricci
 * @author edoardo_rizzi
 * @author alberto_stagno
 * @author denis_di_napoli
 */
public class ParserCSV {

    private static final String fStazioni = "dati/stazioni.csv"; //file che presenta tutte le stazioni metereologiche create 
    private static final String fUtenti = "dati/utenti.csv";
    private static final String fAreeInteresse = "dati/areedinteresse.csv"; //file che presenta tutte le aree di interesse create 
    private static final String fNazioni = "dati/nazioni.csv";
    private static final String fOperatori = "dati/operatori.csv"; //file che presenta tutti gli operatori registrati
    private static final String fPrevisioni = "dati/previsioni.csv"; //file che presenta tutte le previsioni inserite 

    /**
     * Metodo che restituisce una lista contente tutte le stazioni presenti nel
     * file stazioni.csv
     *
     * @return lista con tutte le stazioni
     */
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

    /**
     * Metodo che dato un geoname id restituisce la stazione associata.
     *
     * @param id codice identificativo della stazione.
     * @return restituisce un JLuogo in caso di successo e null in caso di
     * fallimento.
     */
    public static JLuogo getStazione(int id) {
        ArrayList<JLuogo> listaStazioni = creaListaStazioni();
        for (JLuogo l : listaStazioni) {
            if (l.getGeoname_id() == id) {
                return l;
            }
        }
        return null;
    }

    /**
     * Metodo che crea una nuova stazione e la salva nel file
     *
     * @param geoname_id codice che indica
     * @param citta indica la citta in cui è presente la stazione
     * @param cod_nazione codice che riferito alla nazione di cui fa parte la
     * città
     * @param nazione indica la nazione di cui fa parte la città
     * @param coordinate indica le coordinate geografiche relative alla città
     * @return restituisce un valore booleano che concorda con l'esito del
     * metodo
     */
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

    /**
     * Metodo verifica che un utente sia già presente nel file 'utenti.csv'
     *
     * @param username indica il nome con cui si è registrato l'operatore
     * @param pass indica la password con la quale si è registrato l'utente
     * @return restituisce un valore booleano che concorda con l'esito del
     * metodo
     * @throws IOException
     */
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

    /**
     * Metodo che salva un nuovo utente nel file 'utenti.csv'
     *
     * @param username indica il nome con cui accedere nell'area riservata agli
     * operatori.
     * @param nome indica il nome dell'operatore.
     * @param cognome indica il cognome dell'operatore.
     * @param pass indica la parola con cui accedere nell'area riservata agli
     * operatori.
     * @param cf indica il codice fiscale dell'operatore.
     * @param id_stazione indica l'id della stazione in cui fa parte l'operatore
     * @param codiceOperatore idetifica l'operatore
     *
     * @return restituisce un valore booleano che concorda con l'esito del
     * metodo
     */
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

    /**
     * Metodo che restituisce la lista di tutte le nazioni presenti nel file
     * 'nazioni.csv'
     *
     * @return lista di vettori di stringhe
     * @throws IOException
     */
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

    /**
     * Metodo che verifica l'esistenza del codice operatore nel file
     * 'operatori.csv'
     *
     * @param codice_operatore identifica l'operatore
     * @return restituisce un valore booleano che concorda con l'esito del
     * metodo
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

    /**
     * Metodo che restituisce tutte le aree di interesse presenti nel file
     * specificato un {@code}geoname_id'areedinteresse.csv'
     *
     * @param geoname_id
     * @return lista di oggetti JAreeInteresse
     */
    public static ArrayList<JAreaInteresse> getAreeInteresse(int geoname_id) {
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

    /**
     * Metodo che restituisce tutte le aree di interesse presenti nel file
     * 'areedinteresse.csv'
     *
     * @return lista di oggetti JAreeInteresse
     */
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

    /**
     * Metodo che fornito un {@code} geoname_id restitusice la stazione
     * metereologica associata
     *
     * @param geoname_id
     * @return restituisce una stringa, se l'operazione va a buon fine
     * restituisce il nome della stazione altrimenti restituisce una stringa
     * vuota ("")
     */
    public static String getNomeStazioneByGeonameId(int geoname_id) {
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
            for (String temp : list) {
                String[] elements = temp.split(";");
                if (Integer.parseInt(elements[2]) == geoname_id) {
                    return elements[1];
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    public static String getNomeStazioneById(int id) {
        try {
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fAreeInteresse), StandardCharsets.UTF_8);
            for (String temp : list) {
                String[] elements = temp.split(";");
                if (Integer.parseInt(elements[0]) == id) {
                    return elements[1];
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    /**
     * Mettodo che dato un {@code} geoname_id ed un {@code} nome, aggiungendo
     * una nuova area di interesse nel file 'areedinteresse.csv'
     *
     * @param geoname_id
     * @param nome
     * @return restituisce un valore intero, se l'operazione va a buon fine
     * restituisce l'id della nuova area oppure restituisce '-1' se l'operazione
     * non va a buon fine
     */
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
    /**
     * Metodo che genera un utente e lo inserisce nel file 'utenti.csv'
     * restituendo poi l'oggetto JUser
     *
     * @param username
     * @param pass
     * @return restituisce un oggetto JUser con tutte le info
     * @throws IOException
     */
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

    /**
     * Metodo che dato un {@code} id_area restituisce tutte le previsioni
     * relative all'area inserita tramite parametro
     *
     * @param id_area codice identificativo di un'area di interesse
     * @return restituisce una lista di JPrevisioni
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<JPrevisioni> creaListaPrevisioni(Integer id_area) throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
        ArrayList<JPrevisioni> l = new ArrayList<>();
        for (String s : list) {
            String[] elements = s.split(";");
            if (Integer.parseInt(elements[2]) == id_area) {
                String data = elements[0];
                l.add(new JPrevisioni(data, Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[3], Integer.parseInt(elements[4]), Integer.parseInt(elements[6]), Integer.parseInt(elements[8]), Integer.parseInt(elements[10]), Integer.parseInt(elements[12]), Integer.parseInt(elements[14]), Integer.parseInt(elements[16]), elements[5], elements[7], elements[9], elements[11], elements[13], elements[15], elements[17]));
            }
        }
        return l;
    }

    public static ArrayList<String[]> creaListaPrevisioniToSelect(int id_area) throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
        ArrayList<String[]> l = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Boolean sent;
        for (String s : list) {
            String[] elements = s.split(";");
            String[] vc = {elements[0], elements[1]};
            sent = false;

            if (Integer.parseInt(elements[2]) == id_area) {
                String data = elements[0];

                if (!sent) {
                    l.add(vc);
                }

            }
        }
        return l;
    }

    /**
     *
     * @param id_area codice identificativo di un'area di interesse
     * @return
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<JPrevisioni> creaListaPrevisioniUniqueDate(int id_area) throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
        ArrayList<JPrevisioni> l = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Boolean sent;
        for (String s : list) {
            String[] elements = s.split(";");
            sent = false;

            if (Integer.parseInt(elements[2]) == id_area) {
                String data = elements[0];

                for (JPrevisioni temp : l) {
                    if (data.equals(sdf.format(temp.getData()))) {
                        sent = true;
                    }
                }

                if (!sent) {
                    l.add(new JPrevisioni(data, Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[3], Integer.parseInt(elements[4]), Integer.parseInt(elements[5]), Integer.parseInt(elements[6]), Integer.parseInt(elements[7]), Integer.parseInt(elements[8]), Integer.parseInt(elements[9]), Integer.parseInt(elements[10]), elements[11], elements[12], elements[13], elements[14], elements[15], elements[15], elements[16]));
                }

            }
        }
        return l;
    }

    /**
     * Metodo che fornita un'area d'interesse e una data, viene generata una
     * lista delle preivisioni con relative infornazioni e poi viene restituita
     * all'utente
     *
     * @param id_area codice identificativo di un'area di interesse
     * @param strData indica la data del giorno di cui si vuole sapere le
     * previsioni
     * @return restituisce una lista di JPrevisioni
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ArrayList<JPrevisioni> creaListaPrevisioniByDate(Integer id_area, String strData) throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get(fPrevisioni), StandardCharsets.UTF_8);
        ArrayList<JPrevisioni> l = new ArrayList<>();
        for (String s : list) {
            String[] elements = s.split(";");

            if (Integer.parseInt(elements[2]) == id_area && strData.equals(elements[0])) {
                String data = elements[0];
                l.add(new JPrevisioni(data, Integer.parseInt(elements[1]), Integer.parseInt(elements[2]), elements[3],Integer.parseInt(elements[4]), Integer.parseInt(elements[5]), Integer.parseInt(elements[6]), Integer.parseInt(elements[7]), Integer.parseInt(elements[8]), Integer.parseInt(elements[9]), Integer.parseInt(elements[10]), elements[11], elements[12], elements[13], elements[14], elements[15], elements[15], elements[16]));
            }
        }
        return l;
    }

    /**
     * Metodo che aggiunge un previsione al file 'previsioni.csv'
     *
     * @param previsione oggetto che indica una previsione metereologica
     * @return restitusce l'id con cui viene salvata la previsione in caso
     * l'operazione venga effettuata con successo, altrimenti restituisce -1
     */
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

    /**
     * Metodo che fornita un'area d'interesse restituscie una lista di JLuogo
     * che corrispondono ai parametri passati.
     *
     * @param citta indica l'area di interesse
     * @return in caso di coretto funzionamento restituisce una lista di
     * JAreaInteresse, altrimenti restituisce null
     */
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

    /**
     * Metodo che fornita un'area d'interesse restituscie una lista di JLuogo
     * che corrispondono ai parametri passati.
     *
     * @param citta indica l'area di interesse
     * @param coordinate indica le coordinate geografiche in cui si vuole
     * trovare una stazione
     * @param scartoDistanza indica il raggio di ricerca a partire dalle
     * coordinate
     * @return
     */
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
