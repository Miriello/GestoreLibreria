package gestore;
import libro.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class GestoreLibriArray implements GestoreLibri {
    private ArrayList<Libro> listaLibri = new ArrayList<>();

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
        for(Libro lib : listaLibri){
            if(lib.getTitolo().equals(titolo)){
                return lib;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return listaLibri.size();
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        if(listaLibri.isEmpty())
            return "La libreria è vuota";
        for (Libro lib : listaLibri){
            sb.append(lib.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    //Implementazione che utilizza una struttura ArrayList per poter fare il sort per TITOLO
    @Override
    public GestoreLibri ordinaPerTitolo() {
        ArrayList<Libro> tmp = new ArrayList<>();
        GestoreLibri listaLibriOrdinata = GestoreLibriFactory.create("ArrayList");

        for (Libro lib : this){
            tmp.add(lib);
        }
        tmp.sort(Comparator.comparing(Libro::getTitolo));

        for(Libro lib : tmp){
            listaLibriOrdinata.add(lib);
        }
        return listaLibriOrdinata;
    }
    //Implementazione che utilizza una struttura ArrayList per poter fare il sort per AUTORE
    @Override
    public GestoreLibri ordinaPerAutore() {
        ArrayList<Libro> tmp = new ArrayList<>();
        GestoreLibri listaLibriOrdinata = GestoreLibriFactory.create("ArrayList");

        for (Libro lib : this){
            tmp.add(lib);
        }
        tmp.sort(Comparator.comparing(Libro::getAutore));

        for(Libro lib : tmp){
            listaLibriOrdinata.add(lib);
        }
        return listaLibriOrdinata;
    }
    // FiltroGenere implementato con il forEach
    @Override
    public GestoreLibri filtroGenere(String genere) {
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        for(Libro lib : listaLibri){
            if(lib.getGenere().equals(genere))
                gestoreLibri.add(lib);
        }
        return gestoreLibri;
    }
    //FiltroStatoLettura implementato con il forEach
    @Override
    public GestoreLibri filtroStatoLettura(StatoLettura stato) {
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        for(Libro lib : listaLibri){
            if(lib.getStatoLettura().equals(stato))
                gestoreLibri.add(lib);
        }
        return gestoreLibri;
    }
    //FiltroAutore implementato con il forEach
    public GestoreLibri filtroAutore(String autore){
        if(autore == null)
            return GestoreLibriFactory.create("ArrayList");
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        for(Libro lib : listaLibri){
            if(lib.getAutore().equalsIgnoreCase(autore))
                gestoreLibri.add(lib);
        }
        return gestoreLibri;
    }


    @Override
    public Iterator<Libro> iterator() {
        return new LibriArrayIterator();
    }
    private class LibriArrayIterator implements Iterator<Libro>{
        int indice = 0;

        @Override
        public boolean hasNext() {
            return indice< listaLibri.size();
        }
        @Override
        public Libro next() {
            return listaLibri.get(indice++);
        }
    }
}
