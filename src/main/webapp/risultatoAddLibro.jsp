<%@page import="java.util.List"%>
<%@page import="com.mycompany.testprogrammadatabase.Libri"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esito Inserimento Libro</title>
    </head>
    <body>
        <h1>Esito Inserimento Libro</h1>

        <%
            List<Libri> addedBook = (List<Libri>) request.getAttribute("addedBook");
            if (addedBook != null && !addedBook.isEmpty()) {
                for (Libri libro : addedBook) {
        %>
        <ul>
            <li>Id Autore <%= libro.getIdAutore()%></li>
            <li>ISBN: <%= libro.getISBN()%></li><br>
            <li>Titolo: <%= libro.getTitolo() %></li><br>
            <li>Casa Editrice: <%= libro.getCasaEditrice()%></li><br>
            <li>Numero Pagine: <%= libro.getNumeroPagine() %></li><br>
            <li>Lingua: <%= libro.getLingua() %></li><br>
            <li>Genere: <%= libro.getGenere() %></li><br>
            <li>Prezzo: <%= libro.getPrezzo() %></li><br>
        </ul>
        <%
                }
            } else {
        %>
        <p>Nessun record inserito nel database, perché devi prima inserire l'autore, il libro e infine la libreria.</p>
        <%
            }
        %>
        <a href="index.jsp">
            <button>Torna alla Home</button>
        </a>
    </body>
</html>
