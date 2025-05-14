import java.util.HashMap;
import java.util.Iterator;

public class GestoreLibriHM extends GestoreLibriAstratto{
    private HashMap<Libro, Integer> lib;
    public GestoreLibriHM(){
        lib = new HashMap<>();
    }

    @Override
    public Iterator<Libro> iterator() {
        return null;
    }
}
