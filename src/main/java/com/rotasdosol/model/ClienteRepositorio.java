package com.rotasdosol.model;

import database.Database;
import database.Repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class ClienteRepositorio implements Repositorio<Cliente> {


    @Override
    public void criar(Cliente cliente) {
        String sql = "INSERT INTO Cliente (email, cpf, telefone, endereco, senha) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, cliente.getEmail());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setString(5, cliente.getSenhaHash());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        cliente.setIdCliente(generatedKeys.getInt(1));
                    }
                }
            }

            out.println("Cliente criado com sucesso.");
        } catch (SQLException e) {
            out.println("Erro ao criar cliente." + e.getMessage());
        }
    }

    @Override
    public List<Cliente> listar(String nome) {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM cliente;";
        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            ResultSet resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));

                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
                clientes.add(cliente);
            }


            out.println("Clientes consultados com sucesso.");
        } catch (SQLException e) {
            out.println("Erro ao consultar clientes." + e.getMessage());
        }
        return clientes;

    }

    @Override
    public Cliente atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET email = ?, cpf = ?, telefone = ?, endereco = ? WHERE id_cliente = ?;";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cliente.getEmail());
            pstmt.setString(2, cliente.getCpf());
            pstmt.setString(3, cliente.getTelefone());
            pstmt.setString(4, cliente.getEndereco());
            pstmt.setInt(5, cliente.getIdCliente());

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                out.println("Cliente atualizado com sucesso.");
                return cliente;
            }
        } catch (SQLException e) {
            out.println("Erro ao atualizar cliente. " + e.getMessage());
        }
        return null;
    }

    @Override
    public void deletar(Integer id) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?;";

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                out.println("Cliente deletado com sucesso.");
            }
        } catch (SQLException e) {
            out.println("Erro ao deletar cliente. " + e.getMessage());
        }
    }


    public Cliente buscarPorCpf(String cpf) {
        String sql = "SELECT * FROM cliente WHERE cpf = ?;";
        Cliente cliente = null;

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cpf);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
                out.println("Cliente encontrado com sucesso.");
            } else {
                out.println("Cliente não encontrado para o CPF fornecido.");
            }

        } catch (SQLException e) {
            out.println("Erro ao buscar cliente por CPF. " + e.getMessage());
        }

        return cliente;
    }

    public Cliente buscarPorId(Integer idCliente) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?;";
        Cliente cliente = null;

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, idCliente);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
                out.println("Cliente encontrado com sucesso.");
            } else {
                out.println("Cliente não encontrado para o ID fornecido.");
            }

        } catch (SQLException e) {
            out.println("Erro ao buscar cliente por ID. " + e.getMessage());
        }

        return cliente;
    }

    public boolean cpfExiste(String cpf) {

        String sql = "SELECT * FROM cliente WHERE cpf = ?;";

        Cliente cliente = null;

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, cpf);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                return true;
            }

        } catch (SQLException e) {
            out.println("Erro ao buscar cliente por CPF. " + e.getMessage());
        }

        return false;
    }

    public Cliente autenticar(String email) {
        String sql = "SELECT * FROM cliente WHERE email = ?;";
        Cliente cliente = null;

        try (Connection conn = Database.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet resultSet = pstmt.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente();
                cliente.setIdCliente(resultSet.getInt("id_cliente"));
                cliente.setCpf(resultSet.getString("cpf"));
                cliente.setEmail(resultSet.getString("email"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setSenhaHash(resultSet.getString("senha"));
                out.println("Cliente encontrado com sucesso.");
            } else {
                out.println("Cliente não encontrado.");
            }

        } catch (SQLException e) {
            out.println("Erro ao buscar cliente. " + e.getMessage());
        }

        return cliente;
    }
}