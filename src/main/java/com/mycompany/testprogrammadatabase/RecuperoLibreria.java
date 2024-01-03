package com.mycompany.testprogrammadatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecuperoLibreria {

    public static List<Libreria> fetchBooks() {
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
        }

        return bookList;
    }

    public static Libreria fetchBookByISBN(String isbn) {
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
    
    public static Libreria fetchBookById(int bookId) {
        Libreria book = null;

        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "SELECT * FROM LIBRERIA WHERE ID = ?";
            
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, bookId);

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
}
