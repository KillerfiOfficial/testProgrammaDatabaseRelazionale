<%@page import="java.util.List"%>
<%@page import="com.mycompany.testprogrammadatabase.Libri"%>
<%@page import="com.mycompany.testprogrammadatabase.LibriDAODB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica Libro</title>
        <style>
            body {
                font-family: Arial, sans-serif;
                margin: 20px;
            }

            h1 {
                color: #333;
            }

            form {
                max-width: 400px;
                margin: 0 auto;
            }

            label {
                display: block;
                margin-bottom: 5px;
            }

            input {
                width: 100%;
                padding: 8px;
                margin-bottom: 10px;
                box-sizing: border-box;
            }

            button {
                background-color: #4CAF50;
                color: white;
                padding: 10px 15px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }

            button:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>

        <%
            LibriDAODB libriDAODB = new LibriDAODB();
            String titolo = request.getParameter("titolo");
            List<Libri> libri = libriDAODB.trovaPerTitolo(titolo);
            for (Libri libro : libri) {
        %>

        <h1>Pagina per modificare il libro <strong><%= libro.getTitolo()%></strong></h1>

        <form method="post" action="EditServletLibri">
            <input type="hidden" id="isbn" name="isbn" value="<%= libro.getISBN()%>">
            <input type="hidden" id="idautore" name="idautore" value="<%= libro.getIdAutore()%>">

            <label for="newTitolo">Nuovo Titolo:</label>
            <input type="text" id="newTitolo" name="newTitolo" value="<%= libro.getTitolo()%>" required><br>

            <label for="newCasaEditrice">Nuova casa editrice:</label>
            <input type="text" id="newCasaEditrice" name="newCasaEditrice" value="<%= libro.getCasaEditrice()%>" required><br>

            <label for="newNumeroPagine">Nuovo numero di pagine:</label>
            <input type="number" id="newNumeroPagine" name="newNumeroPagine" value="<%= libro.getNumeroPagine()%>" required><br>

            <label for="newLingua">Nuova Lingua:</label>
            <input type="text" id="newLingua" name="newLingua" value="<%= libro.getLingua()%>" required><br>
            
            <label for="newGenere">Nuovo Genere:</label>
            <input type="text" id="newGenere" name="newGenere" value="<%= libro.getGenere()%>" required><br>
            
            <label for="newPrezzo">Nuovo Prezzo:</label>
            <input type="number" id="newPrezzo" name="newPrezzo" value="<%= libro.getPrezzo()%>" required><br>

            <button type="submit">Salva Modifiche</button>
        </form>
        <%
            }
        %>

    </body>
</html>
