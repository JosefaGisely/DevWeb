package connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class FabricaConexoes {

    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/carrinho", "devweb", "" );
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
