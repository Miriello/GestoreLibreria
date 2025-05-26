package database;
import gestore.GestoreLibri;
import libro.*;

import java.io.PrintWriter;

public class DatabaseCSV implements DatabaseInterface {
    private final PrintWriter pw;

    public DatabaseCSV(PrintWriter pw) {
        this.pw = pw;
    }

    @Override
    public void salvaFile(GestoreLibri gestoreLibri) {
        for(Libro l : gestoreLibri){

        }

    }

    @Override
    public void caricaFile(String nomeFile) {

    }
}
