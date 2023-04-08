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

    public static ArrayList<JLuogo> creaLista(Path nomeFile) throws FileNotFoundException, IOException {
        ArrayList<String> list = (ArrayList<String>) Files.readAllLines(nomeFile, StandardCharsets.UTF_8);
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
}
