/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classi;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author marco
 */
public class ParserCSV {

    public static ArrayList<JLuogo> creaLista() throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get("dati/utenti.csv"), StandardCharsets.UTF_8);
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

    public static boolean registraUtente(String nome, String cognome, String pass, String dataN, String paeseN, String secondoNome, String sesso) throws IOException {
        String username = nome.substring(0, 1) + "_" + cognome;
        Integer cont = 1;
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(Paths.get("dati/utenti.csv"), StandardCharsets.UTF_8);
        for (String s : list) {
            String[] elements = s.split(";");
            if (elements[3].contains(username)) {
                cont++;
            }
        }
        username += cont.toString();

        System.out.println(username);
        //salvo i dati sul file
        String mail = username + "@mail.com";
        

    }
}
