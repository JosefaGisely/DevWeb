package interfaces;

import connection.FabricaConexoes;
import model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDao implements DaoAdm {

    private Connection connection;

    public AdministradorDao() throws SQLException {

    }


    public void incluiAluno(Aluno a) {
        // inserir dados em uma tabela de um banco de dados SQL
        String sql =
                "INSERT INTO usuario "
                        + "(cpf, nomeCompleto, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) "
                        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            // preenche os valores
        try {
            PreparedStatement stmt = FabricaConexoes.getConnection().prepareStatement(sql);
            stmt.setString(1, a.getCpf());
            stmt.setString(2, a.getNomeCompleto());
            stmt.setString(3, a.getEmail());
            stmt.setString(4, a.getCelular());
            stmt.setString(5, a.getLogin());
            stmt.setString(6, a.getSenha());
            stmt.setString(7, a.getEndereco());
            stmt.setString(8, a.getCidade());
            stmt.setString(9, a.getBairro());
            stmt.setString(10, a.getCep());
            stmt.setString(11, a.getComentario());
            stmt.setString(12, a.getAprovado());

            // Executa o Statment
            stmt.execute();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            connection.close();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Aluno> incluiAluno(Aluno id, Aluno cpf, Aluno nome, Aluno email, Aluno celular, Aluno login, Aluno Senha, Aluno Endereco, Aluno Bairro, Aluno Cidade, Aluno Cep, Aluno Aprovado) {
        try {
            // Cria uma lista de usuários
            List<Aluno> usuariosList = new ArrayList<>();
            // Cria o statment que contém a Query de consulta
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario");
            // Cria uma varíavel para receber o resultado da Query
            ResultSet rs = stmt.executeQuery();

            // laço de repetição para percorrer todas as intâncias do ResultSet
            while (rs.next()) {
                usuariosList.add(new Aluno(
                        rs.getInt("idAluno"),
                        rs.getString("cpf"),
                        rs.getString("nomeCompleto"),
                        rs.getString("email"),
                        rs.getString("celular"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString("endereco"),
                        rs.getString("cidade"),
                        rs.getString("bairro"),
                        rs.getString("cep"),
                        rs.getString("comentario"),
                        rs.getString("aprovado")));

            }
            // Encerra o ResultSet
            rs.close();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            connection.close();
            // Retorna a lista de Usuários do BD
            return usuariosList;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Aluno> listaAluno(Aluno id) throws SQLException {
        return null;
    }

    @Override
    public void alteraAlunos(Aluno id, Aluno cpf, Aluno nome, Aluno email, Aluno celular, Aluno login, Aluno Senha, Aluno Endereco, Aluno Bairro, Aluno Cidade, Aluno Cep) {
        String sql = "UPDATE * FROM ALUNO WHERE id = ?";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
            statement.close();

        }catch (SQLException exception){

        }
    }

    @Override
    public void excluiAluno(Aluno id) {

    }

    @Override
    public void excluiTodosAlunos(Aluno aluno) {

    }

    @Override
    public void incluiInstrutor(Instrutor id, Instrutor nome, Instrutor email, Instrutor valor_hora, Instrutor login, Instrutor Senha, Instrutor Experiencia) {

    }

    @Override
    public List<Instrutor> listaIntrutor(Instrutor id) {

        return null;
    }

    @Override
    public void alteraInstrutor(Instrutor id, Instrutor nome, Instrutor email, Instrutor valor_hora, Instrutor login, Instrutor Senha, Instrutor Experiencia) {

    }

    @Override
    public void excluiInstrutor(Instrutor id) {

    }

    @Override
    public void excluiTodosInstrutores(Instrutor instrutor) {

    }

    @Override
    public void incluiCurso(Cursos id, Cursos nome, Cursos requisito, Cursos cargaHoraria, Cursos preco) {

    }

    @Override
    public List<Cursos> listaCurso(Cursos id) {

        return null;
    }

    @Override
    public void alteraCurso(Cursos id, Cursos nome, Cursos requisito, Cursos cargaHoraria, Cursos preco) {

    }

    @Override
    public void excluiCurso(Cursos id) {

    }

    @Override
    public void excluiTodosCursos(Cursos cursos) {

    }

    @Override
    public void incluiTurma(Turmas id, Turmas instrutorId, Turmas cursoId, Turmas dataInicio, Turmas dataFinal, Turmas cargaHoraria) {

    }

    @Override
    public List<Turmas> listaTurma(Turmas id) {

        return null;
    }

    @Override
    public void alteraTurma(Turmas id, Turmas instrutorId, Turmas cursoId, Turmas dataInicio, Turmas dataFinal, Turmas cargaHoraria) {

    }

    @Override
    public void excluiTurma(Turmas id) {

    }

    @Override
    public void excluitTodasTurmas(Turmas turmas) {

    }

    @Override
    public void listarPorAlunosTodasOsCursoTurmasENota(Cursos idCurso, Turmas idTurma, Aluno idAluno) {

    }

    @Override
    public void listarPorInstrutorTodosOsCursosTurmasValorTotal(Instrutor idInstrutor, Turmas idTurma, Cursos IdCursos) {

    }
}
