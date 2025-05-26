package gestore;
import libro.*;

import java.util.ArrayList;
import java.util.Iterator;

public class GestoreLibriArray implements GestoreLibri {
    private ArrayList<Libro> listaLibri = new ArrayList<>();
    int size;

    @Override
    public void add(Libro lib) {
        listaLibri.add(lib);
        size++;
    }

    @Override
    public void remove(Libro lib) {
        listaLibri.remove(lib);
        size--;
    }

    @Override
    public Libro getLibro(String titolo) {
        for(Libro lib : listaLibri){
            if(lib.getTitolo().equals(titolo)){
                return lib;
            }
        }
        return null;
    }


    @Override
    public int size() {
        return size;
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
        return new LibriArrayIterator();
    }
    private class LibriArrayIterator implements Iterator<Libro>{
        int indice = 0;

        @Override
        public boolean hasNext() {
            return indice<size;
        }
        @Override
        public Libro next() {
            return null;
        }
    }
}
