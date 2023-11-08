package com.rotasdosol.controller;

import com.rotasdosol.model.Cliente;
import com.rotasdosol.model.ClienteRepositorio;
import org.mindrot.jbcrypt.BCrypt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cadastro_cliente")
public class CadastroClienteServlet extends HttpServlet {

    private static final String CADASTRO_JSP = "cadastro.jsp";
    private final ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = req.getParameter("email");
        String cpf = req.getParameter("cpf");
        String telefone = req.getParameter("telefone");
        String endereco = req.getParameter("endereco");
        String senha = req.getParameter("senha");

        if (existeCampoVazio(email, cpf, telefone, endereco, senha)) {
            retornarErro(req, resp, "Todos os campos são obrigatórios.");
            return;
        }

        if (!validarCPF(cpf)) {
            retornarErro(req, resp, "CPF inválido.");
            return;
        }

        if (clienteRepositorio.cpfExiste(cpf)) {
            retornarErro(req, resp, "CPF já cadastrado.");
            return;
        }

        String senhaHash = BCrypt.hashpw(senha, BCrypt.gensalt());
        Cliente cliente = criarCliente(cpf, email, endereco, telefone, senhaHash);

        try {
            clienteRepositorio.criar(cliente);
            req.getSession().setAttribute("mensagemSucesso", "Cliente cadastrado com sucesso!");
            resp.sendRedirect(CADASTRO_JSP);
        } catch (Exception e) {
            retornarErro(req, resp, "Erro ao cadastrar cliente: " + e.getMessage());
        }
    }

    private Cliente criarCliente(String cpf, String email, String endereco, String telefone, String senhaHash) {
        Cliente cliente = new Cliente();
        cliente.setCpf(cpf);
        cliente.setEmail(email);
        cliente.setEndereco(endereco);
        cliente.setTelefone(telefone);
        cliente.setSenhaHash(senhaHash);
        return cliente;
    }

    private boolean existeCampoVazio(String... campos) {
        for (String campo : campos) {
            if (campo == null || campo.trim().isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private boolean validarCPF(String cpf) {
        return cpf.matches("\\d{11}");
    }

    private void retornarErro(HttpServletRequest req, HttpServletResponse resp, String errorMessage) throws ServletException, IOException {
        req.setAttribute("mensagemErro", errorMessage);
        req.getRequestDispatcher(CADASTRO_JSP).forward(req, resp);
    }
}
