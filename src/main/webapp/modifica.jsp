<%-- 
    Document   : modifica
    Created on : 19-dic-2023, 9.44.13
    Author     : 39351
--%>

<%@page import="com.mycompany.testprogrammadatabase.RecuperoLibreria"%>
<%@page import="com.mycompany.testprogrammadatabase.Book"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina modifica</title>
    </head>
    <body>
        <%
            String bookIdParam = request.getParameter("id");
            int bookId = Integer.parseInt(bookIdParam);
            Book edit = RecuperoLibreria.fetchBookById(bookId);
        %>
        <h1>Hai scelto di modificare il seguente libro: <%= edit.getTitolo()%>!</h1>
        <form action="EditServlet" method="post">
            <input type="hidden" name="id" value="<%= bookId %>">
            
            <label for="newTitle">Scegli Nuovo Titolo:</label>
            <input type="text" id="newTitle" name="newTitle"> <br>

            <label for="newAuthor">Scegli Nuovo Autore:</label>
            <input type="text" id="newAuthor" name="newAuthor"> <br>

            <label for="newPrice">Scegli Nuovo Prezzo:</label>
            <input type="number" id="newPrice" name="newPrice"> <br>

            <button type="submit">Salva Modifiche</button> <br>
        </form> <br>
        <a href="Libreria">
            <button>Torna alla libreria</button>
        </a>
    </body>
</html>
