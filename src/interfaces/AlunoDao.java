package interfaces;

import connection.FabricaConexoes;
import model.Aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AlunoDao implements Dao{

    private Connection connection;

    public AlunoDao() throws SQLException {
        this.connection = FabricaConexoes.getConnection();
    }


    public void inclui(Aluno aluno) {
    // inserir dados em uma tabela de um banco de dados SQL
    String sql =
        "INSERT INTO escola.aluno "
            + "(cpf, nomeCompleto, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // preenche os valores
    try {
        PreparedStatement stmt = FabricaConexoes.getConnection().prepareStatement(sql);
        stmt.setString(1, aluno.getCpf());
        stmt.setString(2, aluno.getNomeCompleto());
        stmt.setString(3, aluno.getEmail());
        stmt.setString(4, aluno.getCelular());
        stmt.setString(5, aluno.getLogin());
        stmt.setString(6, aluno.getSenha());
        stmt.setString(7, aluno.getEndereco());
        stmt.setString(8, aluno.getCidade());
        stmt.setString(9, aluno.getBairro());
        stmt.setString(10, aluno.getCep());
        stmt.setString(11, aluno.getComentario());
        stmt.setString(12, aluno.getAprovado());

        // Executa o Statment
        stmt.execute();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        connection.close();
    }catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    public List<Aluno> listaTodos(Aluno aluno) throws SQLException {
    try {
        // Cria uma lista de usuários
        List<Aluno> usuariosList = new ArrayList<>();
        // Cria o statment que contém a Query de consulta
        PreparedStatement stmt = this.connection.prepareStatement("SELECT * FROM usuario");

        // Cria uma varíavel para receber o resultado da Query
        ResultSet rs = stmt.executeQuery();

        // laço de repetição para percorrer todas as intâncias do ResultSet
        while (rs.next()) {
                usuariosList.add(
                new Aluno(
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
        }catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public void adiciona(Aluno aluno) {

    }

    @Override
    public List<Aluno> listaTodos(List u) {
        return null;
    }

    @Override
    public Aluno busca(Aluno id) {
    try {
        // Cria o statment que contém a Query de consulta
        PreparedStatement stmt =
            this.connection.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
        stmt.setInt(1, Integer.parseInt(String.valueOf(id)));
        // Cria uma varíavel para receber o resultado da Query
        ResultSet rs = stmt.executeQuery();

        // Cria usuário encontrado
        Aluno usuario = null;
        // Verifica se houve algum retorno
        if (rs.next()) {
            usuario = new Aluno(
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
                rs.getString("aprovado"));
        }
        // Encerra o ResultSet
        rs.close();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        connection.close();
        // Retorna a lista de Usuários do BD
        return usuario;
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public Aluno buscaPorEmail(String email) {
        return null;
    }

    public Aluno buscaLogin(String email, String senha) {
    try {
        // Cria o statment que contém a Query de consulta
        PreparedStatement stmt =
            this.connection.prepareStatement(
                    "SELECT * FROM usuario WHERE " + "	email = ? and " + "senha = ?");
        stmt.setString(1, email);
        stmt.setString(2, senha);
        // Cria uma varíavel para receber o resultado da Query
        ResultSet rs = stmt.executeQuery();

        // Cria usuário encontrado
        Aluno usuario = null;
        // Verifica se houve algum retorno
        if (rs.next()) {
        usuario =
            new Aluno(
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
                rs.getString("aprovado"));
        }
        // Encerra o ResultSet
        rs.close();
          // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        connection.close();
        // Retorna a lista de Usuários do BD
        return usuario;
    } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public void altera(Aluno aluno) {
    try {
        PreparedStatement stmt =
            this.connection.prepareStatement(
                "UPDATE usuario "
                    + "set cpf = ?,"
                    + "nomeCompleto = ?, "
                    + "email = ?, "
                    + "celular = ?, "
                    + "login = ?, "
                    + "senha = ? "
                    + "endereco = ?, "
                    + "cidade = ?, "
                    + "bairro = ?, "
                    + "cep = ? "
                    + "comentario = ?, "
                    + "aprovado = ? "
                    + "WHERE idUsuario = ?");

        stmt.setString(1, aluno.getCpf());
        stmt.setString(2, aluno.getNomeCompleto());
        stmt.setString(3, aluno.getEmail());
        stmt.setString(4, aluno.getCelular());
        stmt.setString(5, aluno.getLogin());
        stmt.setString(6, aluno.getSenha());
        stmt.setString(7, aluno.getEndereco());
        stmt.setString(8, aluno.getCidade());
        stmt.setString(9, aluno.getBairro());
        stmt.setString(10, aluno.getCep());
        stmt.setString(11, String.valueOf(aluno.getIdAluno()));
        System.out.println(stmt.toString());
        // Executa o Statment
        stmt.execute();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    public void alteraSenha(Aluno aluno) {
    try {
        PreparedStatement stmt =
            this.connection.prepareStatement(
                "UPDATE usuario SET " + "senha = ? " + "WHERE idUsuario = ?");
        stmt.setString(1, aluno.getSenha());
        stmt.setInt(2, (aluno.getIdAluno()));
        System.out.println(stmt.toString());
        // Executa o Statment
        stmt.execute();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        connection.close();
    }catch (SQLException ex) {
        Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(int id) {
    try {
        (new ComentarioDao()).removePorAutor(id);
        PreparedStatement stmt =
            this.connection.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
        stmt.setInt(1, id);
        // Executa o Statment
        stmt.execute();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        connection.close();
    } catch (SQLException ex) {
        Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removePorAutor(int idUsuario) {
        try {
            PreparedStatement stmt = this.connection.prepareStatement("DELETE FROM comentario WHERE autor = ?");
            stmt.setInt(1, idUsuario);
            stmt.execute();
            stmt.close();

            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

   //  Aluno validar(String login, String senha) {

    //}
}
