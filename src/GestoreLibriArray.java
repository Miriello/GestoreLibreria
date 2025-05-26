import java.util.Iterator;

public class GestoreLibriArray extends GestoreLibriAstratto{
    private Libro[] lib;
    private int size ;

    public GestoreLibriArray() {
        this.lib = new Libro[10];
    }

    public void add(Libro libro) {

    }

    @Override
    public void remove(String titolo ) ;
    }

    @Override
    public Libro get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Libro> iterator() {
        return new ArrayLibriIterator();
    }

    public class ArrayLibriIterator implements Iterator<Libro>{
        int indice = 0;

        public boolean hasnext(){
            return indice < size();
        }

        @Override
        public boolean hasNext() {
            return false;
        }

        public Libro next(){
            if (indice==size);
        }

        public void remove(){

        }

}

public void main() {
}
