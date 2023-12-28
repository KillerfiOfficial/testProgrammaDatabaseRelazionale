<%@page import="com.mycompany.testprogrammadatabase.RecuperoLibreria"%>
<%@page import="com.mycompany.testprogrammadatabase.Libreria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina dettaglio</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }

            h1 {
                color: #333;
            }

            p {
                margin-bottom: 10px;
            }

        </style>
    </head>
    <body>
        <div>
            <h1>Dettagli del libro</h1>

            <%
                String bookIdParam = request.getParameter("id");
                int bookId = Integer.parseInt(bookIdParam);
                Libreria details = RecuperoLibreria.fetchBookById(bookId);
            %>

            <p><strong>ISBN:</strong> <%= details.getIsbn()%></p>
            <p><strong>Recensione:</strong> <%= details.getRecensione()%></p>
            <p><strong>Classifica:</strong> <%= details.getClassifica()%></p>
            <p><strong>Id:</strong> <%= details.getId()%></p>
            <p><strong>Id Autore:</strong><%= details.getIdAutore()%></p>
            <p><strong>Quantità:</strong><%= details.getQuantita()%></p>
            <p><strong>Scaffale:<%= details.getScaffale()%></strong></p>
            <p><strong>Venduti:<%= details.getVenduti()%></strong></p>
            <a href="index.jsp">
                <button>Torna alla Home</button>
            </a>

            <a href="modifica.jsp?id=<%= details.getId()%>">
                <button>Modifica</button>
            </a>
        </div>
    </body>
</html>
