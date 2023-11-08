<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.rotasdosol.model.Item" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Resultados da Busca</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container mt-4">
  <div class="row row-cols-1 row-cols-md-3 g-4 justify-content-center align-items-stretch">
    <%
      List<Item> itens = (List<Item>) request.getAttribute("itens");
      if (itens != null && !itens.isEmpty()) {
        for (Item item : itens) {
    %>
    <div class="col">
      <div class="card h-100">
        <!-- Badge para o tipo -->
        <div class="card-header">
          <span class="badge bg-primary"><%= item.getTipo() %></span>
        </div>
        <img src="./web/img/<%= item.getImagem() %>" class="card-img-top" alt="<%= item.getTitulo() %>">
        <div class="card-body">
          <h5 class="card-title"><%= item.getTitulo() %></h5>
          <p class="card-text"><%= item.getDescricao() %></p>
        </div>
        <!-- Footer removido, pois o tipo já está no header -->
      </div>
    </div>
    <%
        }
      } else {
    %>
      <div class="alert alert-warning w-100 text-center" role="alert">
        Nenhuma oferta encontrada para o destino selecionado.
      </div>
    <%
      }
    %>
  </div>
</div>


<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
