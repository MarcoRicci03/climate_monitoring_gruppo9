package classi;

import java.util.ArrayList;

public class DatiCondivisi {
    private static DatiCondivisi instance = null;

    public ArrayList<JAreaInteresse> aree_interesse;
    public ArrayList<JStazione> stazioni;

    public DBInterface gestore_db;

    private DatiCondivisi() {
        aree_interesse = new ArrayList<>();
        stazioni = new ArrayList<>();
    }

    public static DatiCondivisi getInstance() {
        if (instance == null) {
            instance = new DatiCondivisi();
        }
        return instance;
    }



}
