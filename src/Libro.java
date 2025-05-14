public class Libro {
    private final String titolo;
    private final String autore;
    private final int codiceISBN;
    private final String genere;
    private Stelle valutazionePersonale;
    private boolean statoLettura = false;

    public static class Builder {
        private String titolo;
        private String autore;
        private int codiceISBN;
        private String genere;
        private Stelle valutazionePersonale = null;
        private boolean statoLettura = false;

        public Builder(String titolo, String autore) {
            this.titolo = titolo;
            this.autore = autore;
        }
        public Libro build() {
            return new Libro(this);
        }
    }
    private Libro(Builder builder) {
        titolo = Builder.titolo;
        autore = Builder.autore;
        codiceISBN = Builder.codiceISBN;
        genere = Builder.genere;
    }
    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    public int getCodiceISBN() {
        return codiceISBN;
    }
    public String getGenere() {
        return genere;
    }
    public void setValutazionePersonale(Stelle valutazionePersonale) {
        this.valutazionePersonale = valutazionePersonale;
    }
    public Stelle getValutazionePersonale() {
        return valutazionePersonale;
    }
    public boolean isStatoLettura() {
        return statoLettura;
    }
    public void setStatoLettura(boolean statoLettura) {
        this.statoLettura = statoLettura;
    }

}
