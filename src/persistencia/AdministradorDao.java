package persistencia;

import conexao.FabricaConexoes;
import interfaces.DaoAdm;
import model.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdministradorDao implements DaoAdm {
    FabricaConexoes fabricaConexoes = new FabricaConexoes();
    private Connection connection;
    public AdministradorDao() throws SQLException {
        this.connection = FabricaConexoes.getConnection();
    }
    @Override
    public List<Aluno> incluiAluno(Aluno id, Aluno cpf, Aluno nome, Aluno email, Aluno celular, Aluno login, Aluno Senha, Aluno Endereco, Aluno Bairro, Aluno Cidade, Aluno Cep, Aluno Comentario, Aluno Aprovado) {
        // inserir dados em uma tabela de um banco de dados SQL
        String sql =
                "INSERT INTO usuario "
                        + "(cpf, nomeCompleto, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) "
                        + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            // preenche os valores
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, cpf.getCpf());
            stmt.setString(2, nome.getNomeCompleto());
            stmt.setString(3, email.getEmail());
            stmt.setString(4, celular.getCelular());
            stmt.setString(5, login.getLogin());
            stmt.setString(6, Senha.getSenha());
            stmt.setString(7, Endereco.getEndereco());
            stmt.setString(8, Cidade.getCidade());
            stmt.setString(9, Bairro.getBairro());
            stmt.setString(10, Cep.getCep());
            stmt.setString(11, Comentario.getComentario());
            stmt.setString(12, Aprovado.getAprovado());

            // Executa o Statment
            stmt.execute();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            fabricaConexoes.closeConnection();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    @Override
    public List<Aluno> listaAluno(Aluno id) throws SQLException {
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
                        rs.getInt("idUsuario"),
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
                        rs.getString("comentario")));

            }
            // Encerra o ResultSet
            rs.close();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            fabricaConexoes.closeConnection();
            // Retorna a lista de Usuários do BD
            return usuariosList;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alteraAlunos(Aluno id, Aluno cpf, Aluno nome, Aluno email, Aluno celular, Aluno login, Aluno Senha, Aluno Endereco, Aluno Bairro, Aluno Cidade, Aluno Cep) {
        String sql = "UPDATE * FROM ALUNO WWHERE id = value (?)";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id.getIdAluno());
            statement.setString(2,cpf.getCpf());
            statement.setString(3,nome.getNomeCompleto());
            statement.setString(4,celular.getCelular());
            statement.setString(5,login.getLogin());
            statement.setString(6,Senha.getSenha());
            statement.setString(7,Endereco.getEndereco());
            statement.setString(8,Bairro.getBairro());
            statement.setString(9,Cidade.getCidade());
            statement.setString(10,Cep.getCep());
            statement.execute();
            statement.close();

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void excluiAluno(Aluno id) {
        String sql = "DELETE * from ALUNO WHERE id = value (?)";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id.getIdAluno());
            statement.execute();
            statement.close();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void excluiTodosAlunos(Aluno aluno) {
        String sql = "DELETE * FROM ALUNO";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void incluiInstrutor(Instrutor id, Instrutor nome, Instrutor email, Instrutor valor_hora, Instrutor login, Instrutor Senha, Instrutor Experiencia) {
        try {

            PreparedStatement stmt = this.connection.prepareStatement("NSERT INTO INSTRUTOR "
                    + "(id,nome,email,valor_hora,login,Senha,Experiencia) "
                    + "values (?, ?, ?, ?, ?, ?, ?, ?)");
            // Cria uma varíavel para receber o resultado da Query
            stmt.setInt(1, id.getIdInstrutor());
            stmt.setString(2, nome.getNomeCompleto());
            stmt.setString(3, email.getEmail());
            stmt.setInt(4, valor_hora.getValor_hora());
            stmt.setString(5, login.getLogin());
            stmt.setString(6, Senha.getSenha());
            stmt.setString(7, Experiencia.getExperiencia());
            // Encerra o Statment
            stmt.execute();
            stmt.close();
            // Fecha conexão BD
            fabricaConexoes.closeConnection();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Instrutor> listaIntrutor(Instrutor id) {
        try {
            // Cria uma lista de usuários
            List<Instrutor> instrutorArrayList = new ArrayList<>();
            // Cria o statment que contém a Query de consulta
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM INSTRUTOR");
            // Cria uma varíavel para receber o resultado da Query
            ResultSet rs = stmt.executeQuery();

            // laço de repetição para percorrer todas as intâncias do ResultSet
            while (rs.next()) {
                instrutorArrayList.add(new Instrutor(rs.getInt("idInstrutor"),
                        rs.getString("nomeCompleto"),
                        rs.getString("String email"),
                        rs.getInt("valor_hora"),
                        rs.getString("login"),
                        rs.getString("senha"),
                        rs.getString ("experiencia")));

            }
            // Encerra o ResultSet
            rs.close();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            fabricaConexoes.closeConnection();
            // Retorna a lista de Usuários do BD
            return instrutorArrayList;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void alteraInstrutor(Instrutor id, Instrutor nome, Instrutor email, Instrutor valor_hora, Instrutor login, Instrutor Senha, Instrutor Experiencia) {
        String sql = "UPDATE * FROM INSTRUTOR WWHERE id = value (?)";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id.getIdInstrutor());
            statement.setString(2,nome.getNomeCompleto());
            statement.setString(3,email.getEmail());
            statement.setInt(4,valor_hora.getValor_hora());
            statement.setString(5,login.getLogin());
            statement.setString(6,Senha.getSenha());
            statement.setString(7,Experiencia.getExperiencia());
            statement.execute();
            statement.close();

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void excluiInstrutor(Instrutor id) {
        String sql = "DELETE * from INSTRUTOR WHERE id = value (?)";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id.getIdInstrutor());
            statement.execute();
            statement.close();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }
    @Override
    public void excluiTodosInstrutores(Instrutor instrutor) {
        String sql = "DELETE * FROM INSTRUTOR";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void incluiCurso(Cursos id, Cursos nome, Cursos requisito, Cursos cargaHoraria, Cursos preco) {
        String sql =
                "INSERT INTO CURSOS "
                        + "(id, nome, requisito, cargaHoraria, preco) "
                        + "values (?, ?, ?, ?, ?)";

        try {
            // preenche os valores
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setInt(1, id.getIdCursos());
            stmt.setString(2, nome.getNomeCompleto());
            stmt.setString(3, requisito.getRequisito());
            stmt.setDate(4, (Date) cargaHoraria.getCarga_horaria());
            stmt.setDouble(5, preco.getPreco());

            // Executa o Statment
            stmt.execute();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            fabricaConexoes.closeConnection();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Cursos> listaCurso(Cursos id) {
        try {
            // Cria uma lista de usuários
            List<Cursos> instrutorArrayList = new ArrayList<>();
            // Cria o statment que contém a Query de consulta
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Cursos");
            // Cria uma varíavel para receber o resultado da Query
            ResultSet rs = stmt.executeQuery();

            // laço de repetição para percorrer todas as intâncias do ResultSet
            while (rs.next()) {
                instrutorArrayList.add(new Cursos(
                        rs.getInt("idCursos"),
                        rs.getString("nomeCompleto"),
                        rs.getString("requisito"),
                        rs.getString("ementa"),
                        rs.getDate("carga_horaria"),
                        rs.getDouble("preco")));
            }
            // Encerra o ResultSet
            rs.close();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            fabricaConexoes.closeConnection();
            // Retorna a lista de Usuários do BD
            return instrutorArrayList;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alteraCurso(Cursos id, Cursos nome, Cursos requisito, Cursos cargaHoraria, Cursos preco) {
        String sql = "UPDATE * FROM Cursos WWHERE id = value (?)";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id.getIdCursos());
            statement.setString(2,nome.getNomeCompleto());
            statement.setString(3,requisito.getRequisito());
            statement.setDate(4, (Date) cargaHoraria.getCarga_horaria());
            statement.setDouble(5,preco.getPreco());
            statement.execute();
            statement.close();

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void excluiCurso(Cursos id) {
        String sql = "DELETE * from CURSO WHERE id = value (?)";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id.getIdCursos());
            statement.execute();
            statement.close();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void excluiTodosCursos(Cursos cursos) {
        String sql = "DELETE * FROM INSTRUTOR";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void incluiTurma(Turma id, Turma instrutorId, Turma cursoId, Turma dataInicio, Turma dataFinal, Turma cargaHoraria) {
        try {

            PreparedStatement stmt = this.connection.prepareStatement("INSERT INTO Turmas "
                    + "(id,instrutorId,cursoId,dataInicio,dataFinal,cargaHoraria) "
                    + "values (?, ?, ?, ?, ?, ?)");
            // Cria uma varíavel para receber o resultado da Query
            stmt.setInt(1, id.getIdTurmas());
            stmt.setString(2, instrutorId.getIdInstrutores());
            stmt.setDate(3, (Date) dataInicio.getData_inicial());
            stmt.setDate(4, (Date) dataFinal.getData_final());
            stmt.setDate(5, (Date) cargaHoraria.getCarga_horaria());
            // Encerra o Statment
            stmt.execute();
            stmt.close();
            // Fecha conexão BD
            fabricaConexoes.closeConnection();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Turma> listaTurma(Turma id) {
        try {
            // Cria uma lista de usuários
            List<Turma> turmasArrayList = new ArrayList<>();
            // Cria o statment que contém a Query de consulta
            PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM Turmas");
            // Cria uma varíavel para receber o resultado da Query
            ResultSet rs = stmt.executeQuery();

            // laço de repetição para percorrer todas as intâncias do ResultSet
            while (rs.next()) {
                turmasArrayList.add(new Turma(
                        rs.getInt("idTurmas"),
                        rs.getString("idInstrutores"),
                        rs.getString("idCursos"),
                        rs.getDate("data_inicial"),
                        rs.getDate("data_final"),
                        rs.getDate("carga_horaria")));
            }
            // Encerra o ResultSet
            rs.close();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            fabricaConexoes.closeConnection();
            // Retorna a lista de Usuários do BD
            return turmasArrayList;
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void alteraTurma(Turma id, Turma instrutorId, Turma cursoId, Turma dataInicio, Turma dataFinal, Turma cargaHoraria) {
        String sql = "UPDATE * FROM Turmas WWHERE id = value (?)";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id.getIdTurmas());
            statement.setString(2,instrutorId.getIdInstrutores());
            statement.setString(3,cursoId.getIdCursos());
            statement.setDate(4, (Date) dataInicio.getData_inicial());
            statement.setDate(5,(Date) dataFinal.getData_final());
            statement.setDate(6,(Date) cargaHoraria.getCarga_horaria());
            statement.execute();
            statement.close();

        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void excluiTurma(Turma id) {
        String sql = "DELETE * from Turmas WHERE id = value (?)";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.setInt(1,id.getIdTurmas());
            statement.execute();
            statement.close();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void excluitTodasTurmas(Turma turmas) {
        String sql = "DELETE * FROM Turmas";
        try {PreparedStatement statement = this.connection.prepareStatement(sql);
            statement.execute();
            statement.close();
        }catch (SQLException exception){
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void listarPorAlunosTodasOsCursoTurmasENota(Cursos idCurso, Turma idTurma, Aluno idAluno){
    }

    @Override
    public void listarPorInstrutorTodosOsCursosTurmasValorTotal(Instrutor idInstrutor, Turma idTurma, Cursos IdCursos) {

    }
}