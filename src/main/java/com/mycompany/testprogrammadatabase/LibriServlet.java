/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.testprogrammadatabase;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "LibriServlet", urlPatterns = {"/libri"})
public class LibriServlet extends HttpServlet {

private static final Logger logger = LogManager.getLogger(LibriServlet.class);
    private final LibriDAO libriDAO = new LibriDAODB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Libri> libriList = new ArrayList<>();

        request.setCharacterEncoding("UTF-8");

        String searchKeyword = request.getParameter("searchLibri");

        if (searchKeyword != null) {
            searchKeyword = URLDecoder.decode(searchKeyword, "UTF-8");

            try {
                libriList = libriDAO.trovaPerTitolo(searchKeyword);
            } catch (Exception e) {
                logger.error("Errore durante la ricerca degli autori per nome", e);
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Errore durante la ricerca degli autori per nome");
                return;
            }
        } else {
            libriList = libriDAO.trovaTutti();
        }

        request.setAttribute("searchKeyword", searchKeyword);
        request.setAttribute("libriList", libriList);
        request.getRequestDispatcher("/libri.jsp").forward(request, response);
    }
}