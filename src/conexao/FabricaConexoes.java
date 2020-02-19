package conexao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexoes {
    private static Connection conexao = null;

    public static Connection criaConexao() throws SQLException {
        if ( conexao == null ) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Driver foi carregado!");
                conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/escola", "root", "" );
                System.out.println("Conexão realizada com sucesso!");
            }catch( ClassNotFoundException e){
                    System.out.println("Driver não foi localizado!");
            }
        }
        return conexao;
    }

    // Metodo que fecha conexao com o banco de dados.
    public void closeConnection(){
        try {
            if (conexao != null){
                conexao.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}