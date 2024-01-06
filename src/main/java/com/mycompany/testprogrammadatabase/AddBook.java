package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AddBook", urlPatterns = "/add")
public class AddBook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");

        try (PrintWriter out = response.getWriter()) {
            try (Connection conn = ConnectDB.getConnection()) {
                request.setCharacterEncoding("UTF-8");

                String idStr = request.getParameter("id");
                String isbn = request.getParameter("isbn");
                String idAutoreStr = request.getParameter("idAutore");
                String scaffaleStr = request.getParameter("scaffale");
                String quantitaStr = request.getParameter("quantita");
                String vendutiStr = request.getParameter("venduti");
                String classificaStr = request.getParameter("classifica");
                String recensione = request.getParameter("recensione");

                int id = Integer.parseInt(idStr);
                int idAutore = Integer.parseInt(idAutoreStr);
                int scaffale = Integer.parseInt(scaffaleStr);
                int quantita = Integer.parseInt(quantitaStr);
                int venduti = Integer.parseInt(vendutiStr);
                int classifica = Integer.parseInt(classificaStr);

                LibroDAODB libroDAO = new LibroDAODB();
                libroDAO.addLibreria(conn, id, isbn, idAutore, scaffale, quantita, venduti, classifica, recensione);

                Libreria addedBook = libroDAO.trovaPerISBN(isbn);

                request.setAttribute("addedBook", addedBook);
                request.getRequestDispatcher("/risultatoadd.jsp").forward(request, response);
            } catch (SQLException | NumberFormatException e) {
                e.printStackTrace();
                request.setAttribute("message", "<p>Errore durante l'inserimento nel database: " + e.getMessage() + "</p>");
                request.getRequestDispatcher("/risultatoadd.jsp").forward(request, response);
            }
        }
    }

}
