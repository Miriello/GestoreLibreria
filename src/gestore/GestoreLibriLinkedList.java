package gestore;

import libro.*;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.stream.Stream;

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

    //Implementazione che sfrutta gli stream per ordinare per TITOLO ed aggiungere ad un nuovo gestoreLibriLL
    @Override
    public GestoreLibri ordinaPerTitolo() {
        GestoreLibri temp = GestoreLibriFactory.create("LinkedList");
        listaLibri.stream().sorted(Comparator.comparing(Libro::getTitolo)).forEach(temp::add);
        return temp;
    }
    //Implementazione che sfrutta gli stream per ordinare per AUTORE ed aggiungere ad un nuovo gestoreLibriLL
    @Override
    public GestoreLibri ordinaPerAutore() {
        GestoreLibri temp = GestoreLibriFactory.create("LinkedList");
        listaLibri.stream().sorted(Comparator.comparing(Libro::getAutore)).forEach(temp::add);
        return temp;
    }
    //FiltroAutore basato su stream
    public GestoreLibri filtroAutore(String autore){
        GestoreLibri temp = GestoreLibriFactory.create("LinkedList");
        listaLibri.stream().filter(lib -> lib.getAutore().equals(autore)).forEach(temp::add);
        return temp;
    }
    //FiltroGenere basato su stream
    @Override
    public GestoreLibri filtroGenere(String genere) {
        GestoreLibri temp = GestoreLibriFactory.create("LinkedList");
        listaLibri.stream().filter(lib -> lib.getGenere().equals(genere)).forEach(temp::add);
        return temp;
    }
    //FiltroStatoLettura basato su stream
    @Override
    public GestoreLibri filtroStatoLettura(StatoLettura stato) {
        GestoreLibri temp = GestoreLibriFactory.create("LinkedList");
        listaLibri.stream().filter(lib -> lib.getStatoLettura().equals(stato)).forEach(temp::add);
        return temp;
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
