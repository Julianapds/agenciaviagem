package com.rotasdosol.model;

import database.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReservaRepositorio {
    public List<ReservaDetalhe> buscarReservasPorCliente(Integer idCliente) {
        List<ReservaDetalhe> reservas = new ArrayList<>();
        String sql = "SELECT " +
                "r.id_reserva, " +
                "CASE " +
                "WHEN p.id_pacote IS NOT NULL THEN 'Pacote' " +
                "WHEN h.id_hospedagem IS NOT NULL THEN 'Hospedagem' " +
                "WHEN v.id_voo IS NOT NULL THEN 'Voo' " +
                "END AS tipo, " +
                "d.nome AS destino, " +
                "COALESCE(h.nome_hotel, v.companhia_aerea) AS descricao, " +
                "s.nome AS status, " +
                "CONCAT(REPLACE(d.nome, ' ', '_'), '.png') AS imagem " +
                "FROM Reserva r " +
                "LEFT JOIN Pacote p ON r.id_pacote = p.id_pacote " +
                "LEFT JOIN Hospedagem h ON r.id_hospedagem = h.id_hospedagem OR p.id_hospedagem = h.id_hospedagem " +
                "LEFT JOIN Voo v ON r.id_voo = v.id_voo OR p.id_voo = v.id_voo " +
                "JOIN Destino d ON h.id_destino = d.id_destino OR v.id_destino = d.id_destino " +
                "JOIN StatusReserva s ON r.id_status = s.id_status " +
                "WHERE r.id_cliente = ? " +
                "ORDER BY destino, tipo";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            ResultSet resultSet = pstmt.executeQuery();

            while (resultSet.next()) {
                ReservaDetalhe reserva = new ReservaDetalhe();
                reserva.setId(resultSet.getInt("id_reserva"));
                reserva.setTipo(resultSet.getString("tipo"));
                reserva.setDescricao(resultSet.getString("descricao"));
                reserva.setDestino(resultSet.getString("destino"));
                reserva.setStatus(resultSet.getString("status"));
                reserva.setImagem(resultSet.getString("imagem"));
                reservas.add(reserva);
            }
        } catch (SQLException e) {
            e.printStackTrace(); //
        }

        return reservas;
    }
}

