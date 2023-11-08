package com.rotasdosol.controller;

import com.rotasdosol.model.Cliente;
import com.rotasdosol.model.ReservaDetalhe;
import com.rotasdosol.model.ReservaRepositorio;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dashboard")
public class ReservaServlet extends HttpServlet {
    private ReservaRepositorio reservaRepositorio = new ReservaRepositorio();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Cliente clienteLogado = (Cliente) request.getSession().getAttribute("clienteLogado");

        if (clienteLogado != null) {

            Integer idCliente = clienteLogado.getIdCliente();

            List<ReservaDetalhe> reservas = reservaRepositorio.buscarReservasPorCliente(idCliente);

            request.setAttribute("reservas", reservas);
            request.getRequestDispatcher("/dashboard.jsp").forward(request, response);
        } else {

            response.sendRedirect("login.jsp");
        }
    }
}