<%@ page import="java.util.List" %>
<%@ page import="com.rotasdosol.model.Voo" %>
<%@ page import="com.rotasdosol.model.Hospedagem" %>
<%@ page import="com.rotasdosol.model.Pacote" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Criar Reserva</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">
            <img src="./web/img/logotipo.png" alt="Logotipo" style="height: 30px;">
        </a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link" href="perfil.jsp">Meu Perfil</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="dashboard.jsp">Minhas Reservas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="logout">Sair</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <h1>Criar Reserva</h1>
    <%-- Mensagem de sucesso ou erro --%>
    <%
    String successMessage = (String) request.getAttribute("successMessage");
    String errorMessage = (String) request.getAttribute("errorMessage");
    if (successMessage != null) {
    %>
        <div class="alert alert-success" role="alert">
            <%= successMessage %>
        </div>
    <%
    }
    if (errorMessage != null) {
    %>
        <div class="alert alert-danger" role="alert">
            <%= errorMessage %>
        </div>
    <%
    }
    %>

    <%-- Lista de Voos, Hospedagens e Pacotes --%>
    <div class="row">
        <%-- Exemplo de como listar voos --%>
        <%-- Substitua com a lista real de voos, hospedagens e pacotes --%>
        <%
        List<Voo> voos = new ArrayList<>(); // Obtenha a lista real de voos aqui
        for (Voo voo : voos) {
        %>
        <div class="col-md-4">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title"><%= voo.getCompanhiaAerea() %></h5>
                    <p class="card-text">Partida: <%= voo.getDataPartida() %></p>
                    <p class="card-text">Chegada: <%= voo.getDataChegada() %></p>
                    <p class="card-text">Preço: <%= voo.getValorPreco() %></p>
                    <form action="reservar" method="post">
                        <input type="hidden" name="tipo" value="voo" />
                        <input type="hidden" name="id" value="<%= voo.getIdVoo() %>" />
                        <button type="submit" class="btn btn-primary">Reservar</button>
                    </form>
                </div>
            </div>
        </div>
        <% } %>
        <%-- Repita para hospedagens e pacotes --%>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>