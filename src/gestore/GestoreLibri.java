package gestore;
import libro.*;

public interface GestoreLibri extends Iterable<Libro>{
    public void add(Libro lib);

    public void remove(Libro lib);

    public Libro getLibro(String titolo);

    public int size();

    public GestoreLibri ordinaPerTitolo(GestoreLibri listaLibri);

    public GestoreLibri ordinaPerAutore(GestoreLibri listaLibri);

    public GestoreLibri filtroAutore(String autore);

    public GestoreLibri filtroGenere(String genere);

    public GestoreLibri filtroStatoLettura(StatoLettura stato);

    public String toString();
}




