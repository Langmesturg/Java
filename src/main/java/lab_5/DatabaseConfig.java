package lab_5;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    public static Connection connect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "password";
        return DriverManager.getConnection(url, user, password);
    }
}
