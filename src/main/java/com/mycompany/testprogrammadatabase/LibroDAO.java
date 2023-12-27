package com.mycompany.testprogrammadatabase;

import java.sql.Connection;
import java.util.List;

public interface LibroDAO {

    List<Libreria> trovaTutti();

    Libreria trovaPerISBN(String isbn);

    Libreria trovaPerId(int bookId);

    void deleteLibreria(int id, Connection conn);

    void addLibreria(Connection conn, int id, String isbn, int idAutore, int scaffale, int quantita, int venduti, int classifica, String recensione);

    void editLibreria(Connection conn, String isbn, int idAutore, int scaffale, int quantita, int venduti, int classifica, String recensione);

}
