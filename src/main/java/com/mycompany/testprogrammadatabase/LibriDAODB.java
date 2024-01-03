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
public class LibriDAODB implements LibriDAO {

    private static final Logger logger = LogManager.getLogger(LibriDAODB.class);

    @Override
    public List<Libri> trovaTutti() {

        List<Libri> libriList = new ArrayList<>();

        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "SELECT * FROM LIBRI";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                try (ResultSet rst = pst.executeQuery()) {
                    while (rst.next()) {
                        int isbn = rst.getInt("ISBN");
                        String titolo = rst.getString("TITOLO");
                        String casaeditrice = rst.getString("CASAEDITRICE");
                        int idautore = rst.getInt("IDAUTORE");
                        int numeropagine = rst.getInt("NUMPAGINE");
                        String lingua = rst.getString("LINGUA");
                        String genere = rst.getString("GENERE");
                        double prezzo = rst.getDouble("PREZZO");

                        Libri libro = new Libri(isbn, titolo, casaeditrice, idautore, numeropagine, lingua, genere, prezzo);
                        libriList.add(libro);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Errore sql: " + e.getMessage());
        }
        return libriList;
    }

    @Override
    public List<Libri> trovaPerTitolo(String titolo) {
        List<Libri> libriList = new ArrayList<>();

        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "SELECT * FROM LIBRI WHERE TITOLO LIKE ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, "%" + titolo + "%");

                try (ResultSet rst = pst.executeQuery()) {
                    while (rst.next()) {
                        int isbn = rst.getInt("ISBN");
                        String titoloLibro = rst.getString("TITOLO");
                        String casaeditrice = rst.getString("CASAEDITRICE");
                        int idautore = rst.getInt("IDAUTORE");
                        int numeropagine = rst.getInt("NUMPAGINE");
                        String lingua = rst.getString("LINGUA");
                        String genere = rst.getString("GENERE");
                        double prezzo = rst.getDouble("PREZZO");

                        Libri libro = new Libri(isbn, titoloLibro, casaeditrice, idautore, numeropagine, lingua, genere, prezzo);
                        libriList.add(libro);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Errore sql: " + e.getMessage());
        }
        return libriList;
    }

    @Override
    public void addLibri(Connection conn, int isbn, String titolo, String casaeditrice, int idAutore, int numeroPagine, String lingua, String genere, double prezzo) {
        try (Connection connect = ConnectDB.getConnection()) {
            String insertQuery = "INSERT INTO LIBRI (ISBN, TITOLO, CASAEDITRICE, IDAUTORE, NUMPAGINE, LINGUA, GENERE, PREZZO) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            try (PreparedStatement preparedStatement = connect.prepareStatement(insertQuery)) {
                preparedStatement.setInt(1, isbn);
                preparedStatement.setString(2, titolo);
                preparedStatement.setString(3, casaeditrice);
                preparedStatement.setInt(4, idAutore);
                preparedStatement.setInt(5, numeroPagine);
                preparedStatement.setString(6, lingua);
                preparedStatement.setString(7, genere);
                preparedStatement.setDouble(8, prezzo);

                preparedStatement.executeUpdate();

            } catch (SQLException e) {
                e.printStackTrace();
                logger.error("Errore nell'aggiunta del libro: " + e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Errore: " + e.getMessage());
        }
    }

    @Override
    public void editLibri(Connection conn, int isbn, String titolo, String casaeditrice, int idAutore, int numeroPagine, String lingua, String genere, double prezzo) {

        String query = "UPDATE LIBRI SET TITOLO = ?, CASAEDITRICE = ?, NUMPAGINE = ?, LINGUA = ?, GENERE = ?, PREZZO = ? WHERE ISBN = ? AND IDAUTORE = ?";

        try (PreparedStatement pst = conn.prepareStatement(query)) {
            pst.setString(1, titolo);
            pst.setString(2, casaeditrice);
            pst.setInt(3, numeroPagine);
            pst.setString(4, lingua);
            pst.setString(5, genere);
            pst.setDouble(6, prezzo);
            pst.setInt(7, isbn);
            pst.setInt(8, idAutore);
            
            pst.executeUpdate();

            logger.info("Modifica della tabella LIBRI riuscita!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            logger.error("Errore nella modifica della tabella LIBRI: " + ex.getMessage());
        }
    }

}
