package libro;

import java.io.Serializable;

public class Libro implements Serializable {
    private String titolo;
    private String autore;
    private int codiceISBN;
    private String genere;
    private Valutazione valutazionePersonale;
    private StatoLettura statoLettura;

    //COSTRUTTORE LIBRO NON LETTO
    public Libro(String titolo, String autore, int codiceISBN, String genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.codiceISBN = codiceISBN;
        this.genere = genere;
        this.valutazionePersonale = null;
        this.statoLettura = StatoLettura.DALEGGERE;
    }

    //COSTRUTTORE LIBRO GIA'LETTO
    public Libro(String titolo, String autore, int codiceISBN, String genere, Valutazione valutazionePersonale, StatoLettura statoLettura) {
        this.titolo = titolo;
        this.autore = autore;
        this.codiceISBN = codiceISBN;
        this.genere = genere;
        this.valutazionePersonale = valutazionePersonale;
        this.statoLettura = statoLettura;
        if (this.statoLettura== StatoLettura.DALEGGERE & this.valutazionePersonale!=null) {
            throw new IllegalArgumentException("Mai giudicare un libro dalla copertina");
        }
    }

   //COSTRUTTORE PER COPIA
    public Libro(Libro lib) {
        this.titolo = lib.titolo;
        this.autore = lib.autore;
        this.codiceISBN = lib.codiceISBN;
        this.genere = lib.genere;
        this.valutazionePersonale = lib.valutazionePersonale;
        this.statoLettura = lib.statoLettura;
    }
    //GET TITOLO
    public String getTitolo() {
        return titolo;
    }
    //SET TITOLO
    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }
    //GET AUTORE
    public String getAutore() {
        return autore;
    }
    //SET AUTORE
    public void setAutore(String autore) {
        this.autore = autore;
    }
    //GET CODICE ISBN
    public int getCodiceISBN() {
        return codiceISBN;
    }
    //SET CODICE ISBN
    public void setCodiceISBN(int codiceISBN) {
        this.codiceISBN = codiceISBN;
    }
    //GET GENERE
    public String getGenere() {
        return genere;
    }
    //SET GENERE
    public void setGenere(String genere) {
        this.genere = genere;
    }
    //GET VALUTAZIONE
    public Valutazione getValutazionePersonale() {
        return valutazionePersonale;
    }
    //SET VALUTAZIONE PERSONALE
    public void setValutazionePersonale(Valutazione valutazionePersonale) {
        this.valutazionePersonale = valutazionePersonale;
    }
    //GET STATO LETTURA
    public StatoLettura getStatoLettura() {
        return statoLettura;
   }
    // SET STATO LETTURA
    public void setStatoLettura(StatoLettura statoLettura) {
        this.statoLettura = statoLettura;
    }
    //ToString
    public String toString() {
        return titolo + " - " + autore + " - " + codiceISBN + " - " + genere + " - " + valutazionePersonale + " - " + statoLettura;
    }
}
