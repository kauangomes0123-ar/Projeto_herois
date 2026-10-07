<%-- 
    Document   : lista.jsp
    Created on : 6 de out. de 2026, 22:32:32
    Author     : kauan
--%>

<%@page import="java.util.List"%>
<%@page import="Model.SuperHeroi"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Super-Heróis</title>
    </head>
    <body>
        <h1>Lista de Super-Heróis</h1>

        <a href="cadastro.jsp">Cadastrar Novo Super-Herói</a>

        <br><br>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nome</th>
                    <th>Nome Real</th>
                    <th>Poder</th>
                    <th>Universo</th>
                    <th>Ações</th>
                </tr>
            </thead>

            <tbody>
                <%
                    List<SuperHeroi> herois =
                            (List<SuperHeroi>) request.getAttribute("herois");

                    if (herois != null) {
                        for (SuperHeroi heroi : herois) {
                %>

                <tr>
                    <td><%= heroi.getId() %></td>
                    <td><%= heroi.getNome() %></td>
                    <td><%= heroi.getNomeReal() %></td>
                    <td><%= heroi.getPoder() %></td>
                    <td><%= heroi.getUniverso() %></td>

                    <td>
                        <a href="SuperHeroiController?acao=editar&id=<%= heroi.getId() %>">
                            Editar
                        </a>

                        <a href="SuperHeroiController?acao=excluir&id=<%= heroi.getId() %>">
                            Excluir
                        </a>
                    </td>
                </tr>

                <%
                        }
                    }
                %>
            </tbody>
        </table>

    </body>
</html>