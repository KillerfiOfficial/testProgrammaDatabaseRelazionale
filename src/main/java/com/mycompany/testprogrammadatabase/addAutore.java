package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;

@WebServlet(name = "addAutore", urlPatterns = {"/addAutore"})
public class addAutore extends HttpServlet {

    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(addAutore.class);

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        AutoriDAODB autoriDAODB = new AutoriDAODB();

        try (Connection conn = ConnectDB.getConnection()) {
            String idAutoreStr = request.getParameter("idAutore");
            String nome = request.getParameter("nome");
            String cognome = request.getParameter("cognome");
            String nazionalita = request.getParameter("nazionalita");
            String dataNascitaStr = request.getParameter("dataNascita");

            int idAutore = Integer.parseInt(idAutoreStr);
            Date dataNascita = java.sql.Date.valueOf(dataNascitaStr);

            autoriDAODB.addAutore(conn, idAutore, nome, cognome, nazionalita, dataNascita);

            Autori addedAutori = autoriDAODB.trovaPerIdAutore(idAutore);

            request.setAttribute("addedAutori", addedAutori);

            request.getRequestDispatcher("/risultatoAddAutore.jsp").forward(request, response);

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Errore in sql: " + e.getMessage());
        }
    }

}
