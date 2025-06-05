package test;

import libro.*;
import gestore.*;
import database.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class GestoreLibreriaTest {
    private GestoreLibri gestoreLibri;

    @BeforeEach
    public void inizio() {
        gestoreLibri = new GestoreLibriArray();
        gestoreLibri.add(new Libro("La coscienza di Zeno", "Italo Svevo", 00001, "Romanzo", null, StatoLettura.DALEGGERE));
        gestoreLibri.add(new Libro("Novecento", "Alessandro Baricco", 00002, "Teatrale", Valutazione.CINQUE, StatoLettura.LETTO));
    }

    @Test
    public void testAdd() {
        assertEquals(2, gestoreLibri.size());
        gestoreLibri.add(new Libro("Il giovane Holden", "J.D.Salinger", 00003, "Romanzo", null, StatoLettura.DALEGGERE));
        assertEquals(3, gestoreLibri.size());
    }

    @Test
    public void testGetAutore() {
        Libro l = gestoreLibri.getLibro("La coscienza di Zeno");
        assertEquals("Italo Svevo", l.getAutore());
    }

    @Test
    public void testGetLibro() {
        Libro l = gestoreLibri.getLibro("La coscienza di Zeno");
        assertEquals("La coscienza di Zeno", l.getTitolo());
    }

    @Test
    public void testRemove() {
        assertEquals(2, gestoreLibri.size());
        gestoreLibri.remove(gestoreLibri.getLibro("La coscienza di Zeno"));
        assertEquals(1, gestoreLibri.size());
    }

    @Test
    public void testFiltroAutore() {
        GestoreLibri temp = new GestoreLibriArray();
        temp = gestoreLibri.filtroAutore("Italo Svevo");
        Libro l = temp.getLibro("La coscienza di Zeno");
        assertEquals("Italo Svevo", l.getAutore());
    }

    @Test
    public void testFiltroGenere() {
        GestoreLibri temp = new GestoreLibriArray();
        temp = gestoreLibri.filtroGenere("Romanzo");
        Libro l = temp.getLibro("La coscienza di Zeno");
        assertEquals("Romanzo", l.getGenere());
    }
    @Test
    public void testFiltroStatoLettura() {
        GestoreLibri temp = new GestoreLibriArray();
        temp = gestoreLibri.filtroStatoLettura(StatoLettura.LETTO);
        Libro l = temp.getLibro("Novecento");
        assertEquals(StatoLettura.LETTO, l.getStatoLettura());
    }
    @Test
    public void testOrdinaPerTitolo() {
        GestoreLibri temp = new GestoreLibriArray();
        temp = gestoreLibri.ordinaPerTitolo(gestoreLibri);
        Libro l = temp.getLibro("La coscienza di Zeno");
        assertEquals("La coscienza di Zeno", l.getTitolo());
    }
}