package com.rotasdosol.controller;

import com.rotasdosol.model.Item;
import com.rotasdosol.model.ListarPacoteVooViagem;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/buscarTodos")
public class BuscarPacoteVooViagemServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String destino = request.getParameter("inputDestino");
        List<Item> itens = ListarPacoteVooViagem.listarPacoteVooViagem(destino);

        request.setAttribute("itens", itens);

        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");

        dispatcher.forward(request, response);
    }
}

