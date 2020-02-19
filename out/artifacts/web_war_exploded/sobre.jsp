<%--
  Created by IntelliJ IDEA.
  User: Gisely Barbosa
  Date: 05/02/2020
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
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
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
                        <li class="active"><a href="sobre.jsp"></a>SOBRE</li>
                        <li><a href="comentarios.jsp">COMENTÁRIOS</a></li>
                        <li><a href="instrutores.jsp">INSTRUTORES</a></li>
                        <li><a href="login.jsp">LOGIN</a></li>
                        <li><a href="registros.jsp">REGISTRO</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>



</header>
<section id="topoSobre">
    <div class="transparencia-fundo-sobre">
        <div class="col-md-12 sobreIndex">
            <h1>Sobre nós</h1>
            <h2><q>Como surgiu o curso lero lero?</q></h2>
            <p>Nossa história começou há duas semanas motivada pelo professor Leonardo Cruz, que acreditou em nossa capacidade de desenvolver.</p>
            <div class="row col-md-12 Sobrerow">
                <div class="col-md-6">
                    <div class="card" style="width: 18rem;">
                        <img alt="..." class="card-img-top" src="img/boy.png" style="width:100%">
                        <div class="card-body">
                            <h5 class="card-title">Nicolas</h5>
                            <p class="card-text">Aluno de Sistemas de Informação.</p>
                        </div>
                    </div>
                </div>
                <div class="col-md-6 Sobrerow">
                    <div class="card" style="width: 18rem;">
                        <img alt="..." class="card-img-top" src="img/woman.png" style="width:100%">
                        <div class="card-body">
                            <h5 class="card-title">Gisely</h5>
                            <p class="card-text">Aluna de Sistemas de Informação.</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<div class="accordion" id="accordionExample">
    <div class="card">
        <div class="card-header one" id="headingOne">
            <h2 class="mb-0">
                <button class="btn btn-link" type="button" data-toggle="collapse" data-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                    Ciência da Computação
                </button>
            </h2>
        </div>

        <div id="collapseOne" class="collapse show" aria-labelledby="headingOne" data-parent="#accordionExample">
            <div class="card-body">
                O curso tem como objetivo  formar profissionais que tenham uma forte base científica e tecnológica, capaz de
                prover a autonomia necessária para o aprendizado de novas tecnologias. Os egressos deverão ser capazes de atuar no mercado de trabalho,
                continuar seus estudos em programas de pós-graduação e/ou gerir suas próprias empresas.

                E é fundamental que atuem de forma ética e sejam comprometidos com as questões sociais da realidade nacional.
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingTwo">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                    Sistemas de Informação
                </button>
            </h2>
        </div>
        <div id="collapseTwo" class="collapse" aria-labelledby="headingTwo" data-parent="#accordionExample">
            <div class="card-body">
                O mercado de atuação para um formando do curso de Sistemas de Informação engloba empresas públicas e privadas,d
                de âmbito nacional e internacional, que atuam em diferentes segmentos de mercado, visto que na atualidade as áreas do conhecimento, em sua grande maioria,
                dependem da computação como meio para a sua existência.
            </div>
        </div>
    </div>
    <div class="card">
        <div class="card-header" id="headingThree">
            <h2 class="mb-0">
                <button class="btn btn-link collapsed" type="button" data-toggle="collapse" data-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
                    Tecnologia em Sistemas de Computação
                </button>
            </h2>
        </div>
        <div id="collapseThree" class="collapse" aria-labelledby="headingThree" data-parent="#accordionExample">
            <div class="card-body">
                O Curso Superior de Tecnologia em Sistemas de Computação à distância tem como objetivo formar profissionais
                com competência para realizar, entre outras tarefas, instalação, configuração, manutenção e gerenciamento de redes; construção, desenvolvimento e manutenção de sites na web; instalação de sistemas operacionais; instalação
                e manutenção de banco de dados; montagem e instalação de computadores; desenvolvimento de programas e interfaces.
            </div>
        </div>
    </div>
</div>
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
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.bundle.js"></script>
</body>
</html>

