import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Magaiver Santos
 */
public class ConnectionFactory {

    private final String DB = "";
    private final String URL = "";
    private final String USER = "";
    private final String PASSWORD = "";



    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException("Error to connect db", e);
        }
    }

}
