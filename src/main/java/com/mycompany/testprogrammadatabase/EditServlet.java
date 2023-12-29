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
    LibroDAODB libroDAODB = new LibroDAODB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String scaffale = request.getParameter("newScaffale");
        String quantita = request.getParameter("newQuantita");
        String venduti = request.getParameter("newVenduti");
        String classifica = request.getParameter("newClassifica");
        String recensione = request.getParameter("newRecensione");

        try (Connection conn = ConnectDB.getConnection()) {
            int scaffale1 = Integer.parseInt(scaffale);
            int quantita1 = Integer.parseInt(quantita);
            int venduti1 = Integer.parseInt(venduti);
            int classifica1 = Integer.parseInt(classifica);

            String idParam = request.getParameter("id");
            if (idParam != null && !idParam.isEmpty()) {
                int id = Integer.parseInt(idParam);
                libroDAODB.editLibreria(conn, id, scaffale1, quantita1, venduti1, classifica1, recensione);
                logger.info("Aggiornamento riuscito nel database!");
                response.sendRedirect("libreria");
            } else {
                logger.error("ID non fornito nella richiesta.");
                response.getWriter().println("Errore: ID non fornito nella richiesta.");
            }
        } catch (SQLException | NumberFormatException e) {
            e.printStackTrace();
            logger.error("Errore nell'aggiornamento del database: " + e.getMessage());
        }
    }
}
