/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

import java.util.Date;

/**
 *
 * @author 39351
 */
public class Autori {
    
    int idAutore;
    String Nome;
    String Cognome;
    String Nazionalita;
    Date DatadiNascita;

    public Autori(int idAutore, String Nome, String Cognome, String Nazionalita, Date DatadiNascita) {
        this.idAutore = idAutore;
        this.Nome = Nome;
        this.Cognome = Cognome;
        this.Nazionalita = Nazionalita;
        this.DatadiNascita = DatadiNascita;
    }

    Autori() {
    }

    public int getIdAutore() {
        return idAutore;
    }

    public void setIdAutore(int idAutore) {
        this.idAutore = idAutore;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getCognome() {
        return Cognome;
    }

    public void setCognome(String Cognome) {
        this.Cognome = Cognome;
    }

    public String getNazionalita() {
        return Nazionalita;
    }

    public void setNazionalita(String Nazionalita) {
        this.Nazionalita = Nazionalita;
    }

    public Date getDatadiNascita() {
        return DatadiNascita;
    }

    public void setDatadiNascita(Date DatadiNascita) {
        this.DatadiNascita = DatadiNascita;
    }
    
    
}
