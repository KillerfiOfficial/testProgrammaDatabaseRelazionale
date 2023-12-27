package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "LibreriaServlet", urlPatterns = {"/libreria"})
public class LibreriaServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(LibreriaServlet.class);
    private final LibroDAODB libroDAO = new LibroDAODB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Libreria> bookList = new ArrayList<>();

        request.setCharacterEncoding("UTF-8");

        String searchTitle = request.getParameter("search");

        if (searchTitle != null) {
            searchTitle = URLDecoder.decode(searchTitle, "UTF-8");
        }

        try {
            if (searchTitle != null && !searchTitle.isEmpty()) {
                Libreria bookByTitle = libroDAO.trovaPerISBN(searchTitle);
                bookList = (bookByTitle != null) ? Arrays.asList(bookByTitle) : Arrays.asList();
            } else {
                bookList = libroDAO.trovaTutti();
            }
        } catch (Exception e) {
            logger.error("Errore durante il recupero dei dati dalla base di dati", e);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Errore durante il recupero dei dati dalla base di dati");
            return;
        }

        request.setAttribute("searchTerm", searchTitle);
        request.setAttribute("books", bookList);
        request.getRequestDispatcher("/libreria.jsp").forward(request, response);
    }
}
