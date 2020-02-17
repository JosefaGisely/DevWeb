package controler;

import interfaces.AlunoDao;
import model.Aluno;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AlunoServlet", urlPatterns = {"/Registros"})
public class AlunoServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
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
            throws ServletException, IOException, SQLException {
        // Cria um novo usuário com os dados dos Form
        Aluno usuario = new Aluno(request.getParameter("nomeCompleto"),
                request.getParameter("apelido"),
                request.getParameter("email"),
                request.getParameter("senha"));

        // Cria um objeto de acesso ao BD
        AlunoDao usuarioDao = new AlunoDao();
    // Chama método para cadastrar usuário
        usuarioDao.inclui(usuario);

        request.getSession().setAttribute("usuarioLogado", usuario);
        getServletConfig().getServletContext().getRequestDispatcher("/feed.jsp").forward(request, response);
    }

    private void atualizaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
        if (request.getSession().getAttribute("usuarioLogado") == null){
            response.sendRedirect("home.jsp");
            return;
        } else{

            AlunoDao usuarioDAO = new AlunoDao();


            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date date = dateFormat.parse(request.getParameter("dataNascimento"));

            Aluno aluno = new Aluno(
                    request.getParameter("nomeCompleto"),
                    request.getParameter("login"),
                    request.getParameter("email"),
                    request.getParameter("senha"));
            aluno.setIdAluno(Integer.valueOf(request.getParameter("idAluno")));

            // Chama método para cadastrar usuário
            usuarioDAO.altera(aluno);

            request.getSession().setAttribute("usuarioLogado", aluno);
            response.sendRedirect("feed.jsp");
        }
    }

    private void alteraSenha(HttpServletRequest request, HttpServletResponse response)
            throws IOException, SQLException {
        AlunoDao alunoDao = new AlunoDao();

        // Recupera o usuario da session http
        Aluno aluno = alunoDao.buscaPorEmail(request.getParameter("email"));
        aluno.setSenha(request.getParameter("senha"));

        // Chama método para cadastrar usuário
        alunoDao.alteraSenha(aluno);

        response.sendRedirect("home.jsp");
    }

    private void fazLogin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        Aluno usuario = (new AlunoDao()).buscaLogin(
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
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(AlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(AlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
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



