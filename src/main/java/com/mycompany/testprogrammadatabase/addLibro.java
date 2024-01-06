package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;

@WebServlet(name = "AddLibroServlet", urlPatterns = {"/addLibro"})
public class addLibro extends HttpServlet {

    private org.apache.logging.log4j.Logger logger = LogManager.getLogger(addLibro.class);
    private LibriDAODB libroDAODB;
    private AutoriDAODB autoriDAODB;

    public addLibro() {
        super();
        libroDAODB = new LibriDAODB();
        autoriDAODB = new AutoriDAODB();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try (Connection conn = ConnectDB.getConnection()) {
            String autoreInput = request.getParameter("autoreInput");

            int idAutore = ottieniIdAutoreDaInput(autoreInput);

            if (idAutore == -1) {
                logger.error("L'autore specificato non esiste nel database. Impossibile aggiungere il libro.");
                return;
            }

            String isbnStr = request.getParameter("isbn");
            int isbn = Integer.parseInt(isbnStr);
            String titolo = request.getParameter("titolo");
            String casaeditrice = request.getParameter("casaeditrice");
            int numeroPagine = Integer.parseInt(request.getParameter("numeroPagine"));
            String lingua = request.getParameter("lingua");
            String genere = request.getParameter("genere");
            double prezzo = Double.parseDouble(request.getParameter("prezzo"));

            if (libroDAODB != null) {
                libroDAODB.addLibri(conn, isbn, titolo, casaeditrice, idAutore, numeroPagine, lingua, genere, prezzo);

                List<Libri> addedBook = libroDAODB.trovaPerTitolo(titolo);

                request.setAttribute("addedBook", addedBook);
                request.getRequestDispatcher("/risultatoAddLibro.jsp").forward(request, response);
            } else {
                logger.error("libroDAODB non è stato inizializzato correttamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("Errore: " + e.getMessage());
        }
    }

    private int ottieniIdAutoreDaInput(String autoreInput) {
        String[] autoreParts = autoreInput.split("\\s+");
        if (autoreParts.length >= 2) {
            String nome = autoreParts[0];
            String cognome = autoreParts[1];
            return autoriDAODB.ottieniIdAutoreDaInput(nome, cognome);
        }
        return -1;
    }
}
