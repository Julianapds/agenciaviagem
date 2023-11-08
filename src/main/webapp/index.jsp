<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Página inicial - Rotas do Sol</title>
  <link rel="icon" href="web/img/icone.ico" type="image/x-icon">
  <link rel="icon" href="../assets/img/logo.ico" type="image/x-icon">
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet">
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"></script>
  <script src="https://vlibras.gov.br/app/vlibras-plugin.js"></script>
</head>

<body>
  <div vw class="enabled">
    <div vw-access-button class="active"></div>
    <div vw-plugin-wrapper>
      <div class="vw-plugin-top-wrapper"></div>
    </div>
  </div>
  <script>
    new window.VLibras.Widget('https://vlibras.gov.br/app');
  </script>
  <header class="p-3">
    <div class="container">
      <div class="row align-items-center">
        <div class="col-md-6 d-flex">
          <button class="btn btn-outline-secondary mr-2">A+</button>
          <button class="btn btn-outline-secondary mr-2">A-</button>
          <button class="btn btn-outline-secondary">Contraste</button>
        </div>
        <div class="col-md-6 d-flex justify-content-end align-items-center">
          <a href="login.jsp" class="btn btn-outline-secondary mr-2">Login</a>
          <a href="cadastro.jsp" class="btn btn-success mr-2">Cadastre-se</a>
        </div>
      </div>
      <div class="row">
        <div class="col text-center">
          <img src="./web/img/logotipo.png" alt="Logo RotaRadiante" class="img-fluid" style="max-width: 100px;">
        </div>
      </div>
    </div>
  </header>

<body>
  <nav>
    <ul class="nav  d-flex justify-content-center shadow-sm bg-success">
      <li class="nav-item">
        <a class="nav-link active text-light font-weight-bold" href="index.html">início</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-light" href="ofertas.html">ofertas</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-light" href="pacotes.html">pacotes</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-light" href="contatos.html">contatos</a>
      </li>
      <li class="nav-item">
        <a class="nav-link text-light" href="minhas reservas.html">reservas</a>
        </li>
         <li class="nav-item">
              <a class="nav-link text-light" href="cadastro.jsp">cadastro</a>
            </li>
    </ul>
  </nav>
  <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel" data-interval="3000">
    <div class="carousel-inner">
      <div class="carousel-item active">
        <img src="web/img/penedo rjj.png" class="d-block w-100" alt="Penedo">
        <div class="carousel-caption d-none d-md-block">
          <h5>Penedo</h5>
          <p>Penedo é uma região e parque ecológico do município de Itatiaia, localizado na região sul do estado
            brasileiro do Rio de Janeiro. É a principal colônia finlandesa do Brasil.</p>
        </div>
      </div>
      <div class="carousel-item">
        <img src="web/img/guaratiba.png" class="d-block w-100" alt="Ilha de Guaratiba">
        <div class="carousel-caption d-none d-md-block">
          <h5>Ilha de Guaratiba</h5>
          <p>A Ilha de Guaratiba é um lugar tranquilo, bastante rural e lembra uma cidade de interior. A natureza tem
            levado muitos cariocas que buscam um estilo de vida mais calmo a buscar esse bairro.</p>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
  </div>
  <section class="background-home p-4">
    <h1 class="text-center mt-3 mb-3">Encontre seu próximo destino</h1>
    <form action="buscarTodos">
      <div class="row justify-content-center align-items-center " >
        <div class="form-group col-md-5">
          <input type="text" class="form-control" id="inputDestino" name="inputDestino" placeholder="Destino">
        </div>
      </div>
      </div>
      <div class="row justify-content-center mt-3 mb-3">
        <div class="form-group col-md-5 mt-2">
          <button type="submit" class="btn bg-success w-100 text-light">Buscar</button>
        </div>
      </div>
    </form>
    <jsp:include page="lista_destino.jsp" />
  </section>

  <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>


  <div class="p-4 bg-light mt-5 text-center">
    <h4>Inscreva-se para receber ofertas exclusivas</h4>
    <form class="d-flex flex-column align-items-center">
      <div class="form-group d-flex justify-content-center mt-3 col-lg-6 col-md-8 col-sm-12">
        <input type="text" class="form-control" id="inputemail" placeholder="Insira seu e-mail">
      </div>
      <button type="email" class="btn btn-outline-success w-25 mt-2">Quero recebê-las!</button>
    </form>
  </div>
  <div id="reviewsCarousel" class="carousel slide bg-info text-light p-3" data-ride="carousel" data-interval="3000">
    <div class="carousel-inner">
      <div class="carousel-item active">
        <div class="row justify-content-center">
          <div class="col-md-6 text-center">
            <img src="web/img/user1.jpg" alt="User 1" class="rounded-circle mb-3" style="width: 100px;">
            <h5>João Silva</h5>
            <p>"A viagem foi incrível! Tudo foi perfeitamente organizado e a equipe foi super atenciosa. Recomendo!"</p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="row justify-content-center">
          <div class="col-md-6 text-center">
            <img src="web/img/user2.jpg" alt="User 2" class="rounded-circle mb-3" style="width: 100px;">
            <h5>Maria Oliveira</h5>
            <p>"As acomodações eram confortáveis e os passeios eram divertidos. Uma experiência inesquecível!"</p>
          </div>
        </div>
      </div>
      <div class="carousel-item">
        <div class="row justify-content-center">
          <div class="col-md-6 text-center">
            <img src="web/img/user3.jpg" alt="User 3" class="rounded-circle mb-3" style="width: 100px;">
            <h5>Carlos Pereira</h5>
            <p>"Eu e minha família adoramos cada momento. A equipe fez um ótimo trabalho. Voltaremos em breve!"</p>
          </div>
        </div>
      </div>
    </div>
    <a class="carousel-control-prev" href="#reviewsCarousel" role="button" data-slide="prev">
      <span class="carousel-control-prev-icon" aria-hidden="true"></span>
      <span class="sr-only">Anterior</span>
    </a>
    <a class="carousel-control-next" href="#reviewsCarousel" role="button" data-slide="next">
      <span class="carousel-control-next-icon" aria-hidden="true"></span>
      <span class="sr-only">Próximo</span>
    </a>
  </div>
  <footer class="bg-dark text-white">
    <div class="container py-4">
      <div class="row">
        <div class="col-md-3">
          <h5>Sobre</h5>
          <p>Rotas do Sol</p>
          <p>Desenvolvido por Juliana Pires</p>
        </div>
        <div class="col-md-3">
          <h5>Contato</h5>
          <p>Email: reserveja.rotasdosol@gmail.com</p>
          <p>Telefone: (21)8752-8952</p>
        </div>
        <div class="col-md-3">
          <h5>Meios de Pagamento</h5>
          <img src="web/img/credito.jpg" alt="crédito">
          <img src="web/img/boleto.jpg" alt="boleto">
          <img src="web/img/cartao.jpg" alt="Pix">
        </div>
        <div class="col-md-3">
          <h5>Selos</h5>
          <img src="web/img/selo1.jpg" alt="pet friendly">
          <img src="web/img/selo2.jpg" alt="boleto">
        </div>
      </div>
    </div>
  </footer>
</html>
