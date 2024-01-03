<%@page import="com.mycompany.testprogrammadatabase.Autori"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Esito Inserimento Autore</title>
    </head>
    <body>
        <h1>Esito Inserimento Autore</h1>


        <%
            Autori addedAutore = (Autori) request.getAttribute("addedAutori");
            if (addedAutore != null) {
        %>
        <ul>
            <li>Id: <%= addedAutore.getIdAutore()%></li><br>
            <li>Hai inserito l'autore: <%= addedAutore.getNome()%></li><br>
            <li>Il cognome dell'autore è: <%= addedAutore.getCognome()%></li><br>
            <li>La nazionalità è: <%= addedAutore.getNazionalita()%></li><br>
            <li>La data di nascita è: <%= addedAutore.getDatadiNascita()%></li><br>
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
