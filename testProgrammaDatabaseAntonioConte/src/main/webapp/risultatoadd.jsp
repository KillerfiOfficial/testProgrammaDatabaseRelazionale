<%@page import="com.mycompany.testprogrammadatabase.Libreria"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esito Inserimento Libro</title>
    </head>
    <body>
        <h1>Esito Inserimento Libro</h1>

        <%
            String message = (String) request.getAttribute("message");
            Integer rowCount = (Integer) request.getAttribute("rowCount");

            if (message != null && !message.isEmpty()) {
        %>
        <p><%= message%></p>
        <%
            }

            if (rowCount != null) {
                Libreria addedBook = (Libreria) request.getAttribute("addedBook");
        %>
        <ul>
            <li>Id: <%= addedBook.getId()%></li>
            <li>Hai inserito il libro con l'isbn: <%= addedBook.getIsbn()%></li><br>
            <li>L'id dell'autore è: <%= addedBook.getIdAutore()%></li><br>
            <li>Lo scaffale è: <%= addedBook.getScaffale()%> euro</li>
            <li>La quantità è: <%= addedBook.getQuantita()%></li>
            <li>Venduti: <%= addedBook.getVenduti()%></li>
            <li>Classifica: <%= addedBook.getClassifica()%></li>
            <li>Recensione: <%= addedBook.getRecensione()%></li>
        </ul>
        <%
        } else {
        %>
        <p>Nessun record inserito nel database, perchè devi prima inserire il libro in Autori, Libri e infine Libreria.</p>
        <%
            }
        %>
        <a href="Libreria">
            <button>Torna alla Libreria</button>
        </a>
    </body>
</html>
