package database;
import gestore.GestoreLibri;

public interface DatabaseInterface {

    public void salvaFile(GestoreLibri gestoreLibri);

    public void caricaFile(String nomeFile);

}
