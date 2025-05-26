import gestore.GestoreLibri;
import gestore.GestoreLibriFactory;

public static void main(String[] args) {
    Libro prova = new Libro("il mondo di patty", "Michele", 123451, "blackhumor", Valutazione.CINQUE, StatoLettura.LETTO);
    System.out.println(prova.toString());

    Libro prova1 = new Libro("il mondo di aefafepatty", "Miefchele", 1221351, "blackhumor", Valutazione.CINQUE, StatoLettura.LETTO);
    System.out.println(prova1.toString());

    GestoreLibri gestore = GestoreLibriFactory.create("HashMap");
    gestore.add(prova);
    gestore.add(prova1);

}