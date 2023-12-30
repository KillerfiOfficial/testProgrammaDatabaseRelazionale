/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
@WebServlet(name = "EditServletLibri", urlPatterns = {"/EditServletLibri"})
public class EditServletLibri extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(EditServletAutori.class);
    LibriDAODB libriDAODB = new LibriDAODB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String isbnStr = request.getParameter("isbn");
        String idautoreStr = request.getParameter("idautore");
        String titolo = request.getParameter("newTitolo");
        String casaeditrice = request.getParameter("newCasaEditrice");
        String numeropagineStr = request.getParameter("newNumeroPagine");
        String lingua = request.getParameter("newLingua");
        String genere = request.getParameter("newGenere");
        String prezzoStr = request.getParameter("newPrezzo");

        try (Connection conn = ConnectDB.getConnection()) {

            int isbn = Integer.parseInt(isbnStr);
            int idautore = Integer.parseInt(idautoreStr);
            int numeropagine = Integer.parseInt(numeropagineStr);
            double prezzo = Double.parseDouble(prezzoStr);

            libriDAODB.editLibri(conn, isbn, titolo, casaeditrice, idautore, numeropagine, lingua, genere, prezzo);

            logger.info("Inserimento riuscito!");

            response.sendRedirect("libri");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Errore durante l'inserimento: " + e.getMessage());
            response.sendRedirect("libri");

        }

    }

}
