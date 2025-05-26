package gestore;

import libro.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class GestoreLibriLinkedList implements GestoreLibri<Libro> {
    private LinkedList<Libro> listaLibri = new LinkedList<>();

    @Override
    public void add(Libro lib) {
        listaLibri.add(lib);
    }

    @Override
    public void remove(Libro lib) {
        listaLibri.remove(lib);
    }

    @Override
    public Libro getLibro(String titolo) {
        return listaLibri.stream().filter(l -> l.getTitolo().equals(titolo)).findFirst().orElse(null);
    }

    @Override
    public int size() {
        return listaLibri.size();
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
        return null; /* new GestoreLibriLinkedList(new LinkedList<>(listaLibri.stream().filter(libro -> libro.getGenere().equals(genere)).collect(Collectors.toList())));
        */
    }

    @Override
    public GestoreLibri filtroStatoLettura(StatoLettura stato) {
        return null; /* new GestoreLibriLinkedList(new LinkedList<>(listaLibri.stream().filter(libro -> libro.getStatoLettura().equals(stato)).collect(Collectors.toList())));
    */
    }

    @Override
    public Iterator<Libro> iterator() {
        return new LibriLinkedListIterator();
    }
    private class LibriLinkedListIterator implements Iterator<Libro>{
        private final Iterator<Libro> iterator = listaLibri.iterator();
        @Override
        public boolean hasNext() {
            return iterator.hasNext();
        }
        @Override
        public Libro next() {
            return iterator.next();
        }
    }
}
