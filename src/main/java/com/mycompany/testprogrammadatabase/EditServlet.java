/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author 39351
 */
@WebServlet(name = "EditServlet", urlPatterns = {"/EditServlet"})
public class EditServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(EditServlet.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String titolo = request.getParameter("newTitle");
        String autore = request.getParameter("newAuthor");
        String prezzo = request.getParameter("newPrice");

        try (Connection conn = ConnectDB.getConnection()) {
            double prezzo1 = Double.parseDouble(prezzo);
            
            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                int id = Integer.parseInt(idParam);
                UpdateBook(conn, id, titolo, autore, prezzo1);
                logger.info("Aggiornamento riuscito nel database!");
                response.sendRedirect("Libreria");
            } else {
                logger.error("ID non fornito nella richiesta.");
                response.getWriter().println("Errore: ID non fornito nella richiesta.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Errore nell'aggiornamento del database: " + e.getMessage());
        }
    }

    private void UpdateBook(Connection conn, int id, String titolo, String autore, double prezzo) throws SQLException {
        String updateQuery = "UPDATE LIBRERIA SET Titolo = ?, Autore = ?, Prezzo = ? WHERE ID = ?";
        try (PreparedStatement updatePst = conn.prepareStatement(updateQuery)) {
            updatePst.setString(1, titolo);
            updatePst.setString(2, autore);
            updatePst.setDouble(3, prezzo);
            updatePst.setInt(4, id);
            updatePst.executeUpdate();
        }
    }
}
