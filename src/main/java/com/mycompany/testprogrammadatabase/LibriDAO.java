/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

import java.sql.Connection;
import java.util.List;

/**
 *
 * @author 39351
 */
public interface LibriDAO {
    
    List<Libri> trovaTutti();
    
    List trovaPerTitolo(String titolo);
    
    void addLibri(Connection conn, int isbn, String titolo, String casaeditrice, int idAutore, int numeroPagine, String lingua, String genere, double prezzo);
    
    void editLibri(Connection conn, int isbn, String titolo, String casaeditrice, int idAutore, int numeroPagine, String lingua, String genere, double prezzo);
    
}
