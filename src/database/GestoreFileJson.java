package database;
import gestore.GestoreLibri;

import java.io.IOException;

public class GestoreFileJson implements GestoreFile{

    @Override
    public void salvaFile(GestoreLibri gestoreLibri, String percorso) {

    }

    @Override
    public GestoreLibri caricaFile(String nomeFile) throws IOException {
    return null;
    }
}
