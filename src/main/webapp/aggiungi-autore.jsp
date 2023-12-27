<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aggiungi autore</title>
    </head>
    <body>
        <form method="post" action="/testProgrammaDatabase/addAutore">

            <label for="idAutore">ID Autore</label>
            <input type="number" id="idAutore" name="idAutore"><br>

            <label for="nome">Nome</label>
            <input type="text" id="nome" name="nome"><br>

            <label for="cognome">Cognome</label>
            <input type="text" id="cognome" name="cognome"><br>

            <label for="nazionalita">Nazionalità</label>
            <input type="text" id="nazionalita" name="nazionalita"><br>

            <label for="dataNascita">Data di Nascita</label>
            <input type="date" id="dataNascita" name="dataNascita"><br>

            <button type="submit">Aggiungi autore</button>
        </form>
    </body>
</html>
