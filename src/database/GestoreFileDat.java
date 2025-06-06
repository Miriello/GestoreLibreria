package database;

import gestore.*;
import libro.*;
import java.io.*;
import java.util.StringTokenizer;

public class GestoreFileDat implements GestoreFile {

    @Override
    public void salvaFile(GestoreLibri gestoreLibri, String percorso) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(percorso))) {
            for (Libro libro : gestoreLibri) {
                pw.println(libro.getTitolo() + " - "
                        + libro.getAutore() + " - "
                        + libro.getGenere() + " - "
                        + libro.getCodiceISBN() + " - "
                        + libro.getValutazionePersonale() + " - "
                        + libro.getStatoLettura());
            }
        }
    }

    @Override
    public GestoreLibri caricaFile (String percorso) throws IOException {
        GestoreLibri gestoreLibri = GestoreLibriFactory.create("ArrayList");
        try (BufferedReader reader = new BufferedReader(new FileReader(percorso))) {
            String riga;
            while ((riga = reader.readLine()) != null) {
                StringTokenizer tokenizer = new StringTokenizer(riga, "-");
                String titolo = tokenizer.nextToken().trim();
                String autore = tokenizer.nextToken().trim();
                int codiceISBN = Integer.parseInt(tokenizer.nextToken().trim());
                String genere = tokenizer.nextToken().trim();
                Valutazione valutazione = Valutazione.valueOf(tokenizer.nextToken().trim());
                StatoLettura stato = StatoLettura.valueOf(tokenizer.nextToken().trim());

                Libro libro = new Libro(titolo, autore, codiceISBN, genere, valutazione, stato);
                gestoreLibri.add(libro);
            }
        }
        return gestoreLibri;
    }
}