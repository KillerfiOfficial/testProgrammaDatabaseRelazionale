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
                Libreria addedBook = (Libreria) request.getAttribute("addedBook");
                if(addedBook != null) {
        %>
        <ul>
            <li>Id: <%= addedBook.getId()%></li><br>
            <li>Hai inserito il libro con l'isbn: <%= addedBook.getIsbn()%></li><br>
            <li>L'id dell'autore è: <%= addedBook.getIdAutore()%></li><br>
            <li>Lo scaffale è: <%= addedBook.getScaffale()%></li><br>
            <li>La quantità è: <%= addedBook.getQuantita()%></li><br>
            <li>Venduti: <%= addedBook.getVenduti()%></li><br>
            <li>Classifica: <%= addedBook.getClassifica()%></li><br>
            <li>Recensione: <%= addedBook.getRecensione()%></li><br>
        </ul>
        <%
        } else {
        %>
        <p>Nessun record inserito nel database, perchè devi prima inserire il libro in Autori, Libri e infine Libreria.</p>
        <%
            }
        %>
        <a href="index.jsp">
            <button>Torna alla Home</button>
        </a>
    </body>
</html>
