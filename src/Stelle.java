public enum Stelle {
    UNA(1),DUE(2),TRE(3),QUATTRO(4),CINQUE(5);
    private final int valutazionePersonale;
    private Stelle(int valutazionePersonale) {
        this.valutazionePersonale = valutazionePersonale;
    }
    public int getValutazionePersonale() {
        return valutazionePersonale;
    }
}
