package com.mycompany.testprogrammadatabase;

public class Libreria {

    private int id;
    private String isbn;
    private int idAutore;
    private int scaffale;
    private int quantita;
    private int venduti;
    private int classifica;
    private String recensione;

    public Libreria(int id, String isbn, int idAutore, int scaffale, int quantita, int venduti, int classifica, String recensione) {
        this.id = id;
        this.isbn = isbn;
        this.idAutore = idAutore;
        this.scaffale = scaffale;
        this.quantita = quantita;
        this.venduti = venduti;
        this.classifica = classifica;
        this.recensione = recensione;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

    public int getScaffale() {
        return scaffale;
    }

    public void setScaffale(int scaffale) {
        this.scaffale = scaffale;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

    public int getVenduti() {
        return venduti;
    }

    public void setVenduti(int venduti) {
        this.venduti = venduti;
    }

    public int getClassifica() {
        return classifica;
    }

    public void setClassifica(int classifica) {
        this.classifica = classifica;
    }

    public String getRecensione() {
        return recensione;
    }

    public void setRecensione(String recensione) {
        this.recensione = recensione;
    }

    @Override
    public String toString() {
        return String.format("Libreria [id=%d, isbn='%s', idAutore=%d, scaffale=%d, quantita=%d, venduti=%d, classifica=%d, recensione='%s']",
                id, isbn, idAutore, scaffale, quantita, venduti, classifica, recensione);
    }
}
