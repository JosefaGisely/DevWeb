<%--
  Created by IntelliJ IDEA.
  User: Gisely Barbosa
  Date: 15/02/2020
  Time: 13:14
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

    <link rel = " stylesheet "  href = " css/bootstrap.css "  type = " text/css " >
    <link rel = " stylesheet "  href = " css/bootstrap-reboot.css "  type = " text/css " >
    <link rel = " stylesheet "  href = " css/style.css "  type = " text/css " >

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
                        <li><a href="instrutores.jsp">INSTRUTORES</a></li>
                        <li class="active"><a href="login.jsp">LOGIN</a></li>
                        <li><a href="registros.jsp">REGISTRO</a></li>
                        <li><a href="tabelas.jsp">TABELAS</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>
</header>

<!-- inicio do conteudo da pagina - login -->
<div class="col-md-12 tituloindex h5">
    <div id="principal">
        <!-- formulario -->
        <div class="formCad">
            <h1>LOGIN</h1>
            <p>Digite seus dados!</p>
            <br>
            <form action="login.jsp" method="POST">
                <div class="pt1Rec">
                    <p>Login:</p>
                    <input type="email" name="login" required>
                    <p>Insira a Senha:</p>
                    <input type="password" name="senha" required>

                    <div class="botoes">
                        <a><input id="cancelarRec" type="button" name="cancelar" value="cancelar"></a>
                        <a href="index.jsp"><input id="cadastrarRec" type="submit" name="enviar" value="Conectar"></a>
                    </div>
                </div>
            </form>
        </div>

        <!-- validaçao do formulario -->
        <script type="text/javascript">
            function validar_form_contato(){
                var email= formcontato.email.value;
                var senha= formcontato.senha.value;

                if(email === "" || email.indexOf('@')=== -1 || nome.length < 4 || endereco.length > 50){
                    alert("Campo E-mail obrigatório")
                    formcontato.email.focus();
                    return false;
                }

                if(senha === "" || senha.length < 3){
                    alert("Campo Senha é obrigatório, preencha o campo senha com o mínimo de 6 caracteres")
                    formcontato.senha.focus();
                    return false;
                }
                if(senha.length < 5 || senha.length > 255){
                    alert("Preencha o campo senha com o mínimo de 6 caracteres!")
                    formcontato.senha.focus();
                    return false;
                }
            }
        </script>


        <script src="https://unpkg.com/@popperjs/core@2.0.0"></script>
        <script src= "js/jquery-1.11.0.min.js"></script>
        <script src= "js/bootstrap.js"></script>
        <script src= "js/bootstrap.bundle.js"></script>
</body>
</html>
