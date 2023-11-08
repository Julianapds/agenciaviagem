<%@ page import="java.util.List" %>
<%@ page import="com.rotasdosol.model.ReservaDetalhe" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard - Minhas Reservas</title>
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
                    <a class="nav-link active" aria-current="page" href="dashboard.jsp">Minhas Reservas</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="login.jsp">Sair</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container mt-4">
    <div class="d-flex justify-content-between align-items-center">
        <h1>Minhas Reservas</h1>
        <p>Aqui você pode gerenciar suas reservas adquiridas em nossa agência.</p>
        <a href="criar_reserva.jsp" class="btn btn-primary">Nova Reserva</a>
    </div>

    <div class="row mt-4">
        <%
        List<ReservaDetalhe> reservas = (List<ReservaDetalhe>) request.getAttribute("reservas");
        if (reservas != null && !reservas.isEmpty()) {
            for (ReservaDetalhe reserva : reservas) {
        %>
            <!-- Conteúdo da reserva -->
        <%
            }
        } else {
        %>
            <div class="alert alert-info" role="alert">
                Você ainda não possui reservas.
            </div>
        <%
        }
        %>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
