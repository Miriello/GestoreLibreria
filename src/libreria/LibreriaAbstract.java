package libreria;

import database.*;
import gestore.*;
import libro.*;

import java.util.ArrayList;
import java.util.List;


public abstract class LibreriaAbstract {
    protected GestoreFile gestoreFile;
    protected GestoreLibri gestoreLibri;

    public LibreriaAbstract(GestoreFile gestoreFile, GestoreLibri gestoreLibri) {
        this.gestoreFile = gestoreFile;
        this.gestoreLibri = gestoreLibri;
    }

    public void add(Libro libro){
        gestoreLibri.add(libro);
    }
    public void remove(Libro libro){
        gestoreLibri.remove(libro);
    }
    public Libro getLibro(String titolo){
        return gestoreLibri.getLibro(titolo);
    }
    public Iterable<Libro> getLibri(){
        return gestoreLibri;
    }

    public int size(){
        return gestoreLibri.size();
    }
    public String toString(){
        return gestoreLibri.toString();
    }

    public GestoreLibri ordinaPerTitolo(){
        return gestoreLibri = gestoreLibri.ordinaPerTitolo();
    }
    public GestoreLibri ordinaPerAutore(){
        return gestoreLibri = gestoreLibri.ordinaPerAutore();
    }
    public GestoreLibri filtroAutore(String autore){return gestoreLibri = gestoreLibri.filtroAutore(autore);}
    public GestoreLibri filtroGenere(String genere){return gestoreLibri = gestoreLibri.filtroGenere(genere);}
    public GestoreLibri filtroStatoLettura(StatoLettura stato){return gestoreLibri = gestoreLibri.filtroStatoLettura(stato);}

    public void salvaFile(String percorso){
        try {
            gestoreFile.salvaFile(gestoreLibri, percorso);
        } catch (Exception e) {
            System.err.println("Errore durante il salvataggio: " + e.getMessage());
        }
    }
    public GestoreLibri caricaFile(String percorso){
        try {
            return this.gestoreLibri= gestoreFile.caricaFile(percorso);
        } catch (Exception e) {
            System.err.println("Errore durante il caricamento: " + e.getMessage());
            return null;
        }
    }
}
