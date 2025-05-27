import gestore.GestoreLibri;
import gestore.GestoreLibriArray;
import gestore.GestoreLibriFactory;
import libro.Libro;
import libro.StatoLettura;
import libro.Valutazione;

public static void main(String[] args) {
    Libro prova = new Libro("il mondo di patty", "Michele", 123451, "blackhumor", Valutazione.CINQUE, StatoLettura.LETTO);
    System.out.println(prova.toString());

    Libro prova1 = new Libro("il mondo di aefafepatty", "Miefchele", 1221351, "blackhumor", Valutazione.CINQUE, StatoLettura.LETTO);
    System.out.println(prova1.toString());

    GestoreLibri gestore = GestoreLibriFactory.create("ArrayList");
    gestore.add(prova);
    gestore.add(prova1);

    GestoreLibri gestore1 = GestoreLibriFactory.create("ArrayList");

    System.out.println(gestore.getClass());
    System.out.println(gestore.toString());
    System.out.println(gestore1.getClass());
    System.out.println(gestore1.toString());

    GestoreLibriArray gestore2 = new GestoreLibriArray();
    GestoreLibri gestore3 = GestoreLibriFactory.create("ArrayList");

    gestore2.add(prova);
    gestore2.add(prova1);
    System.out.println(gestore2.toString());
    System.out.println(gestore2.getClass());
    gestore2.remove(prova);
    System.out.println(gestore2.toString());
    System.out.println(gestore2.getClass());
    gestore2.remove(prova1);
    System.out.println(gestore2.toString());
    System.out.println(gestore2.getClass());

}