package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import database.*;
import gestore.*;
import libreria.Libreria;
import libro.*;

public class LibreriaGUI extends JFrame{
    private Libreria libreria;
    private JTable tabellaLibri;
    private DefaultTableModel tableModel;

    public LibreriaGUI(Libreria libreria){
        this.libreria = libreria;
        setTitle("Libreria");
        setSize(1200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        inizializzaComponenti();
        aggiornaTabella();
        setVisible(true);
    }

    public void inizializzaComponenti() {
        //MENU
        JMenuBar barraMenu = new JMenuBar();
        //FILE > CARICA / SALVA
        JMenu menuFile = new JMenu("File");
        JMenuItem menuItemSalva = new JMenuItem("Salva");
        JMenuItem menuItemCarica = new JMenuItem("Carica");
        barraMenu.add(menuFile);
        menuFile.add(menuItemSalva);
        menuFile.add(menuItemCarica);

        //OPZIONI > AGGIUNGI / RIMUOVI
        JMenu menuOpzioni = new JMenu("Opzioni");
        JMenuItem menuItemAggiungi = new JMenuItem("Aggiungi");
        JMenuItem menuItemRimuovi = new JMenuItem("Rimuovi");
        barraMenu.add(menuOpzioni);
        menuOpzioni.add(menuItemAggiungi);
        menuOpzioni.add(menuItemRimuovi);

        //ORDINA > PER TITOLO / PER AUTORE
        JMenu menuOrdina = new JMenu("Ordina");
        JMenuItem menuItemOrdinaTitolo = new JMenuItem("Per Titolo");
        JMenuItem menuItemOrdinaAutore = new JMenuItem("Per Autore");
        barraMenu.add(menuOrdina);
        menuOrdina.add(menuItemOrdinaTitolo);
        menuOrdina.add(menuItemOrdinaAutore);

        setJMenuBar(barraMenu);

        //TABELLA
        String[] campi = {"Titolo", "Autore", "Genere", "Codice ISBN", "Valutazione", "StatoLettura"};
        tableModel = new DefaultTableModel(campi, 0);
        tabellaLibri = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabellaLibri);
        add(scrollPane);
    }
    public void aggiornaTabella(){
        for(Libro l : libreria.getLibri()){
            Object[] riga = {l.getTitolo(), l.getAutore(), l.getGenere(), l.getCodiceISBN(), l.getValutazionePersonale(), l.getStatoLettura()};
            tableModel.addRow(riga);
        }

    }


}

