<%@page import="com.mycompany.testprogrammadatabase.Autori"%>
<%@page import="com.mycompany.testprogrammadatabase.AutoriDAODB"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Modifica Autore</title>
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
            AutoriDAODB autoriDAODB = new AutoriDAODB();
            String idAutoreStr = request.getParameter("id");
            int idAutore = Integer.parseInt(idAutoreStr);
            Autori autori = autoriDAODB.trovaPerIdAutore(idAutore);
        %>

        <h1>Pagina per modificare l'autore #<%= autori.getIdAutore()%></h1>

        <form method="post" action="EditServletAutori">
            <input type="hidden" id="autoreIdOld" name="autoreIdOld" value="<%= autori.getIdAutore()%>">

            <label for="newId">Nuovo Id:</label>
            <input type="text" id="autoreIdNew" name="autoreIdNew" value=""><br>

            <label for="newNome">Nuovo Nome:</label>
            <input type="text" id="newNome" name="newNome" value="<%= autori.getNome()%>" required><br>

            <label for="newCognome">Nuovo Cognome:</label>
            <input type="text" id="newCognome" name="newCognome" value="<%= autori.getCognome()%>" required><br>

            <label for="newNazionalita">Nuova Nazionalità:</label>
            <input type="text" id="newNazionalita" name="newNazionalita" value="<%= autori.getNazionalita()%>" required><br>

            <label for="newDataNascita">Nuova Data di Nascita:</label>
            <input type="date" id="newDataNascita" name="newDataNascita" value="<%= autori.getDatadiNascita()%>" required><br>

            <button type="submit">Salva Modifiche</button>
        </form>

    </body>
</html>