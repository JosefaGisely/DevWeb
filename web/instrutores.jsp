<%--
  Created by IntelliJ IDEA.
  User: Gisely Barbosa
  Date: 12/02/2020
  Time: 14:47
  To change this template use File | Settings | File Templates.
--%>
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
                        <li><a href="index.jsp">HOME</a></li>
                        <li><a href="sobre.jsp">SOBRE</a></li>
                        <li><a href="comentarios.jsp">COMENTÁRIOS</a></li>
                        <li class="active"><a href="instrutores.jsp">INSTRUTORES</a></li>
                        <li><a href="login.jsp">LOGIN</a></li>
                        <li><a href="registros.jsp">REGISTRO</a></li>
                        <li><a href="tabela.jsp">TABELAS</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>
</header>

<section id="topo-instrutores">
    <div class="transparencia-fundo">
        <div class="col-md-12 tituloindex">
            <h1>Conheça nossos instrutores</h1>
            <h2><q>Com nossos instrutores você irá conquistar o mercado de trabalho.</q></h2>
        </div>
    </div>
</section>

<section id="apresentacao">
    <div class="row col-md-12 allRow">
        <div class="col-md-6 InfoIns" style="padding-bottom: 80px">
            <div class="card" style="width: 18rem;">
                <img alt="..." class="card-img-top" src="img/manComentario.png" style="width:100%">
                <div class="card-body">
                    <h5 class="card-title">Instrutor 1</h5>
                    <p class="card-text">Ninguém sabe como o instrutor é porém, é sempre prestigiado por seu alunos.</p>
                </div>
            </div>
        </div>
        <div class="col-md-6 InfoIns" style="padding-bottom: 80px">
            <div class="card" style="width: 18rem;">
                <img alt="..." class="card-img-top" src="img/boy.png" style="width:100%">
                <div class="card-body">
                    <h5 class="card-title">Instrutor 2</h5>
                    <p class="card-text">Esse instrutor também possui anonimato entretanto, contém grande carísma.</p>
                </div>
            </div>
        </div>
    </div>
    <div class="linha"></div>
</section>
<section id="footer">
    <div id="icones">
        <div id="copyright">
            <div class="copyright">
                <p>© Design: <spam style="color: rgba(255, 255, 255, 0.7)">Nicolas Atmatzides</spam>. Images: <spam style="color: rgba(255, 255, 255, 0.7)">Google</spam></p>
            </div>
        </div>
    </div>
</section>

<script src="https://unpkg.com/@popperjs/core@2.0.0"></script>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/bootstrap.bundle.js"></script>
<script src="js/bootstrap.js"></script>

</body>
</html>
