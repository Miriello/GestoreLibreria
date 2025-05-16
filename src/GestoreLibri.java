public interface GestoreLibri extends Iterable<Libro>{
    public void add(Libro lib);
    public void remove(Libro lib);
    public Libro get(int index);
    public int size();
}
