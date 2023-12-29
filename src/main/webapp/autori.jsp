<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.mycompany.testprogrammadatabase.Autori" %>

<html>
    <head>
        <title>Pagina Autori</title>
    </head>
    <body>
        <h1>Autori</h1>

        <form method="get" action="/testProgrammaDatabase/autori">
            <label for="searchAutori">Ricerca per Nome:</label>
            <input type="text" id="searchAutori" name="searchAutori" value="<%= request.getAttribute("searchKeyword")%>">
            <button type="submit">Cerca</button>
        </form>

        <form method="post" action="DeleteBookServlet">
            <table border="1">
                <thead>
                    <tr>
                        <th></th>
                        <th>ID Autore</th>
                        <th>Nome</th>
                        <th>Cognome</th>
                        <th>Nazionalità</th>
                        <th>Data di Nascita</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                        List<Autori> autoriList = (List<Autori>) request.getAttribute("autoriList");
                        if (autoriList != null && !autoriList.isEmpty()) {
                            for (Autori autore : autoriList) {
                    %>
                    <tr>
                        <td><input type="checkbox" name="selectedAuthors" value="<%= autore.getIdAutore()%>"></td>
                        <td><a href="detailsAutori.jsp?id=<%= autore.getIdAutore()%>"><%= autore.getIdAutore()%></a></td>
                        <td><%= autore.getNome()%></td>
                        <td><%= autore.getCognome()%></td>
                        <td><%= autore.getNazionalita()%></td>
                        <td><%= autore.getDatadiNascita()%></td>
                    </tr>
                    <%
                        }
                    } else {
                    %>
                    <tr>
                        <td colspan="6">Nessun autore trovato!</td>
                    </tr>
                    <%
                        }
                    %>
                </tbody>
            </table>

            <input type="submit" value="Elimina" style="background-color: #FF0000; color: #FFFFFF;">
            <a href="aggiungi-autore.jsp">
                <button type="button">Aggiungi autore</button>
            </a>
        </form>
    </body>
</html>
