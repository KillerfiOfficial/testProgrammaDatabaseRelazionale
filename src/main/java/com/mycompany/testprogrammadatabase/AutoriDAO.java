package com.mycompany.testprogrammadatabase;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface AutoriDAO {

    List<Autori> trovaTutti();

    Autori trovaPerIdAutore(int idAutore);

    void deleteAutore(int idAutore, Connection conn);

    void addAutore(Connection conn, int idAutore, String Nome, String Cognome, String Nazionalita, Date DatadiNascita);

    void editAutore(Connection conn, String isbn, int idAutore, int quantita, int venduti, int classifica, String recensione);
    
    List<Autori> trovaPerNomeAutore(String nome);

}
