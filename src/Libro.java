public class Libro {
    private String titolo;
    private String autore;
    private int codiceISBN;
    private String genere;
    private Valutazione valutazionePersonale;
    private StatoLettura statoLettura;

    //COSTRUTTORE
    public Libro(String titolo, String autore, int codiceISBN, String genere) {
        this.titolo = titolo;
        this.autore = autore;
        this.codiceISBN = codiceISBN;
        this.genere = genere;
        this.valutazionePersonale = null;
        this.statoLettura = StatoLettura.DALEGGERE;
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

}
