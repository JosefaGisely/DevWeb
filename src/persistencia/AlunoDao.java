package persistencia;

import conexao.FabricaConexoes;
import model.Aluno;

import java.sql.*;
import java.util.ArrayList;

public class AlunoDao{

    private Connection conexao;
    public AlunoDao() {
        try {
            // Executa a conexão com o banco de dados
            conexao = FabricaConexoes.criaConexao();
        }
        catch( Exception e ) {
            System.out.println("Erro criação de conexao DAO");
            System.out.println(e);
        }
    }

    public boolean gravar( Aluno aluno ) {
        try {
            String sql;
            if ( aluno.getIdAluno() == 0 ) {
                // Realizar uma inclusão
                sql = "INSERT INTO aluno (cpf, nomeCompleto, email, celular, login, senha, endereco, cidade, bairro, cep, comentario, aprovado) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            } else {
                // Realizar uma alteração
                sql = "UPDATE contato SET cpf=?, nomeCompleto = ? , email = ?, celular = ?, login = ?, senha = ?, endereco = ?, cidade = ?, bairro = ? , cep = ?, WHERE id=?";

            }

            PreparedStatement stmt = conexao.prepareStatement(sql);
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
            stmt.setString(11, aluno.getAprovado());
            stmt.setString(11, String.valueOf(aluno.getIdAluno()));
            System.out.println(stmt.toString());

            if ( aluno.getIdAluno()> 0 )
                stmt.setInt(3, aluno.getIdAluno());

            stmt.execute();

            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public boolean excluir( int id ) {
        try {
            String sql = "DELETE FROM contato WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
            return false;
        }
    }

    public ArrayList<Aluno> getLista() {
        //Cria o objeto resultado que irá armazenar os registros retornados do BD
        ArrayList<Aluno> resultado = new ArrayList<>();
        try {
            // Cria o objeto para quer será utilizado para enviar comandos SQL
            // para o BD
            Statement stmt = conexao.createStatement();
            // Armazena o resultado do comando enviado para o banco de dados
            ResultSet rs = stmt.executeQuery("select * from contato");
            // rs.next() Aponta para o próximo registro do BD, se houver um
            while( rs.next() ) {
                //Cria o objeto da classe Contato para armazenar os dados
                //que vieram do BD
                Aluno aluno = new Aluno();

                //Pega o conteúdo da coluna do ResultSet (rs)
                aluno.setIdAluno(rs.getInt("id"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNomeCompleto( rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setLogin(rs.getString("login"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCep(rs.getString("cep"));

                //Adiciona o objeto criado na ArrayList resultado
                resultado.add(aluno);
            }
        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }

        // Retorna a lista de Contatos encontrados no banco de dados.
        return resultado;
    }

    public Aluno getAlunoPorID( int codigo ) {
        Aluno aluno = new Aluno();
        try {
            String sql = "SELECT * FROM contato WHERE id = ?";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, codigo);

            ResultSet rs = ps.executeQuery();

            if ( rs.next() ) {
                aluno.setIdAluno(rs.getInt("id"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setNomeCompleto( rs.getString("nome"));
                aluno.setEmail(rs.getString("email"));
                aluno.setCelular(rs.getString("celular"));
                aluno.setLogin(rs.getString("login"));
                aluno.setSenha(rs.getString("senha"));
                aluno.setEndereco(rs.getString("endereco"));
                aluno.setCidade(rs.getString("cidade"));
                aluno.setBairro(rs.getString("bairro"));
                aluno.setCep(rs.getString("cep"));
                aluno.setAprovado(rs.getString("aprovado"));

            }

        } catch( SQLException e ) {
            System.out.println("Erro de SQL: " + e.getMessage());
        }
        return aluno;
    }


}

