/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author 39351
 */
public class LibroDAODB implements LibroDAO {

    private static final Logger logger = LogManager.getLogger(LibroDAODB.class);

    @Override
    public List<Libreria> trovaTutti() {
        List<Libreria> bookList = new ArrayList<>();

        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "SELECT * FROM LIBRERIA";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        int id = rs.getInt("ID");
                        String isbn = rs.getString("ISBN");
                        int idAutore = rs.getInt("IdAutore");
                        int scaffale = rs.getInt("Scaffale");
                        int quantita = rs.getInt("Quantita");
                        int venduti = rs.getInt("Venduti");
                        int classifica = rs.getInt("Classifica");
                        String recensione = rs.getString("Recensione");

                        Libreria book = new Libreria(id, isbn, idAutore, scaffale, quantita, venduti, classifica, recensione);
                        bookList.add(book);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Erorre nel sql: " + e.getMessage());
        }

        return bookList;
    }

    @Override
    public Libreria trovaPerISBN(String isbn) {
        Libreria book = null;

        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "SELECT * FROM LIBRERIA WHERE ISBN = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, isbn);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        int id = rs.getInt("ID");
                        String fetchedIsbn = rs.getString("ISBN");
                        int idAutore = rs.getInt("IdAutore");
                        int scaffale = rs.getInt("Scaffale");
                        int quantita = rs.getInt("Quantita");
                        int venduti = rs.getInt("Venduti");
                        int classifica = rs.getInt("Classifica");
                        String recensione = rs.getString("Recensione");

                        book = new Libreria(id, fetchedIsbn, idAutore, scaffale, quantita, venduti, classifica, recensione);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return book;
    }

    @Override
    public Libreria trovaPerId(int bookId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteLibreria(int id, Connection conn) {
        String deleteQuery = "DELETE FROM LIBRERIA WHERE ID = ?";
        try (PreparedStatement deletePst = conn.prepareStatement(deleteQuery)) {
            deletePst.setInt(1, id);
            deletePst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.info("Errore durante l'eliminazione del libro: " + e.getMessage());
        }
    }

    @Override
    public void addLibreria(Connection conn, int id, String isbn, int idAutore, int scaffale, int quantita, int venduti, int classifica, String recensione) {
        try {
            String sql = "INSERT INTO LIBRERIA (ID, ISBN, IdAutore, Scaffale, Quantita, Venduti, Classifica, Recensione) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, id);
                pst.setString(2, isbn);
                pst.setInt(3, idAutore);
                pst.setInt(4, scaffale);
                pst.setInt(5, quantita);
                pst.setInt(6, venduti);
                pst.setInt(7, classifica);
                pst.setString(8, recensione);

                pst.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Errore durante l'inserimento nel database: " + e.getMessage());
        }
    }

    @Override
    public void editLibreria(Connection conn, int id, int scaffale, int quantita, int venduti, int classifica, String recensione) {
        try {

            String updateLibreriaQuery = "UPDATE LIBRERIA SET Scaffale = ?, Quantita = ?, Venduti = ?, Classifica = ?, Recensione = ? WHERE ID = ?";
            try (PreparedStatement updateLibreriaPst = conn.prepareStatement(updateLibreriaQuery)) {
                updateLibreriaPst.setInt(1, scaffale);
                updateLibreriaPst.setInt(2, quantita);
                updateLibreriaPst.setInt(3, venduti);
                updateLibreriaPst.setInt(4, classifica);
                updateLibreriaPst.setString(5, recensione);
                updateLibreriaPst.setInt(6, id);

                updateLibreriaPst.executeUpdate();

                logger.info("Modifica nella tabella LIBRERIA riuscita");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Errore durante l'aggiornamento della tabella LIBRERIA: " + e.getMessage());
        }
    }

}
