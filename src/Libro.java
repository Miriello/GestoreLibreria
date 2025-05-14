public class Libro {
    private final String titolo;
    private final String autore;
    private final int codiceISBN;
    private final String genere;
    private Valutazione valutazionePersonale;
    private boolean statoLettura = false;

    public static class Builder {
        private static String titolo;
        private static String autore;
        private static int codiceISBN;
        private static String genere;
        private Valutazione valutazionePersonale = null;
        private boolean statoLettura = false;

        public Builder(String titolo, String autore,int codiceISBN, String genere) {
            this.titolo = titolo;
            this.autore = autore;
            this.codiceISBN = codiceISBN;
            this.genere = genere;
        }
        public Builder statoLettura(boolean statoLettura) {
            this.statoLettura = statoLettura;
            return this;
        }
        public Builder valutazionePersonale(Valutazione valutazionePersonale) {
            this.valutazionePersonale = valutazionePersonale;
            return this;
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
        valutazionePersonale = builder.valutazionePersonale;
        statoLettura = builder.statoLettura;
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
    public Valutazione getValutazionePersonale() {
        return valutazionePersonale;
    }
    public boolean isStatoLettura() {
        return statoLettura;
    }

}
