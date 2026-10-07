package Util;

import java.sql.Connection;

public class TesteConexao {

    public static void main(String[] args) {

        try {
            Connection conexao = ConnectionFactory.getConnection();

            System.out.println("Conexao com PostgreSQL realizada com sucesso!");

            conexao.close();

        } catch (Exception e) {
            System.out.println("Erro ao conectar com o banco:");
            e.printStackTrace();
        }
    }
}