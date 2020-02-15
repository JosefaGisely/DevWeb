package controler;

import model.Usuario;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioServlet usuariodao = new UsuarioServlet();
        Usuario usuario = new Usuario();
        usuario.setNomeCompleto(request.getParameter("nomeCompleto"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setSenha(request.getParameter("senha"));

        if (usuariodao.inserir(usuario)){
            requestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
            Usuario u = usuario.buscar(request.getParameter("cpf"));
            request.setAttribute("usuario", u);
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("erro_registro.jsp");
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

