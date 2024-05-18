package classi;

import java.util.ArrayList;

public class DatiCondivisi {
    private static DatiCondivisi instance = null;

    public ArrayList<JAreaInteresse> aree_interesse;

    public static DatiCondivisi getInstance() {
        if (instance == null) {
            instance = new DatiCondivisi();
        }
        return instance;
    }



}
