<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="icon" href="web/img/icone.ico" type="image/x-icon">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container d-flex justify-content-center text-center mt-4">
        <form class="form-signin" method="post" action="${pageContext.request.contextPath}/login">
            <a href="<c:url value='/'/>"><img class="img-fluid w-50 mb-2" src="<c:url value='web/img/logotipo.png'/>" alt="Rota do sol"></a>
            <h1 class="h3 mb-3 font-weight-normal">Faça login</h1>
            <label for="inputEmail" class="sr-only mb-3">Endereço de email</label>
            <input type="email" id="inputEmail" name="email" class="form-control mb-3" placeholder="Seu email" required autofocus>
            <label for="inputPassword" class="sr-only mb-2">Senha</label>
            <input type="password" id="inputPassword" name="password" class="form-control mb-2" placeholder="Senha" required>
            <button class="btn btn-lg btn-success btn-block w-100 mt-2 mb-3" type="submit">Entrar</button>

            <div class="row p-0">
                <a href="<c:url value='/cadastro.jsp'/>">Cadastra-se</a>
                <a href="<c:url value='/recuperacao-senha.jsp'/>">Esqueci minha senha</a>
            </div>
            <p class="mt-5 mb-3 text-muted">© 2023-2023</p>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
