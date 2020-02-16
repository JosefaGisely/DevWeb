package interfaces;

import connection.FabricaConexoes;
import model.Comentario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ComentarioDao {
    private Connection conexao;

    public ComentarioDao() {
        this.conexao = new FabricaConexoes().getConnection();
    }

    public void removePorAutor(int idUsuario) {
        try {
            PreparedStatement stmt = this.conexao.prepareStatement("DELETE FROM comentario WHERE autor = ?");
            stmt.setInt(1, idUsuario);
            stmt.execute();
            stmt.close();

            conexao.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlunoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void inclui(Comentario c){
        String sql = "INSERT INTO comentario "
                + "(texto, autor, publicacao, dataPublicacao) "
                + "values (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.conexao.prepareStatement(sql);
            stmt.setString(1, c.getTexto());
            stmt.setInt(2, (c.getAutor()).getIdUsuario());
            stmt.setLong(3, c.getDataComentario());

            stmt.execute();
            // Encerra o Statment
            stmt.close();
            // Fecha conexão BD
            conexao.close();
        } catch (SQLException  e) {
            throw new RuntimeException(e);
        }
    }
}

