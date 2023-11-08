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

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final ClienteRepositorio clienteRepositorio = new ClienteRepositorio();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String email = request.getParameter("email");
        String senha = request.getParameter("password");

        Cliente cliente = clienteRepositorio.autenticar(email);

        if (cliente != null && BCrypt.checkpw(senha, cliente.getSenhaHash())) {
            request.getSession().setAttribute("clienteLogado", cliente);
            response.sendRedirect(request.getContextPath() + "/dashboard.jsp");
        } else {
            request.setAttribute("errorMessage", "Credenciais inválidas. Tente novamente.");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}