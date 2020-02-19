package persistencia;

import conexao.FabricaConexoes;
import model.Comentario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentarioDao {
    private Connection connection;


    public ComentarioDao() throws SQLException {
        this.connection = FabricaConexoes.getConnection();
    }


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

    public void inclui(Comentario c){
        String sql = "INSERT INTO comentario "
                + "(texto, autor, publicacao, dataPublicacao) "
                + "values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(sql);
            stmt.setString(1, c.getTexto());
            stmt.setInt(2, (c.getAutor()).getIdAluno());
            stmt.setLong(3, c.getDataComentario());

            stmt.execute();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            connection.close();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }
}

