package controler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"Login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String urlDestino = "index.jsp";
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        try {
            if (verificaSeAluno(login, senha)) {
                Integer id = getIdAluno(login, senha);
                session.setAttribute("tipoSession", "aluno");
                session.setAttribute("logado", "OK");
                session.setAttribute("id", id);
                urlDestino = "acesso-restrito/aluno/painel-aluno";
            } else if (verificaSeAdm(login, senha)) {
                Integer id = getIdAdm(login, senha);
                session.setAttribute("tipoSession", "adm");
                session.setAttribute("logado", "OK");
                session.setAttribute("id", id);
                urlDestino = "acesso-restrito/admin/painel-admin";
            } else if (verificaSeInstrutor(login, senha)) {
                Integer id = getIdInstrutor(login, senha);
                session.setAttribute("tipoSession", "instrutor");
                session.setAttribute("logado", "OK");
                session.setAttribute("id", id);
                urlDestino = "acesso-restrito/instrutor/painel-instrutor";
            } else {
                session.setAttribute("tipoSession", "intruso");
            }
            processRequest(request, response, urlDestino);
        } catch (Exception ex) {
            System.out.println("Erro nao esperado ao verificar login de usuario: " + ex.getMessage());
            processRequest(request, response, urlDestino);
        }
    }

    private boolean verificaSeInstrutor(String login, String senha) {
    }

    private boolean verificaSeAdm(String login, String senha) {
    }

    


//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//        String login = (String)request.getParameter("login");
//        String senha = (String)request.getParameter("senha");
//        UsuarioDao udao;
//        Usuario usuario;
//        udao = new UsuarioDao();
//        usuario = udao.validar(login,senha);
//
//        if(usuario!=null){
//            HttpSession session = request.getSession();
//            session.setAttribute("loginStatus", Usuario.LOGADO);
//            RequestDispatcher dispatcher = request.getRequestDispatcher("logado.jsp");
//            request.setAttribute("cliente", usuario.getNomeCompleto());
//            dispatcher.forward(request, response);
//        }else{
//            response.sendRedirect("login.jsp");
//        }
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        HttpSession session = request.getSession(false);
//        if(session!=null){
//            session.invalidate();
//        }
//        response.sendRedirect("index.jsp");
//    }
//
//}