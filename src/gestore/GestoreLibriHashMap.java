package gestore;
import libro.*;
import java.util.Iterator;

public class GestoreLibriHashMap implements GestoreLibri {

    @Override
    public void add(Libro lib) {

    }

    @Override
    public void remove(Libro lib) {

    }

    @Override
    public Libro getLibro(String titolo) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public GestoreLibri ordinaPerTitolo(GestoreLibri listaLibri) {
        return null;
    }

    @Override
    public GestoreLibri ordinaPerAutore(GestoreLibri listaLibri) {
        return null;
    }

    @Override
    public GestoreLibri filtroGenere(String genere) {
        return null;
    }

    @Override
    public GestoreLibri filtroStatoLettura(StatoLettura stato) {
        return null;
    }
    public GestoreLibri filtroAutore(String autore){
        return null;
    }


    @Override
    public String toString() {
        return null;
    }

    @Override
    public Iterator<Libro> iterator() {
        return null;
    }

}
