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


}
