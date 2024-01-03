<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aggiungi libro</title>
    </head>
    <body>
        <form method="post" action="/testProgrammaDatabase/add">

            <label for="isbn">ID</label>
            <input type="text" id="id" name="id"><br>

            <label for="isbn">ISBN</label>
            <input type="text" id="isbn" name="isbn"><br>

            <label for="idAutore">ID Autore</label>
            <input type="number" id="idAutore" name="idAutore"><br>

            <label for="scaffale">Scaffale</label>
            <input type="number" id="scaffale" name="scaffale"><br>

            <label for="quantita">Quantità</label>
            <input type="number" id="quantita" name="quantita"><br>

            <label for="venduti">Venduti</label>
            <input type="number" id="venduti" name="venduti"><br>

            <label for="classifica">Classifica</label>
            <input type="number" id="classifica" name="classifica"><br>

            <label for="recensione">Recensione</label>
            <input type="text" id="recensione" name="recensione"><br>

            <button type="submit">Aggiungi libro</button>
        </form>
    </body>
</html>
