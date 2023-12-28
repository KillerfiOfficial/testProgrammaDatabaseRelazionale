<%@page import="com.mycompany.testprogrammadatabase.Libri"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.testprogrammadatabase.Autori" %>

<html>
    <head>
        <title>Pagina Libri</title>
    </head>
    <body>
        <h1>Libri</h1>

        <form method="get" action="/testProgrammaDatabase/libri">
            <label for="searchLibri">Ricerca per Titolo:</label>
            <input type="text" id="searchLibri" name="searchLibri" value="<%= request.getAttribute("searchKeyword")%>">
            <button type="submit">Cerca</button>
        </form>

            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th>ISBN</th>
                        <th>Titolo</th>
                        <th>Casa editrice</th>
                        <th>Id Autore</th>
                        <th>Numero di pagine</th>
                        <th>Lingua</th>
                        <th>Genere</th>
                        <th>Prezzo</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Libri> libriList = (List<Libri>) request.getAttribute("libriList");
                        if (libriList != null && !libriList.isEmpty()) {
                            for (Libri libro : libriList) {
                    %>
                    <tr>
                        <td><input type="checkbox" name="selectedLibri" value="<%= libro.getIdAutore()%>"></td>
                        <td><%= libro.getISBN()%></td>
                        <td><%= libro.getTitolo()%></td>
                        <td><%= libro.getCasaEditrice()%></td>
                        <td><%= libro.getIdAutore()%></td>
                        <td><%= libro.getNumeroPagine()%></td>
                        <td><%= libro.getLingua()%></td>
                        <td><%= libro.getGenere()%></td>
                        <td><%= libro.getPrezzo()%></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="6">Nessun libro trovato!</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <a href="aggiungi-libro.jsp">
                <button type="button">Aggiungi libro</button>
            </a>
    </body>
</html>
