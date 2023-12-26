/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

/**
 *
 * @author 39351
 */
public class Libri {
    
    int ISBN;
    String Titolo;
    String CasaEditrice;
    int idAutore;
    int numeroPagine;
    String Lingua;
    String Genere;
    double Prezzo;

    public Libri(int ISBN, String Titolo, String CasaEditrice, int idAutore, int numeroPagine, String Lingua, String Genere, double Prezzo) {
        this.ISBN = ISBN;
        this.Titolo = Titolo;
        this.CasaEditrice = CasaEditrice;
        this.idAutore = idAutore;
        this.numeroPagine = numeroPagine;
        this.Lingua = Lingua;
        this.Genere = Genere;
        this.Prezzo = Prezzo;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return Titolo;
    }

    public void setTitolo(String Titolo) {
        this.Titolo = Titolo;
    }

    public String getCasaEditrice() {
        return CasaEditrice;
    }

    public void setCasaEditrice(String CasaEditrice) {
        this.CasaEditrice = CasaEditrice;
    }

    public int getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    public String getLingua() {
        return Lingua;
    }

    public void setLingua(String Lingua) {
        this.Lingua = Lingua;
    }

    public String getGenere() {
        return Genere;
    }

    public void setGenere(String Genere) {
        this.Genere = Genere;
    }

    public double getPrezzo() {
        return Prezzo;
    }

    public void setPrezzo(double Prezzo) {
        this.Prezzo = Prezzo;
    }
    
}
