<%@page import="com.mycompany.testprogrammadatabase.RecuperoLibreria"%>
<%@page import="com.mycompany.testprogrammadatabase.Libreria"%>
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
            Libreria edit = RecuperoLibreria.fetchBookById(bookId);
        %>
        <h1>Modifica del libro: <%= edit.getIsbn()%></h1>
        <form action="EditServlet" method="post">
            <input type="hidden" name="id" value="<%= bookId%>">
            <input type="hidden" name="isbn" value="<%= edit.getIsbn()%>">
            <input type="hidden" name="idAutore" value="<%= edit.getIdAutore()%>">

            <label for="newScaffale">Nuovo Scaffale:</label>
            <input type="number" id="newScaffale" name="newScaffale" value="<%= edit.getScaffale()%>"><br>

            <label for="newQuantita">Nuova Quantità:</label>
            <input type="number" id="newQuantita" name="newQuantita" value="<%= edit.getQuantita()%>"><br>

            <label for="newVenduti">Nuovi Venduti:</label>
            <input type="number" id="newVenduti" name="newVenduti" value="<%= edit.getVenduti()%>"><br>

            <label for="newClassifica">Scegli Nuova Classifica:</label>
            <input type="number" id="newClassifica" name="newClassifica" value="<%= edit.getClassifica()%>"> <br>


            <label for="newRecensione">Nuova Recensione:</label>
            <textarea id="newRecensione" name="newRecensione"><%= edit.getRecensione()%></textarea><br>

            <button type="submit">Salva Modifiche</button><br>
        </form><br>
        <a href="index.jsp">
            <button>Torna alla Home</button>
        </a>
    </body>
</html>
