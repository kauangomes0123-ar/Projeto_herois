<%-- 
    Document   : editar.jsp
    Created on : 6 de out. de 2026
    Author     : kauan
--%>

<%@page import="Model.SuperHeroi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Super-Herói</title>
         <link rel="stylesheet" href="style.css">
    </head>
    <body>
        <h1>Editar Super-Herói</h1>

        <%
            SuperHeroi heroi =
                    (SuperHeroi) request.getAttribute("heroi");
        %>

        <% if (heroi != null) { %>

        <form action="SuperHeroiController" method="post">

            <input type="hidden" name="id" value="<%= heroi.getId() %>">

            <label>Nome:</label>
            <input type="text" name="nome"
                   value="<%= heroi.getNome() %>" required>
            <br><br>

            <label>Nome Real:</label>
            <input type="text" name="nomeReal"
                   value="<%= heroi.getNomeReal() %>">
            <br><br>

            <label>Poder:</label>
            <input type="text" name="poder"
                   value="<%= heroi.getPoder() %>" required>
            <br><br>

            <label>Universo:</label>
            <input type="text" name="universo"
                   value="<%= heroi.getUniverso() %>" required>
            <br><br>

            <input type="hidden" name="acao" value="atualizar">

            <input type="submit" value="Atualizar">

        </form>

        <% } else { %>

            <p>Super-herói não encontrado.</p>

        <% } %>

        <br>

        <a href="SuperHeroiController?acao=listar">
            Voltar para a lista
        </a>

    </body>
</html>