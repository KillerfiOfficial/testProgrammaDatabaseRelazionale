package com.mycompany.testprogrammadatabase;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public interface AutoriDAO {

    List<Autori> trovaTutti();

    Autori trovaPerIdAutore(int idAutore);

    void deleteAll(int idAutore, Connection conn);

    void addAutore(Connection conn, int idAutore, String Nome, String Cognome, String Nazionalita, Date DatadiNascita);

    void editAutore(Connection conn, int idAutore, String Nome, String Cognome, String Nazionalita, Date DatadiNascita);
    
    List<Autori> trovaPerNomeAutore(String nome);

}
