public static void main(String[] args) {
    Libro prova = new Libro("il mondo di patty", "Michele", 123451, "blackhumor", Valutazione.CINQUE, StatoLettura.LETTO);
    System.out.println(prova.toString());

    Libro prova1 = new Libro("il mondo di aefafepatty", "Miefchele", 1221351, "blackhumor", Valutazione.CINQUE, StatoLettura.LETTO);
    System.out.println(prova1.toString());

    GestoreLibriLinkedList Prova = new GestoreLibriLinkedList();
    Prova.add(prova);Prova.add(prova1);
    System.out.println(Prova.toString());

}