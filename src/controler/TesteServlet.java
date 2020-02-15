package controler;
import dao.UsuarioDao;
import model.Usuario;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "testeServlet", urlPatterns = {"/Login"})
public class TesteServlet extends HttpSession{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session!null){
            session.invalidate();
        }
        response.sendRedirect("index.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String login = (String)request.getParameter("login");
        String senha = (String)request.getParameter("senha");
        UsuarioDao usuariodao;
        Usuario usuario;
        usuariodao = new UsuarioDao();
        usuario = usuario.validar(login,senha);

        if (usuario!null){
            HttpSession session = request.getSession();
            session.setAttribute("coontaLogada", usuario.getConta());
            session.setAttribute("loginStatus", Usuario.logado);
            RequestDispatcher dispatcher = request.getRequestDispatcher("logado.jsp");
            request.setAttribute("ALUNO", Usuario.getNomeCompleto());
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("erro_login.jsp");
        }
    }
}
