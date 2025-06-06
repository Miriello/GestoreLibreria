package test;

import database.*;
import gestore.*;
import libro.*;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");

        gestoreLibri.add(new Libro("Il giovane Holden", "J.D. Salinger", 123456, "Narrativa", Valutazione.CINQUE, StatoLettura.LETTO));
        gestoreLibri.add(new Libro("1984", "George Orwell", 789012, "Distopico", Valutazione.QUATTRO, StatoLettura.INLETTURA));
        gestoreLibri.add(new Libro("Il Signore degli Anelli", "J.R.R. Tolkien", 345678, "Fantasy", Valutazione.CINQUE, StatoLettura.LETTO));

        System.out.println("Libreria attuale:");
        System.out.println(gestoreLibri);

        GestoreFile gestoreFile = new GestoreFileDat();

        String percorso = "Libreria.dat";
        try {
            gestoreFile.salvaFile(gestoreLibri, percorso);
            System.out.println("Libreria salvata con successo!");
        } catch (IOException e) {
            System.err.println("Errore durante il salvataggio: " + e.getMessage());
        }



    }
}

