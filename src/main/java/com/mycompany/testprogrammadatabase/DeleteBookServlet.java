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
    AutoriDAODB autoriDAODB = new AutoriDAODB();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        String[] selectedAuthorsArray = request.getParameterValues("selectedAuthors");
        
        if (selectedAuthorsArray != null && selectedAuthorsArray.length > 0) {
            for (String idAutoreStr : selectedAuthorsArray) {
                int idAutore = Integer.parseInt(idAutoreStr);

                try (Connection conn = ConnectDB.getConnection()){
                    autoriDAODB.deleteAll(idAutore, conn);
                } catch (SQLException e) {
                    e.printStackTrace();
                    logger.error("Errore: " + e.getMessage());
                }
            }
        } else {
            logger.info("Non hai selezionato nessuna checkbox!");
        }
        
    }
}
