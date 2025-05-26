public abstract class GestoreLibriFactory implements GestoreLibri {
    public static GestoreLibri create (String tipo){
        return switch(tipo){
            case "LinkedList" -> new GestoreLibriLinkedList();
            case "ArrayList" -> new GestoreLibriArray();
            case "HashMap" -> new GestoreLibriHashMap();
            default -> throw new IllegalArgumentException("Il tipo inserito non è ancora supportato");
        };
    }
}
