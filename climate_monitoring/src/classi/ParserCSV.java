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
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marco
 */
public class ParserCSV {

    public static ArrayList<JLuogo> creaLista() throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get("dati/luoghi.csv"), StandardCharsets.UTF_8);
        ArrayList<JLuogo> l = new ArrayList<>();
        for (String s : list) {
            String[] elements = s.split(";");
            if (s.contains("China")) {
                int t = 0;
            }
            l.add(new JLuogo(Integer.valueOf(elements[0]), elements[2], elements[3], new JCoordinate(Float.valueOf(elements[5].split(",")[0]), Float.valueOf(elements[5].split(",")[1]))));
        }
        return l;
    }

    public static boolean esisteUtente(String username, String pass) throws IOException {
        boolean ris = true;
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get("dati/utenti.csv"), StandardCharsets.UTF_8);
        for (String s : list) {
            String[] elements = s.split(";");
            return elements[3].equals(username) && elements[5].equals(pass);
        }
        return false;
    }

    public static boolean registraUtente(String nome, String cognome, String pass, String cf, Integer id_stazione) {
        try {
            String username = nome.substring(0, 1) + "_" + cognome;
            Integer id = 0;
            Integer cont = 1;
            ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get("dati/utenti.csv"), StandardCharsets.UTF_8);
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
            FileWriter fileWriter = new FileWriter(new File("dati/utenti.csv"));
            String line = id + ";" + nome + ";" + cognome + ";" + username + ";" + mail + ";" + pass + ";" + cf + ";" + id_stazione + "\n";
            fileWriter.append(line.toString());
            fileWriter.close();
            return true;
        } catch (IOException ex) {
            Logger.getLogger(ParserCSV.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
