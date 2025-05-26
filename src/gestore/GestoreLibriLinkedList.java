package gestore;

import libro.*;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class GestoreLibriLinkedList implements GestoreLibri {
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
        if(listaLibri.isEmpty()){
            throw new NoSuchElementException("La libreria è vuota");
        }
        Iterator<Libro> it = listaLibri.iterator();
        while(it.hasNext()){
            Libro lib = it.next();
            if(lib.getTitolo().equals(titolo))
                return lib;
        }
        return null;
    }

    @Override
    public int size() {
        return listaLibri.size();
    }

    public String toString(){
        Iterator<Libro> it = listaLibri.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext())
            sb.append(it.next().toString());
        return sb.toString();
    }

    @Override
    public GestoreLibri ordinaPerTitolo(GestoreLibri listaLibri) {
        return null;
    }

    @Override
    public GestoreLibri ordinaPerAutore(GestoreLibri listaLibri) {
        return null;
    }

    public GestoreLibri filtroAutore(String autore){
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
