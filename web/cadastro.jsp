<%-- 
    Document   : cadastro.jsp
    Created on : 6 de out. de 2026, 22:29:09
    Author     : kauan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cadastro de Super-Herói</title>
    </head>
    <body>
        <h1>Cadastro de Super-Herói</h1>

        <form action="SuperHeroiController" method="post">

            <label>Nome:</label>
            <input type="text" name="nome" required>
            <br><br>

            <label>Nome Real:</label>
            <input type="text" name="nomeReal">
            <br><br>

            <label>Poder:</label>
            <input type="text" name="poder" required>
            <br><br>

            <label>Universo:</label>
            <input type="text" name="universo" required>
            <br><br>

            <input type="hidden" name="acao" value="cadastrar">

            <input type="submit" value="Cadastrar">

        </form>
    </body>
</html>