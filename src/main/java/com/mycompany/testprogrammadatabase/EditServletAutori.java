/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
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
@WebServlet(name = "EditServletAutori", urlPatterns = { "/EditServletAutori" })
public class EditServletAutori extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(EditServletAutori.class);
    AutoriDAODB autoriDAODB = new AutoriDAODB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try (Connection conn = ConnectDB.getConnection()) {
            conn.setAutoCommit(false); 

            String idAutoreStr = request.getParameter("autoreId");
            String nome = request.getParameter("newNome");
            String cognome = request.getParameter("newCognome");
            String nazionalita = request.getParameter("newNazionalita");
            String dataNascitaStr = request.getParameter("newDataNascita");

            int idAutore = Integer.parseInt(idAutoreStr);
            Date dataNascita = Date.valueOf(dataNascitaStr);

            logger.info("Autore prima dell'aggiornamento: " + autoriDAODB.trovaPerNomeAutore(nome));

            autoriDAODB.editAutore(conn, idAutore, nome, cognome, nazionalita, dataNascita);

            logger.info("Modifica dell'autore in corso...");
            logger.info("ID Autore: " + idAutore);
            logger.info("Nuovo Nome: " + nome);
            logger.info("Nuovo Cognome: " + cognome);
            logger.info("Nuova Nazionalità: " + nazionalita);
            logger.info("Nuova Data di Nascita: " + dataNascita);

            conn.commit(); 

            logger.info("Modifica dell'autore completata con successo!");

            response.sendRedirect("autori");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Errore durante la modifica dell'autore: " + e.getMessage());
        }
    }
}
