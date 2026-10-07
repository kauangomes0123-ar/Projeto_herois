/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Dao;
/**
 *
 * @author kauan
 */


import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {

    void inserir(T objeto) throws SQLException;

    void atualizar(T objeto) throws SQLException;

    void excluir(int id) throws SQLException;

    T buscarPorId(int id) throws SQLException;

    List<T> listar() throws SQLException;
}