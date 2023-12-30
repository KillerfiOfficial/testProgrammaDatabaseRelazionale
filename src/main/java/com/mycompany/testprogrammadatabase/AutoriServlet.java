package com.mycompany.testprogrammadatabase;

import java.io.IOException;
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

@WebServlet(name = "AutoriServlet", urlPatterns = {"/autori"})
public class AutoriServlet extends HttpServlet {

    private static final Logger logger = LogManager.getLogger(AutoriServlet.class);
    private final AutoriDAO autoriDAO = new AutoriDAODB();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Autori> autoriList = new ArrayList<>();

        request.setCharacterEncoding("UTF-8");

        String searchKeyword = request.getParameter("searchAutori");

        if (searchKeyword != null) {
            searchKeyword = URLDecoder.decode(searchKeyword, "UTF-8");

            try {
                autoriList = autoriDAO.trovaPerNomeAutore(searchKeyword);
            } catch (Exception e) {
                logger.error("Errore durante la ricerca degli autori per nome", e);
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Errore durante la ricerca degli autori per nome");
                return;
            }
        } else {
            autoriList = autoriDAO.trovaTutti();
        }

        request.setAttribute("searchKeyword", searchKeyword);
        request.setAttribute("autoriList", autoriList);
        request.getRequestDispatcher("/autori.jsp").forward(request, response);
    }
}
