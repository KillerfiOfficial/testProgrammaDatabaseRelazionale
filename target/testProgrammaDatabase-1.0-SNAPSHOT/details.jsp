<%@page import="com.mycompany.testprogrammadatabase.RecuperoLibreria"%>
<%@page import="com.mycompany.testprogrammadatabase.Book"%>
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
                Book details = RecuperoLibreria.fetchBookById(bookId);
            %>

            <p><strong>Titolo:</strong> <%= details.getTitolo()%></p>
            <p><strong>Autore:</strong> <%= details.getAutore()%></p>
            <p><strong>Prezzo:</strong> <%= details.getPrezzo()%> euro</p>

            <a href="Libreria">
                <button>Torna alla libreria</button>
            </a>

            <a href="modifica.jsp?id=<%= details.getId()%>">
                <button>Modifica</button>
            </a>
        </div>
    </body>
</html>
