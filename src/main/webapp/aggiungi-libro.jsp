<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Aggiungi libro</title>
    </head>
    <body>
        <form method="post" action="/testProgrammaDatabase/addLibro">

            <label for="idAutore">ID Autore</label>
            <input type="number" id="idAutore" name="idAutore"><br>

            <label for="isbn">ISBN</label>
            <input type="number" id="isbn" name="isbn"><br>

            <label for="titolo">Titolo</label>
            <input type="text" id="titolo" name="titolo"><br>

            <label for="casaeditrice">Casa Editrice</label>
            <input type="text" id="casaeditrice" name="casaeditrice"><br>

            <label for="numeroPagine">Numero Pagine</label>
            <input type="number" id="numeroPagine" name="numeroPagine"><br>

            <label for="lingua">Lingua</label>
            <input type="text" id="lingua" name="lingua"><br>

            <label for="genere">Genere</label>
            <input type="text" id="genere" name="genere"><br>

            <label for="prezzo">Prezzo</label>
            <input type="number" id="prezzo" name="prezzo"><br>

            <button type="submit">Aggiungi libro</button>
        </form>
    </body>
</html>
