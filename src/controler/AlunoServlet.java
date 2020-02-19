package controler;

import interfaces.AlunoDao;
import model.Aluno;

import javax.servlet.RequestDispatcher;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "AlunoServlet", urlPatterns = {"/Registros"})
public class AlunoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AlunoDao alunodao = new AlunoDao();
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto(request.getParameter("nome"));
        aluno.setLogin(request.getParameter("login"));
        aluno.setCpf(request.getParameter("cpf"));
        aluno.setSenha(request.getParameter("senha"));

        if (aluno.inserir(aluno)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("aluno.jsp");
            Aluno a = alunodao.buscar(request.getParameter("cpf"));
            request.setAttribute("aluno", a);
            dispatcher.forward(request, response);
        }else{
            response.sendRedirect("erro_cadastro.jsp");
        }

    }

}





    }


    /*

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            AlunoDao dao = new AlunoDao();

            if (request.getParameter("acao").equals("mostrar")) {
                ArrayList<Aluno> meusAlunos = dao.getLista();
                RequestDispatcher disp = getServletContext().getRequestDispatcher("/ListaContatoView.jsp");
                request.setAttribute("meusAlunos", meusAlunos);
                disp.forward(request, response);

            } else {

                int id = Integer.parseInt(request.getParameter("id"));

                if (request.getParameter("acao").equals("alterar")) {
                    Aluno aluno = dao.getContatoPorID(id);
                    if (aluno.getId() > 0) {

                        request.setAttribute("id",aluno.getId());
                        request.setAttribute("nome",aluno.getNome());
                        request.setAttribute("idade",aluno.getIdade());

                        RequestDispatcher rs = request.getRequestDispatcher("Form_Contato_Alterar.jsp");
                        rs.forward(request, response);
                    } else {
                        PrintWriter out = response.getWriter();
                        out.println("<script>alert('Usuário não encontrado!');location.href='ContatoController?acao=mostrar'</script>");
                    }
                } else {

                    if (request.getParameter("acao").equals("excluir")) {
                        PrintWriter out = response.getWriter();
                        if (dao.excluir(id)) {
                            out.println("<script>alert('Usuário excluído com sucesso!');location.href='ContatoController?acao=mostrar'</script>");
                        } else {
                            out.println("<script>alert('Não foi possível excluir!');location.href='ContatoController?acao=mostrar'</script>");
                        }
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Erro ao recuperar dados no Get do controler");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        try {
            Contato contato = new Contato();

            if (!request.getParameter("id").isEmpty()) {
                contato.setId(Integer.parseInt(request.getParameter("id")));
            }

            contato.setNome(request.getParameter("nome"));
            contato.setIdade(Integer.parseInt(request.getParameter("idade")));

            ContatoDAO dao = new ContatoDAO();

            if (dao.gravar(contato)) {
                mensagem = "Usuário gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar usuário!";
            }
        } catch (Exception e) {
            mensagem = "Erro ao gravar usuário!";
            System.out.println("Erro ao gravar usuário: " + e.getMessage());
        }

        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + mensagem + "');location.href='ContatoController?acao=mostrar'</script>");
    }
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
                request.getParameter("login"),
                request.getParameter("email"),
                request.getParameter("senha"));

        // Cria um objeto de acesso ao BD
        AlunoDao usuarioDao = new AlunoDao();
    // Chama método para cadastrar usuário
        usuarioDao.inclui(usuario);

        request.getSession().setAttribute("usuarioLogado", usuario);
        getServletConfig().getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    private void atualizaUsuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException, SQLException {
        if (request.getSession().getAttribute("usuarioLogado") == null){
            response.sendRedirect("index.jsp");
            return;
        } else{

            AlunoDao usuarioDAO = new AlunoDao();

            Aluno aluno = new Aluno(
                    request.getParameter("nomeCompleto"),
                    request.getParameter("login"),
                    request.getParameter("email"),
                    request.getParameter("senha"));
            aluno.setIdAluno(Integer.valueOf(request.getParameter("idAluno")));

            // Chama método para cadastrar usuário
            usuarioDAO.altera(aluno);

            request.getSession().setAttribute("usuarioLogado", aluno);
            response.sendRedirect("index.jsp");
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

        response.sendRedirect("index.jsp");
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
            getServletConfig().getServletContext().getRequestDispatcher("/operacao=4").forward(request, response);
        } else{
            response.sendRedirect("home.jsp");
        }
    }

    private void fazLogout(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getSession().invalidate();
        response.sendRedirect("index.jsp");
    }

    private void trocaTela(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        if (request.getSession().getAttribute("usuarioLogado") == null){
            response.sendRedirect("index.jsp");
            return;
        } else{
            response.sendRedirect("login.jsp");
        }
    }/*

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     *//*
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(AlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }/*
    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   /* @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException | SQLException ex) {
            Logger.getLogger(AlunoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
/*
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    /*@Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}



