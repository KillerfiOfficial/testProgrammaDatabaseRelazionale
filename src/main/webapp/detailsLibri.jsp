
<%@page import="java.util.List"%>
<%@page import="com.mycompany.testprogrammadatabase.Libri"%>
<%@page import="com.mycompany.testprogrammadatabase.LibriDAODB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dettagli del libro</title>
    </head>
    <body>
        <h1>Dettagli del libro</h1>

        <%
            LibriDAODB libriDAODB = new LibriDAODB();
            String titolo = request.getParameter("titolo");
            List<Libri> libri = libriDAODB.trovaPerTitolo(titolo);
            for (Libri libro : libri) {
        %>

        <table>
            <tr>
                <td><strong>Titolo:</strong></td>
                <td><%= libro.getTitolo()%></td>
            </tr>
            <tr>
                <td><strong>Casa Editrice:</strong></td>
                <td><%= libro.getCasaEditrice()%></td>
            </tr>
            <tr>
                <td><strong>Genere</strong></td>
                <td><%= libro.getGenere()%></td>
            </tr>
            <tr>
                <td><strong>Lingua</strong></td>
                <td><%= libro.getLingua()%></td>
            </tr>
            <tr>
                <td><strong>ISBN:</strong></td>
                <td><%= libro.getISBN()%></td>
            </tr>
            <tr>
                <td><strong>Id autore:</strong></td>
                <td><%= libro.getIdAutore()%></td>
            </tr>
            <tr>
                <td><strong>Numero pagine:</strong></td>
                <td><%= libro.getNumeroPagine()%></td>
            </tr>
            <tr>
                <td><strong>Prezzo:</strong></td>
                <td><%= libro.getPrezzo()%></td>
            </tr>
        </table>


        <a href="index.jsp">
            <button>Torna alla Home</button>
        </a>

        <a href="modificaLibri.jsp?titolo=<%= libro.getTitolo()%>">
            <button>Modifica</button>
        </a>

        <%
            }
        %>

    </body>
</html>
