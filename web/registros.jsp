<%--
  Created by IntelliJ IDEA.
  User: Gisely Barbosa
  Date: 12/02/2020
  Time: 14:48
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
                        <li><a href="instrutores.jsp">INSTRUTORES</a></li>
                        <li><a href="login.jsp">LOGIN</a></li>
                        <li class="active"><a href="registros.jsp">REGISTRO</a></li>
                        <li><a href="tabela.jsp">TABELAS</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </nav>
</div>
</header>

<!-- inicio do conteudo da pagina - login -->
<div class="container-fluid Registro">

    <!-- formulario -->
    <div class="formCad">
        <h1>REGISTRE-SE</h1>
        <p>Digite seus dados para se registrar no Cursos Lero Lero</p>
        <br>
        <form name="formcontato" method="post">
            <div class="pt1">
                <p>Nome completo:</p>
                <input id="nomeCompleto" name="nomeCompleto" type="text" required>
                <p>CPF:</p>
                <input id="cpf" name="cpf" type="number" placeholder="000.000.000-00" required>
                <p>Celular:</p>
                <input id="celular" name="celular" type="tel" placeholder="00000-0000" required>
                <p>Cep:</p>
                <input id="cep" name="cep" type="number" placeholder="00000-000" required>
                <p>Endereço:</p>
                <input id="endereco" name="endereco" type="text" required>
                <p>Bairro:</p>
                <input id="Neighbor" name="bairro" type="text" required>
            </div>

            <div class="pt2">
                <p>Email:</p>
                <input id="email" name="email" type="email" required>
                <p>Login:</p>
                <input id="login" name="apelido" type="text" required>
                <p>Senha:</p>
                <input id="Password" name="senha" type="password" required>
                <p>Confirmação de senha:</p>
                <input id="PasswordConfirma"  name="confSenha" type="password" required>
                <p>Cidade:</p>
                <input id="City" name="cidade" type="text" max="30" required>


            </div>
            <a><input id="cancelar" type="button" name="cancelar" value="Cancelar"></a>
            <input id="cadastrar" type="submit" name="enviar" value="Cadastrar" onclick="return validar_form_contato()">
        </form>

    </div>

</div>

<script src="https://unpkg.com/@popperjs/core@2.0.0"></script>
<script src="js/jquery-1.11.0.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/bootstrap.bundle.js"></script>

<!-- validaçao do formulario -->
<script type="text/javascript">
    function validar_form_contato(){
        var nome= formcontato.nomeCompleto.value;
        var cpf= formcontato.cpf.value;
        var celular= formcontato.celular.value;
        var cep= formcontato.cep.value;
        var endereco= formcontato.endereco.value;
        var email= formcontato.email.value;
        var apelido= formcontato.apelido.value;
        var senha= formcontato.senha.value;
        var confSenha= formcontato.confSenha.value;
        var cidade= formcontato.cidade.value;
        var bairro= formcontato.bairro.value;

        if( nome==="" || nome.length < 4 || nome.length > 50){
            alert("Campo nome é obrigatório");
            formcontato.nome.focus();
            return false;
        }
        if(cpf==="" || cpf.length < 4 || cpf.length > 10 ){
            alert("Campo CPF é obrigatório");
            formcontato.cpf.focus();
            return false;
        }
        if(celular==="" || celular.length < 4 || celular.length > 14){
            alert("Campo celular é obrigatório")
            formcontato.celular.focus();
            return false;
        }
        if(cep==="" || cep.length < 4 || cep.length > 9){
            alert("Campo Cep é obrigatório");
            formcontato.cep.focus();
            return false;
        }
        if(endereco==="" || endereco.length < 4 || endereco.length > 50){
            alert("Campo Endereco é obrigatório");
            formcontato.endereco.focus();
            return false;
        }
        if(email==="" || email.indexOf('@')=== -1 || nome.length < 4 || endereco.length > 50){
            alert("Campo E-mail obrigatório");
            formcontato.email.focus();
            return false;
        }
        if(apelido==="" || apelido.length < 4 || apelido.length > 20){
            alert("Campo Login é obrigatório");
            formcontato.apelido.focus();
            return false;
        }
        if(senha==="" || senha.length < 3){
            alert("Campo Senha é obrigatório, preencha o campo senha com o mínimo de 6 caracteres")
            formcontato.senha.focus();
            return false;
        }
        if(5 > senha.length || senha.length > 255){
            alert("Preencha o campo senha com o mínimo de 6 caracteres!")
            formcontato.senha.focus();
            return false;
        }

        if(confSenha==="" || confSenha.length < 4 || confSenha.length > 255){
            alert("Campo Confirmação de senha é obrigatório");
            formcontato.confSenha.focus();
            return false;
        }
        if(senha!==confSenha) {
            alert("As Senha são diferentes, preencha o campo senha e Confirmação de senhas iguais!")
            formcontato.senha.focus();
            return false;
        }
        if(cidade==="" || cidade.length < 4 || cidade.length > 30){
            alert("Campo Cidade é obrigatório");
            formcontato.cidade.focus();
            return false;
        }
        if(bairro==="" || bairro.length < 4 || bairro.length > 30){
            alert("Campo bairro é obrigatório");
            formcontato.bairro.focus();
            return false;
        }

    }
</script>
</body>
</html>