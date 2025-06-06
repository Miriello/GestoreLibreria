package database;
import gestore.GestoreLibri;
import libro.*;

import java.io.PrintWriter;

public class GestoreFileCSV implements GestoreFile{

    @Override
    public void salvaFile(GestoreLibri gestoreLibri, String percorso) {

        for (Libro l : gestoreLibri) {
        }
    }

    @Override
    public GestoreLibri caricaFile(String nomeFile) {
        return null;
    }
}

