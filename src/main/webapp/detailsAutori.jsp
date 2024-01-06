<%-- 
    Document   : detailsAutori
    Created on : 29-dic-2023, 13.14.15
    Author     : 39351
--%>
<%@page import="com.mycompany.testprogrammadatabase.Autori"%>
<%@page import="com.mycompany.testprogrammadatabase.AutoriDAODB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dettagli dell'autore</title>
    </head>
    <body>
        <h1>Dettagli dell'autore</h1>

        <%
            AutoriDAODB autoriDAODB = new AutoriDAODB();
            String idAutoreStr = request.getParameter("id");
            int idAutore = Integer.parseInt(idAutoreStr);
            Autori autori = autoriDAODB.trovaPerIdAutore(idAutore);
        %>

        <table>
            <tr>
                <td><strong>ID Autore:</strong></td>
                <td><%= autori.getIdAutore()%></td>
            </tr>
            <tr>
                <td><strong>Nome:</strong></td>
                <td><%= autori.getNome()%></td>
            </tr>
            <tr>
                <td><strong>Cognome:</strong></td>
                <td><%= autori.getCognome()%></td>
            </tr>
            <tr>
                <td><strong>Nazionalità:</strong></td>
                <td><%= autori.getNazionalita()%></td>
            </tr>
            <tr>
                <td><strong>Data di nascita:</strong></td>
                <td><%= autori.getDatadiNascita()%></td>
            </tr>
        </table>

        <a href="index.jsp">
            <button>Torna alla Home</button>
        </a>

        <a href="modificaAutori.jsp?id=<%= autori.getIdAutore()%>">
            <button>Modifica</button>
        </a>

    </body>
</html>
