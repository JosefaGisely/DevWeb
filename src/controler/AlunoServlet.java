package controler;

import model.Aluno;
import persistencia.AlunoDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "AlunoServlet", urlPatterns = {"/AlunoServlet"})
public class AlunoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String mensagem;
        try {
            Aluno aluno = new Aluno();

            if (!request.getParameter("id").isEmpty()) {
                aluno.setIdAluno(Integer.parseInt(request.getParameter("id")));
            }

            aluno.setCpf(request.getParameter("cpf"));
            aluno.setNomeCompleto(request.getParameter("nome"));
            aluno.setEmail(request.getParameter("email"));
            aluno.setCelular(request.getParameter("celular"));
            aluno.setLogin(request.getParameter("login"));
            aluno.setSenha(request.getParameter("senha"));
            aluno.setEndereco(request.getParameter("endereco"));
            aluno.setCidade(request.getParameter("cidade"));
            aluno.setBairro(request.getParameter("bairro"));
            aluno.setCep(request.getParameter("cep"));
            aluno.setComentario(request.getParameter("comentario"));
            aluno.setAprovado(request.getParameter("aprovado"));

            AlunoDao alunoDao = new AlunoDao();

            if (alunoDao.gravar(aluno)) {
                mensagem = "Usuário gravado com sucesso!";
            } else {
                mensagem = "Erro ao gravar usuário!";
            }
        } catch (Exception e) {
            mensagem = "Erro ao gravar usuário!";
            System.out.println("Erro ao gravar usuário: " + e.getMessage());
        }

        PrintWriter out = response.getWriter();
        out.println("<script>alert('" + mensagem + "');location.href='alunoServlet?acao=mostrar'</script>");

    }

}
