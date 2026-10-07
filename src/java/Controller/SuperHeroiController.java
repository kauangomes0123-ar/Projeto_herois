package Controller;

import Dao.SuperHeroiDAO;
import Model.SuperHeroi;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name = "SuperHeroiController", urlPatterns = {"/SuperHeroiController"})
public class SuperHeroiController extends HttpServlet {

    private final SuperHeroiDAO dao = new SuperHeroiDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String acao = request.getParameter("acao");

        if (acao == null) {
            acao = "listar";
        }

        try {

            switch (acao) {

                case "listar":
                    listar(request, response);
                    break;

                case "editar":
                    mostrarEdicao(request, response);
                    break;

                case "excluir":
                    excluir(request, response);
                    break;

                default:
                    listar(request, response);
                    break;
            }

        } catch (SQLException e) {
            throw new ServletException("Erro ao acessar o banco de dados.", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String acao = request.getParameter("acao");

        try {

            if ("cadastrar".equals(acao)) {
                cadastrar(request, response);

            } else if ("atualizar".equals(acao)) {
                atualizar(request, response);

            } else {
                response.sendRedirect("SuperHeroiController?acao=listar");
            }

        } catch (SQLException e) {
            throw new ServletException("Erro ao acessar o banco de dados.", e);
        }
    }

    private void cadastrar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        String nome = request.getParameter("nome");
        String nomeReal = request.getParameter("nomeReal");
        String poder = request.getParameter("poder");
        String universo = request.getParameter("universo");

        SuperHeroi heroi = new SuperHeroi(
                nome,
                nomeReal,
                poder,
                universo
        );

        dao.inserir(heroi);

        response.sendRedirect("SuperHeroiController?acao=listar");
    }

    private void listar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        List<SuperHeroi> herois = dao.listar();

        request.setAttribute("herois", herois);

        request.getRequestDispatcher("lista.jsp")
                .forward(request, response);
    }

    private void mostrarEdicao(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        SuperHeroi heroi = dao.buscarPorId(id);

        request.setAttribute("heroi", heroi);

        request.getRequestDispatcher("editar.jsp")
                .forward(request, response);
    }

    private void atualizar(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        String nome = request.getParameter("nome");
        String nomeReal = request.getParameter("nomeReal");
        String poder = request.getParameter("poder");
        String universo = request.getParameter("universo");

        SuperHeroi heroi = new SuperHeroi(
                id,
                nome,
                nomeReal,
                poder,
                universo
        );

        dao.atualizar(heroi);

        response.sendRedirect("SuperHeroiController?acao=listar");
    }

    private void excluir(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {

        int id = Integer.parseInt(request.getParameter("id"));

        dao.excluir(id);

        response.sendRedirect("SuperHeroiController?acao=listar");
    }

    @Override
    public String getServletInfo() {
        return "Controller do sistema de Super-Heróis";
    }
}