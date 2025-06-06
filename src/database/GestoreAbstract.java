package database;

import gestore.GestoreLibri;

import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class GestoreAbstract implements GestoreLibri{
    protected GestoreFile gestoreFile;

    public void salvaFile(GestoreLibri gestoreLibri, String percorso) throws IOException {
        gestoreFile.salvaFile(gestoreLibri, percorso);
    }

    public GestoreLibri caricaFile(String nomeFile) throws IOException, ClassNotFoundException {
        return gestoreFile.caricaFile(nomeFile);
    }
}
