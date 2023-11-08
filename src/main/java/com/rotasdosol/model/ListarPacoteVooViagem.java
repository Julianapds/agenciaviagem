package com.rotasdosol.model;

import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ListarPacoteVooViagem {

    public static List<Item> listarPacoteVooViagem(String nomeDestino) {


        String sql = "SELECT h.id_hospedagem AS id, d.nome AS destino, h.nome_hotel AS descricao, 'Hospedagem' AS tipo, CONCAT(REPLACE(d.nome, ' ', '_'), '.png') AS imagem " +
                "FROM Hospedagem h JOIN Destino d ON h.id_destino = d.id_destino WHERE d.nome LIKE ? " +
                "UNION " +
                "SELECT v.id_voo AS id, d.nome, v.companhia_aerea, 'Voo', CONCAT(REPLACE(d.nome, ' ', '_'), '.png') AS imagem " +
                "FROM Voo v JOIN Destino d ON v.id_destino = d.id_destino WHERE d.nome LIKE ? " +
                "UNION " +
                "SELECT p.id_pacote AS id, d.nome, CONCAT('Pacote: ', p.id_pacote), 'Pacote', CONCAT(REPLACE(d.nome, ' ', '_'), '.png') AS imagem " +
                "FROM Pacote p JOIN Hospedagem h ON p.id_hospedagem = h.id_hospedagem JOIN Voo v ON p.id_voo = v.id_voo JOIN Destino d ON h.id_destino = d.id_destino WHERE d.nome LIKE ? " +
                "ORDER BY destino, tipo";

        List<Item> itens = new ArrayList<>();

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Definindo os parâmetros para o PreparedStatement
            pstmt.setString(1, "%" + nomeDestino + "%");
            pstmt.setString(2, "%" + nomeDestino + "%");
            pstmt.setString(3, "%" + nomeDestino + "%");

            // Executando a consulta e obtendo o ResultSet
            try (ResultSet resultSet = pstmt.executeQuery()) {
                while (resultSet.next()) {
                    Item item = new Item();
                    item.setId(resultSet.getInt("id"));
                    item.setTitulo(resultSet.getString("destino"));
                    item.setDescricao(resultSet.getString("descricao"));
                    item.setTipo(resultSet.getString("tipo"));
                    item.setImagem(resultSet.getString("imagem"));
                    itens.add(item);
                }
            }

            System.out.println("Itens consultados com sucesso.");

        } catch (SQLException e) {
            System.out.println("Erro ao listar itens por nome destino" + e.getMessage());
        }

        return itens;
    }
}
