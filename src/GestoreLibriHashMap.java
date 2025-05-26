import java.util.Iterator;

public class GestoreLibriHashMap implements GestoreLibri<Libro>{

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
    public GestoreLibri ordinaPerTitolo() {
        return null;
    }

    @Override
    public GestoreLibri ordinaPerAutore() {
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

    @Override
    public Iterator<Libro> iterator() {
        return null;
    }
}
