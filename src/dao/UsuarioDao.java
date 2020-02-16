package dao;

import connection.FabricaConexoes;
import model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDao implements Dao {

    private Connection conexao;

    public UsuarioDao() throws SQLException {}

    @Override
    public void inclui(Usuario u) {
    // inserir dados em uma tabela de um banco de dados SQL
    String sql =
        "INSERT INTO escola.aluno "
            + "(cpf, nomeCompleto, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) "
            + "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    // preenche os valores
    try {
        PreparedStatement stmt = FabricaConexoes.getConnection().prepareStatement(sql);
        stmt.setString(1, u.getCpf());
        stmt.setString(2, u.getNomeCompleto());
        stmt.setString(3, u.getEmail());
        stmt.setString(4, u.getCelular());
        stmt.setString(5, u.getLogin());
        stmt.setString(6, u.getSenha());
        stmt.setString(7, u.getEndereco());
        stmt.setString(8, u.getCidade());
        stmt.setString(9, u.getBairro());
        stmt.setString(10, u.getCep());
        stmt.setString(11, u.getComentario());
        stmt.setString(12, u.getAprovado());

        // Executa o Statment
        stmt.execute();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        conexao.close();
    }catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    public List<Usuario> listaTodos(Usuario u) throws SQLException {
    try {
        // Cria uma lista de usuários
        List<Usuario> usuariosList = new ArrayList<>();
        // Cria o statment que contém a Query de consulta
        PreparedStatement stmt = this.conexao.prepareStatement("SELECT * FROM usuario");

        // Cria uma varíavel para receber o resultado da Query
        ResultSet rs = stmt.executeQuery();

        // laço de repetição para percorrer todas as intâncias do ResultSet
        while (rs.next()) {
                usuariosList.add(
                new Usuario(
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
        conexao.close();
        // Retorna a lista de Usuários do BD
        return usuariosList;
        }catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    @Override
    public Usuario busca(Usuario id) {
    try {
        // Cria o statment que contém a Query de consulta
        PreparedStatement stmt =
            this.conexao.prepareStatement("SELECT * FROM usuario WHERE idUsuario = ?");
        stmt.setInt(1, Integer.parseInt(String.valueOf(id)));
        // Cria uma varíavel para receber o resultado da Query
        ResultSet rs = stmt.executeQuery();

        // Cria usuário encontrado
        Usuario usuario = null;
        // Verifica se houve algum retorno
        if (rs.next()) {
            usuario = new Usuario(
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
        conexao.close();
        // Retorna a lista de Usuários do BD
        return usuario;
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    public Usuario buscaLogin(String email, String senha) {
    try {
        // Cria o statment que contém a Query de consulta
        PreparedStatement stmt =
            this.conexao.prepareStatement(
                    "SELECT * FROM usuario WHERE " + "	email = ? and " + "senha = ?");
        stmt.setString(1, email);
        stmt.setString(2, senha);
        // Cria uma varíavel para receber o resultado da Query
        ResultSet rs = stmt.executeQuery();

        // Cria usuário encontrado
        Usuario usuario = null;
        // Verifica se houve algum retorno
        if (rs.next()) {
        usuario =
            new Usuario(
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
        conexao.close();
        // Retorna a lista de Usuários do BD
        return usuario;
    } catch (SQLException e) {
        throw new RuntimeException(e);
        }
    }

    public void altera(Usuario u) {
    try {
        PreparedStatement stmt =
            this.conexao.prepareStatement(
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

        stmt.setString(1, u.getCpf());
        stmt.setString(2, u.getNomeCompleto());
        stmt.setString(3, u.getEmail());
        stmt.setString(4, u.getCelular());
        stmt.setString(5, u.getLogin());
        stmt.setString(6, u.getSenha());
        stmt.setString(7, u.getEndereco());
        stmt.setString(8, u.getCidade());
        stmt.setString(9, u.getBairro());
        stmt.setString(10, u.getCep());
        stmt.setString(11, String.valueOf(u.getIdUsuario()));
        System.out.println(stmt.toString());
        // Executa o Statment
        stmt.execute();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alteraSenha(Usuario u) {
    try {
        PreparedStatement stmt =
            this.conexao.prepareStatement(
                "UPDATE usuario SET " + "senha = ? " + "WHERE idUsuario = ?");
        stmt.setString(1, u.getSenha());
        stmt.setInt(2, (u.getIdUsuario()));
        System.out.println(stmt.toString());
        // Executa o Statment
        stmt.execute();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        conexao.close();
    }catch (SQLException ex) {
        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void remove(int id) {
    try {
        (new ComentarioDao()).removePorAutor(id);
        PreparedStatement stmt =
            this.conexao.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
        stmt.setInt(1, id);
        // Executa o Statment
        stmt.execute();
        // Encerra o Statment
        stmt.close();
        // Fecha conexão BD
        conexao.close();
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void removePorAutor(int idUsuario) {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM comentario WHERE autor = ?");
            stmt.setInt(1, idUsuario);
            stmt.execute();
            stmt.close();

            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
