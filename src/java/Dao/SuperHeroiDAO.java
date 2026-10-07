/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

/**
 *
 * @author kauan
 */
import Model.SuperHeroi;
import Util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SuperHeroiDAO implements GenericDAO<SuperHeroi> {

    @Override
    public void inserir(SuperHeroi heroi) throws SQLException {
        String sql = "INSERT INTO super_heroi "
                + "(nome, nome_real, poder, universo) "
                + "VALUES (?, ?, ?, ?)";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, heroi.getNome());
            stmt.setString(2, heroi.getNomeReal());
            stmt.setString(3, heroi.getPoder());
            stmt.setString(4, heroi.getUniverso());

            stmt.executeUpdate();
        }
    }

    @Override
    public void atualizar(SuperHeroi heroi) throws SQLException {
        String sql = "UPDATE super_heroi SET "
                + "nome = ?, nome_real = ?, poder = ?, universo = ? "
                + "WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, heroi.getNome());
            stmt.setString(2, heroi.getNomeReal());
            stmt.setString(3, heroi.getPoder());
            stmt.setString(4, heroi.getUniverso());
            stmt.setInt(5, heroi.getId());

            stmt.executeUpdate();
        }
    }

    @Override
    public void excluir(int id) throws SQLException {
        String sql = "DELETE FROM super_heroi WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }

    @Override
    public SuperHeroi buscarPorId(int id) throws SQLException {
        String sql = "SELECT * FROM super_heroi WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return criarSuperHeroi(rs);
                }
            }
        }

        return null;
    }

    @Override
    public List<SuperHeroi> listar() throws SQLException {
        String sql = "SELECT * FROM super_heroi ORDER BY id";

        List<SuperHeroi> herois = new ArrayList<>();

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                herois.add(criarSuperHeroi(rs));
            }
        }

        return herois;
    }

    private SuperHeroi criarSuperHeroi(ResultSet rs) throws SQLException {
        SuperHeroi heroi = new SuperHeroi();

        heroi.setId(rs.getInt("id"));
        heroi.setNome(rs.getString("nome"));
        heroi.setNomeReal(rs.getString("nome_real"));
        heroi.setPoder(rs.getString("poder"));
        heroi.setUniverso(rs.getString("universo"));

        return heroi;
    }
}