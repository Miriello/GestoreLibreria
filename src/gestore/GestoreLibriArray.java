package gestore;
import libro.*;

import java.util.ArrayList;
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
        GestoreLibri gestoreLibri = new GestoreLibriArray();
        for(Libro lib : listaLibri){
            if(lib.getGenere().equals(genere))
                gestoreLibri.add(lib);
        }
        return gestoreLibri;
    }

    @Override
    public GestoreLibri filtroStatoLettura(StatoLettura stato) {
        GestoreLibri gestoreLibri = new GestoreLibriArray();
        for(Libro lib : listaLibri){
            if(lib.getStatoLettura().equals(stato))
                gestoreLibri.add(lib);
        }
        return gestoreLibri;
    }

    public GestoreLibri filtroAutore(String autore){
        GestoreLibri gestoreLibri = new GestoreLibriArray();
        for(Libro lib : listaLibri){
            if(lib.getAutore().equals(autore))
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
