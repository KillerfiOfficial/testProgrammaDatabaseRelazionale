<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.testprogrammadatabase.Libreria" %>

<html>
    <head>
        <title>Libreria</title>
    </head>
    <body>
        <h1>Libreria</h1>

        <form method="get" action="/testProgrammaDatabase/libreria">
            <label for="search">Ricerca per ISBN:</label>
            <input type="text" id="search" name="search" value="${searchTerm}">
            <button type="submit">Cerca</button>
        </form>

        <table border="1">
            <thead>
                <tr>
                    <th></th>
                    <th>ID</th>
                    <th>ISBN</th>
                    <th>ID Autore</th>
                    <th>Scaffale</th>
                    <th>Quantità</th>
                    <th>Venduti</th>
                    <th>Classifica</th>
                    <th>Recensione</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Libreria> listaLibri = (List<Libreria>) request.getAttribute("books");
                    List<Libreria> displayList = (listaLibri != null && !listaLibri.isEmpty()) ? (List<Libreria>) listaLibri : new ArrayList<Libreria>();

                    if (!displayList.isEmpty()) {
                        for (Libreria book : displayList) {
                %>
                <tr>
                    <td><input type="checkbox" name="selectedBooks" value="<%= book.getId()%>"></td>
                    <td><%= book.getId()%></td>
                    <td><a href="details.jsp?id=<%= book.getId()%>"><%= book.getIsbn()%></a></td>
                    <td><%= book.getIdAutore()%></td>
                    <td><%= book.getScaffale()%></td>
                    <td><%= book.getQuantita()%></td>
                    <td><%= book.getVenduti()%></td>
                    <td><%= book.getClassifica()%></td>
                    <td><%= book.getRecensione()%></td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>

        <%
        } else {
        %>
        <p>Nessun libro trovato!</p>
        <%
            }
        %>

        <a href="add.jsp">
            <button type="button">Aggiungi libro</button>
        </a>
    </body>
</html>
