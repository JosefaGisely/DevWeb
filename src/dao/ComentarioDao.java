package dao;

import connection.FabricaConexoes;

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
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
