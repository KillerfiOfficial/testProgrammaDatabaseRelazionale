package com.mycompany.testprogrammadatabase;

import static com.mycompany.testprogrammadatabase.ConnectDB.getConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AutoriDAODB implements AutoriDAO {

    private static final Logger logger = LogManager.getLogger(AutoriDAODB.class);

    @Override
    public List<Autori> trovaTutti() {
        List<Autori> authorList = new ArrayList<>();

        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "SELECT * FROM AUTORI";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        int idAutore = rs.getInt("IDAutore");
                        String nome = rs.getString("Nome");
                        String cognome = rs.getString("Cognome");
                        String nazionalita = rs.getString("Nazionalita");
                        Date dataNascita = rs.getDate("DataNascita");

                        Autori author = new Autori(idAutore, nome, cognome, nazionalita, dataNascita);
                        authorList.add(author);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Errore nel SQL: " + e.getMessage());
        }

        return authorList;
    }

    @Override
    public Autori trovaPerIdAutore(int idAutore) {
        Autori author = null;

        try (Connection conn = ConnectDB.getConnection()) {
            String sql = "SELECT * FROM AUTORI WHERE IDAUTORE = ?";
            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setInt(1, idAutore);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        int idAutoreResult = rs.getInt("IDAutore");
                        String nome = rs.getString("Nome");
                        String cognome = rs.getString("Cognome");
                        String nazionalita = rs.getString("Nazionalita");
                        Date dataNascita = rs.getDate("DataNascita");

                        author = new Autori(idAutoreResult, nome, cognome, nazionalita, dataNascita);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return author;
    }

    @Override
    public void deleteAll(int idAutore, Connection conn) {
        try {

            String deleteLibreriaQuery = "DELETE FROM LIBRERIA WHERE IDAUTORE = ?";
            try (PreparedStatement deleteLibreriaPst = conn.prepareStatement(deleteLibreriaQuery)) {
                deleteLibreriaPst.setInt(1, idAutore);
                deleteLibreriaPst.executeUpdate();
            }

            String deleteLibriQuery = "DELETE FROM LIBRI WHERE IDAUTORE = ?";
            try (PreparedStatement deleteLibriPst = conn.prepareStatement(deleteLibriQuery)) {
                deleteLibriPst.setInt(1, idAutore);
                deleteLibriPst.executeUpdate();
            }

            String deleteAutoreQuery = "DELETE FROM AUTORI WHERE IDAUTORE = ?";
            try (PreparedStatement deleteAutorePst = conn.prepareStatement(deleteAutoreQuery)) {
                deleteAutorePst.setInt(1, idAutore);
                deleteAutorePst.executeUpdate();
            }

            logger.info("Eliminazione riuscita");
        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Errore nella eliminazione: " + e.getMessage());

            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
                logger.error("Rollback fallito: " + ex.getMessage());
            }
        }
    }

    @Override
    public void editAutore(Connection conn, int idAutore, String Nome, String Cognome, String Nazionalita, Date DatadiNascita) {
        String updateQuery = "UPDATE autori SET nome = ?, cognome = ?, nazionalita = ?, datanascita = ? WHERE idautore = ?";

        try (PreparedStatement pst = conn.prepareStatement(updateQuery)) {
            pst.setString(1, Nome);
            pst.setString(2, Cognome);
            pst.setString(3, Nazionalita);
            pst.setDate(4, new java.sql.Date(DatadiNascita.getTime()));
            pst.setInt(5, idAutore);

            pst.executeUpdate();

            logger.info("Query di aggiornamento: " + updateQuery);
            logger.info("Stato della connessione al database: " + conn.isValid(5));

        } catch (SQLException e) {
            e.printStackTrace();
            logger.error("Errore nella modifica della tabella AUTORI: " + e.getMessage());
        }
    }

    @Override
    public List<Autori> trovaPerNomeAutore(String nome) {
        List<Autori> autoriList = new ArrayList<>();

        try (Connection connection = getConnection();
                PreparedStatement statement = connection.prepareStatement("SELECT * FROM autori WHERE nome LIKE ?")) {

            statement.setString(1, "%" + nome + "%");

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Autori autore = new Autori();
                    autore.setIdAutore(resultSet.getInt("idautore"));
                    autore.setNome(resultSet.getString("nome"));
                    autore.setCognome(resultSet.getString("cognome"));
                    autore.setNazionalita(resultSet.getString("nazionalita"));
                    autore.setDatadiNascita(resultSet.getDate("datanascita"));

                    autoriList.add(autore);
                }
            }

        } catch (SQLException e) {
            logger.error("Errore durante la ricerca degli autori per nome", e);
        }

        return autoriList;
    }

   @Override
public void addAutore(Connection conn, int idAutore, String Nome, String Cognome, String Nazionalita, Date DatadiNascita) {
    String insertQuery = "INSERT INTO AUTORI (IDAUTORE, NOME, COGNOME, NAZIONALITA, DATANASCITA) VALUES (?, ?, ?, ?, ?)";
    
    try (PreparedStatement pst = conn.prepareStatement(insertQuery)) {
        pst.setInt(1, idAutore);
        pst.setString(2, Nome);
        pst.setString(3, Cognome);
        pst.setString(4, Nazionalita);
        pst.setDate(5, new java.sql.Date(DatadiNascita.getTime()));

        pst.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
        logger.error("Errore nell'aggiunta dell'autore: " + e.getMessage());
    }
}


}
