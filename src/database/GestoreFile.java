package database;
import gestore.GestoreLibri;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface GestoreFile {

    public void salvaFile(GestoreLibri gestoreLibri, String percorso) throws IOException;

    public GestoreLibri caricaFile(String nomeFile) throws IOException;

}
