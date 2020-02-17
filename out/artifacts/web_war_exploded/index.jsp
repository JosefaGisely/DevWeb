<%-- Created by IntelliJ IDEA. --%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head><meta charset="UTF-8">
  <title>Cursos do Lero Lero</title>
  <meta name="description" content="Cursos do Lero Lero">
  <meta name="keywords" content="desenvolva, Lero Lero">
  <meta name="robots" content="INDEX, FOLLOW">
  <meta name="robots" content="INDEX, FOLLOW">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="author" content="Natmmatzides">

  <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
  <link rel="stylesheet" type="text/css" href="css/bootstrap-reboot.css">
  <link rel="stylesheet" type="text/css" href="css/style.css">

  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login</title>
  <link rel="stylesheet" href="css/style.css">
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css"
        integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
</head>
<body>
<header>  <div id="barraMenu">
  <nav class="navbar navbar-default navbar-static-top">
    <div class="container-fluid">
      <div class="navbar-right">
        <input type="checkbox" id="navicon">
        <label class="botaoMenu" for="navicon"></label>
        <div class="menu">
          <h2>Menu</h2>
          <ul>
            <li class="active"><a href="index.jsp">HOME</a></li>
            <li><a href="sobre.jsp">SOBRE</a></li>
            <li><a href="comentarios.jsp">COMENTÁRIOS</a></li>
            <li><a href="instrutores.jsp">INSTRUTORES</a></li>
            <li><a href="login.jsp">LOGIN</a></li>
            <li><a href="registros.jsp">REGISTRO</a></li>
            <li><a href="tabela.jsp">TABELAS</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div>
      <h2>Login</h2>
      <ul>
        <div class="navicon">
          <a class="btn btn-outline-light my-2 my-sm-0" href="login.jsp">Entrar</a>
          <a class="btn btn-outline-light my-2 my-sm-0" href="registros.jsp">Cadastrar</a>
        </div>
      </ul>
    </div>
  </nav>
</div>
</header>



<section id="topo">
  <div class="transparencia-fundo ">
    <div class="col-md-12 tituloindex">
      <h1>Desenvolva suas habilidades</h1>
      <h2><q>Ter sucesso é falhar repetidamente, mas sem perder o entusiasmo</q></h2>
      <h5>- Winston Churchill</h5>
    </div>
  </div>
</section>
<section id="apresentacao">
  <div class="row allRow">
    <div class="col-md-4 InfoIndex">
      <div class="card" style="width: 18rem;">
        <img src="img/F100011097.jpg" class="card-img-top" alt="Ciência da Computação">
        <div class="card-body">
          <h5 class="card-title">Ciência da Computação</h5>
          <a href="sobre.jsp" class="btn btn-primary">Saiba mais</a>
        </div>
      </div>
    </div>
    <div class="col-md-4  InfoIndex">
      <div class="card" style="width: 18rem;">
        <img src="img/F100010649.jpg" class="card-img-top" alt="Sistemas de Informação">
        <div class="card-body">
          <h5 class="card-title">Sistemas de Informação</h5>
          <a href="sobre.jsp" class="btn btn-primary">Saiba mais</a>
        </div>
      </div>
    </div>
    <div class="col-md-4 InfoIndex">
      <div class="card" style="width: 18rem;">
        <img src="img/F100010643.jpg" class="card-img-top" alt="Tecnologia de Sistemas de Computação">
        <div class="card-body">
          <h5 class="card-title">Tecnologia em Sistemas de Computação</h5>
          <a href="sobre.jsp" class="btn btn-primary">Saiba mais</a>
        </div>
      </div>
    </div>
  </div>
  <div class="linha"></div>
</section>
<div id="footer">
  <div id="icones">
    <div id="copyright">
      <div class="copyright">
        <p>© Design: <spam style="color: rgba(255, 255, 255, 0.7)">Nicolas Atmatzides</spam>. Images: <spam style="color: rgba(255, 255, 255, 0.7)">Google</spam></p>
      </div>
    </div>
  </div>
</div>
<script src="https://unpkg.com/@popperjs/core@2.0.0"></script>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.bundle.js"></script>
</body>
</html>