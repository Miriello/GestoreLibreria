package gestore;
import libro.*;

import java.util.*;

public class GestoreLibriHashMap implements GestoreLibri {
    private HashMap<Integer, Libro> listaLibri = new HashMap<>();

    @Override
    public void add(Libro lib) {
        listaLibri.put(lib.getCodiceISBN(), lib);
    }

    @Override
    public void remove(Libro lib) {
        listaLibri.remove(lib.getCodiceISBN());
    }

    @Override
    public Libro getLibro(String titolo) {
       for(Libro lib: listaLibri.values()){
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
    //Implementazione che utilizza una struttura ArrayList per poter fare il sort per TITOLO
    @Override
    public GestoreLibri ordinaPerTitolo() {
        ArrayList <Libro> listaPerTitolo = new ArrayList<>();
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        for(Libro lib: listaLibri.values()){
            listaPerTitolo.add(lib);
        }
        listaPerTitolo.sort(Comparator.comparing(Libro::getTitolo));
        for(Libro lib : listaPerTitolo){
            gestoreLibri.add(lib);
        }
        return gestoreLibri;
    }
    //Implementazione che utilizza una struttura ArrayList per poter fare il sort per AUTORE
    @Override
    public GestoreLibri ordinaPerAutore() {
        ArrayList <Libro> listaPerAutore = new ArrayList<>();
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        for(Libro lib: listaLibri.values()){
            listaPerAutore.add(lib);
        }
        listaPerAutore.sort(Comparator.comparing(Libro::getAutore));
        for(Libro lib : listaPerAutore){
            gestoreLibri.add(lib);
        }
        return gestoreLibri;
    }
    // FiltroGenere implementato con il forEach
    @Override
    public GestoreLibri filtroGenere(String genere) {
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        if (genere==null){
            return gestoreLibri;
        }
        for (Libro lib : listaLibri.values()) {
            if (lib.getGenere().equals(genere)) {
                gestoreLibri.add(lib);
            }
        }
        return gestoreLibri;
    }
    // FiltroStatoLettura implementato con il forEach
    @Override
    public GestoreLibri filtroStatoLettura(StatoLettura stato) {
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        for (Libro lib : listaLibri.values()) {
            if (lib.getStatoLettura().equals(stato)) {
                gestoreLibri.add(lib);
            }
        }
        return gestoreLibri;
    }
    // FiltroAutore implementato con il forEach
    public GestoreLibri filtroAutore(String autore){
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        if (autore==null){
            return gestoreLibri;
        }
        for (Libro lib : listaLibri.values()) {
            if (lib.getAutore().equals(autore)) {
                gestoreLibri.add(lib);
            }
        }
        return gestoreLibri;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if(listaLibri.isEmpty())
            return "La libreria è vuota";
        for (Libro lib : listaLibri.values()){
            sb.append(lib.toString());
            sb.append("\n");
        }
        return sb.toString();
    }
    @Override
    public Iterator<Libro> iterator() {
        return new GestoreLibriHashMap.HashMapIterator();
    }

    private class HashMapIterator implements Iterator<Libro>{
        private final Iterator<Libro> iterator = listaLibri.values().iterator();
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
