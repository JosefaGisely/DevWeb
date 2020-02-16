package controler;

import dao.UsuarioDao;
import model.Usuario;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AlunoServlet", urlPatterns = {"/Registros"})
public class UsuarioServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        response.setContentType("text/html;charset=UTF-8");
        switch(Integer.parseInt(request.getParameter("operacao"))){
            case 0:
                criaUsuario(request, response);
                break;
            case 1:
//                listaUsuarios(request,response);
                break;
            case 2:
                atualizaUsuario(request, response);
//                listaUsuarios(request, response);
                break;
            case 3:
                trocaTela(request, response);
                break;
            case 4:
//                buscaUmUsuario(request, response);
                break;
            case 5:
                fazLogin(request, response);
                break;
            case 6:
                fazLogout(request, response);
                break;
            case 7:
                alteraSenha(request, response);
                break;
            default:
                break;
        }
    }

    private void criaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        // Cria um novo usuário com os dados dos Form
        Usuario usuario = new Usuario(request.getParameter("nomeCompleto"),
                request.getParameter("apelido"),
                request.getParameter("email"),
                request.getParameter("senha"));

        // Cria um objeto de acesso ao BD
        UsuarioDao usuarioDao = new UsuarioDao();
    // Chama método para cadastrar usuário
        usuarioDao.inclui(usuario);

        request.getSession().setAttribute("usuarioLogado", usuario);
        getServletConfig().getServletContext().getRequestDispatcher("/feed.jsp").forward(request, response);
    }

    private void atualizaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException{
        if (request.getSession().getAttribute("usuarioLogado") == null){
            response.sendRedirect("home.jsp");
            return;
        } else{

            UsuarioDao usuarioDAO = new UsuarioDao();


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(request.getParameter("dataNascimento"));

            Usuario usuario = new Usuario(
                    request.getParameter("nomeCompleto"),
                    request.getParameter("apelido"),
                    request.getParameter("email"),
                    request.getParameter("senha"));
            usuario.setIdUsuario(Integer.valueOf(request.getParameter("idUsuario")));

            // Chama método para cadastrar usuário
            usuarioDAO.altera(usuario);

            request.getSession().setAttribute("usuarioLogado", usuario);
            response.sendRedirect("feed.jsp");
        }
    }

    private void alteraSenha(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        UsuarioDao usuarioDAO = new UsuarioDao();

        // Recupera o usuario da session http
        Usuario usuario = usuarioDao.buscaPorEmail(request.getParameter("email"));
        usuario.setSenha(request.getParameter("senha"));

        // Chama método para cadastrar usuário
        usuarioDAO.alteraSenha(usuario);

        response.sendRedirect("home.jsp");
    }

    private void fazLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario = (new UsuarioDao()).buscaLogin(
                request.getParameter("email"),
                request.getParameter("senha")
        );

        if (usuario !=  null){
            HttpSession httpSession = request.getSession();
            // Salva na session
            httpSession.setAttribute("usuarioLogado", usuario);
            // Redireciona
            getServletConfig().getServletContext().getRequestDispatcher("/PublicacaoServlet?operacao=4").forward(request, response);
        } else{
            response.sendRedirect("home.jsp");
        }
    }

    private void fazLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getSession().invalidate();
        response.sendRedirect("home.jsp");
    }

    private void trocaTela(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if (request.getSession().getAttribute("usuarioLogado") == null){
            response.sendRedirect("home.jsp");
            return;
        } else{
            response.sendRedirect("conta.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
















/*




































































@WebServlet(name = "UsuarioServlet", urlPatterns = {"/Usuario"})
public class UsuarioServlet extends HttpServlet {




































    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario usuario= new Usuario();
        UsuarioDao usuarioDao = new UsuarioDao();
        usuario.setNomeCompleto(request.getParameter("nomeCompleto"));
        usuario.setLogin(request.getParameter("login"));
        usuario.setCpf(request.getParameter("cpf"));
        usuario.setSenha(request.getParameter("senha"));

        if (usuariodao.inclui(usuario)){
            RequestDispatcher dispatcher = request.getRequestDispatcher("usuario.jsp");
            Usuario u = usuariodao.busca(request.getParameter("cpf"));
            request.setAttribute("usuario", u);
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("erro_registro.jsp");
        }
    }
}

*/