package connection;


import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexoes {
    private Connection conexao;

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/");
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    // Metodo que fecha conexao com o banco de dados.
    public void closeConnection() {
        try {
            if (conexao != null) {
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}