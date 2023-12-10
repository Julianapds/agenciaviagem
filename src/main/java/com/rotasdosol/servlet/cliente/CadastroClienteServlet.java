package com.rotasdosol.servlet.cliente;

import com.rotasdosol.dao.ClienteDAO;
import com.rotasdosol.model.ClienteModel;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/cadastro_cliente")
public class CadastroClienteServlet extends HttpServlet {

    private ClienteDAO clienteDAO;

    public void init() {
        clienteDAO = new ClienteDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String cpf = request.getParameter("cpf");
        String telefone = request.getParameter("telefone");
        String endereco = request.getParameter("endereco");
        String senha = request.getParameter("senha");

        String senhaHash = algumMetodoParaCriarHashDaSenha(senha);

        if (!clienteDAO.existePorCpf(cpf)) {
            ClienteModel cliente = new ClienteModel();
            cliente.setEmail(email);
            cliente.setCpf(cpf);
            cliente.setTelefone(telefone);
            cliente.setEndereco(endereco);
            cliente.setSenhaHash(senhaHash);

            clienteDAO.salvar(cliente);

            request.getSession().setAttribute("mensagemSucesso", "Cliente cadastrado com sucesso!");
            response.sendRedirect("login.jsp");

        } else {

            request.setAttribute("mensagemErro", "Já existe um cliente cadastrado com este CPF.");
            request.getRequestDispatcher("/WEB-INF/views/cadastro.jsp").forward(request, response);
        }
    }

    private String algumMetodoParaCriarHashDaSenha(String senha) {
        return senha;
    }
}