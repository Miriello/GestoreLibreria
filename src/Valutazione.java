public enum Valutazione {
    UNO(1),DUE(2),TRE(3),QUATTRO(4),CINQUE(5);
    private int valutazionePersonale;
    private Valutazione(int valutazionePersonale) {
        this.valutazionePersonale = valutazionePersonale;
    }
    public int getValutazionePersonale() {
        return valutazionePersonale;
    }
}
