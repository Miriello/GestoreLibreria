package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import database.*;
import gestore.*;
import libreria.Libreria;
import libro.*;

import java.awt.event.ActionListener;

public class LibreriaGUI extends JFrame{
    private Libreria libreria;
    private JTable tabellaLibri;
    private DefaultTableModel tableModel;
    private ActionListener listener;

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
        menuItemSalva.addActionListener(e -> libreria.salvaFile("Libreria.dat"));
        JMenuItem menuItemSalvaConNome= new JMenuItem("Salva con nome");
        menuItemSalvaConNome.addActionListener(e-> salvaConNome());
        JMenuItem menuItemApri = new JMenuItem("Apri");
        menuItemApri.addActionListener(e-> apri());
        JMenuItem menuItemNuovo = new JMenuItem("Nuovo");
        menuItemNuovo.addActionListener(e-> NuovaLibreria());
        barraMenu.add(menuFile);
        barraMenu.add(menuItemNuovo);
        menuFile.add(menuItemApri);
        menuFile.add(menuItemSalva);
        menuFile.add(menuItemSalvaConNome);


        //OPZIONI > AGGIUNGI / RIMUOVI
        JMenu menuOpzioni = new JMenu("Opzioni");
        JMenuItem menuItemAggiungi = new JMenuItem("Aggiungi");
        menuItemAggiungi.addActionListener(e -> aggiungiLibro());
        JMenuItem menuItemRimuovi = new JMenuItem("Rimuovi");
        menuItemRimuovi.addActionListener(e -> rimuoviLibro());
        barraMenu.add(menuOpzioni);
        menuOpzioni.add(menuItemAggiungi);
        menuOpzioni.add(menuItemRimuovi);

        //ORDINA > PER TITOLO / PER AUTORE
        JMenu menuOrdina = new JMenu("Ordina");
        JMenuItem menuItemOrdinaTitolo = new JMenuItem("Per Titolo");
        menuItemOrdinaTitolo.addActionListener(e -> {
            libreria.ordinaPerTitolo();
            aggiornaTabella();
        });
        JMenuItem menuItemOrdinaAutore = new JMenuItem("Per Autore");
        menuItemOrdinaAutore.addActionListener(e -> {
            libreria.ordinaPerAutore();
            aggiornaTabella();
        });
        barraMenu.add(menuOrdina);
        menuOrdina.add(menuItemOrdinaTitolo);
        menuOrdina.add(menuItemOrdinaAutore);

        //FILTRA > PER GENERE / PER AUTORE / PER STATO LETTURA
        JMenu menuFiltra = new JMenu("Filtra");
        JMenuItem menuItemFiltraGenere = new JMenuItem("Per Genere");
        menuItemFiltraGenere.addActionListener(e -> {
            String genere = JOptionPane.showInputDialog("Inserisci il genere da cercare");
            libreria.filtroGenere(genere);
            aggiornaTabella();
                });
        JMenuItem menuItemFiltraAutore = new JMenuItem("Per Autore");
        menuItemFiltraAutore.addActionListener(e -> {
            String autore = JOptionPane.showInputDialog("Inserisci l'autore da cercare");
            libreria.filtroAutore(autore);
            aggiornaTabella();
            });
        JMenuItem menuItemFiltraStatoLettura = new JMenuItem("Per Stato Lettura");
        menuItemFiltraStatoLettura.addActionListener(e -> {
            StatoLettura stato = StatoLettura.valueOf(JOptionPane.showInputDialog("Inserisci lo stato da cercare"));
            libreria.filtroStatoLettura(stato);
            aggiornaTabella();
            });
        barraMenu.add(menuFiltra);
        menuFiltra.add(menuItemFiltraGenere);
        menuFiltra.add(menuItemFiltraAutore);
        menuFiltra.add(menuItemFiltraStatoLettura);

        //CREDITI
        JMenu menuCrediti = new JMenu("Crediti");
        JMenuItem crediti = new JMenuItem("Mostra Crediti");
        crediti.addActionListener(e -> mostraCrediti());
        barraMenu.add(menuCrediti);
        menuCrediti.add(crediti);

        setJMenuBar(barraMenu);

        //TABELLA
        String[] campi = {"Titolo", "Autore", "Genere", "Codice ISBN", "Valutazione", "StatoLettura"};
        tableModel = new DefaultTableModel(campi, 0){
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tabellaLibri = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tabellaLibri);
        add(scrollPane);
    }
    public void aggiornaTabella(){
        tableModel.setRowCount(0);
        for(Libro l : libreria.getLibri()){
            Object[] riga = {l.getTitolo(), l.getAutore(), l.getGenere(), l.getCodiceISBN(), l.getValutazionePersonale(), l.getStatoLettura()};
            tableModel.addRow(riga);
        }

    }
        public void mostraCrediti(){
            JOptionPane.showMessageDialog(this, "Progetto di Francesco Miriello, Matricola 251641");
            System.out.println("Progetto di Francesco Miriello, Matricola 251641");
        }

    public void aggiungiLibro(){
        String titolo = JOptionPane.showInputDialog("Inserisci il titolo del libro");
        String autore = JOptionPane.showInputDialog("Inserisci l'autore del libro");
        int codiceISBN = Integer.parseInt(JOptionPane.showInputDialog("Inserisci il codice ISBN del libro"));
        String genere = JOptionPane.showInputDialog("Inserisci il genere del libro");
        Valutazione valutazione = Valutazione.valueOf(JOptionPane.showInputDialog("Inserisci la valutazione del libro"));
        StatoLettura stato = StatoLettura.valueOf(JOptionPane.showInputDialog("Inserisci lo stato della lettura del libro"));
        Libro libro = new Libro(titolo, autore, codiceISBN, genere, valutazione, stato);
        libreria.add(libro);
        aggiornaTabella();
    }

    public void rimuoviLibro(){
        String titolo = JOptionPane.showInputDialog("Inserisci il titolo del libro da rimuovere");
        Libro libro = libreria.getLibro(titolo);
        if(libro != null){
            libreria.remove(libro);
            aggiornaTabella();
        }else{
            JOptionPane.showMessageDialog(this, "Libro non trovato");
        }
    }
    public void salvaConNome(){
        String nomeFile = JOptionPane.showInputDialog("Inserisci il nome del file");
        libreria.salvaFile(nomeFile);
    }

    public void apri(){
        String nomeFile = JOptionPane.showInputDialog("Inserisci il nome del file");
        try {
            System.out.println("Caricamento in corso...");
            libreria.caricaFile(nomeFile);
            aggiornaTabella();
            System.out.println("Caricamento completato!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Errore durante il caricamento: " + e.getMessage());
        }
    }

    public void NuovaLibreria(){

    }

}

