package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.logging.log4j.LogManager;

@WebServlet(name = "DeleteBookServlet", urlPatterns = "/DeleteBookServlet")
public class DeleteBookServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final org.apache.logging.log4j.Logger logger = LogManager.getLogger(DeleteBookServlet.class);
    LibroDAODB libro = new LibroDAODB();

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String deleteId = request.getParameter("selectedBooks");
        if (deleteId != null && !deleteId.isEmpty()) {
            try {
                try (Connection conn = ConnectDB.getConnection()) {
                    int bookId = Integer.parseInt(deleteId);
                    libro.deleteLibreria(bookId, conn);
                    response.sendRedirect("LibreriaServlet");
                } catch (SQLException e) {
                    e.printStackTrace();
                    response.getWriter().println("Errore durante l'eliminazione del libro: " + e.getMessage());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            logger.info("Non hai selezionato nessuna checkbox!");
            response.sendRedirect("Libreria");
        }
    }
}
