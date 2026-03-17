import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL = "jdbc:mysql://root:CCOgRXgBcUjLKxOZUFSMzVHSrwSUqXYJ@nozomi.proxy.rlwy.net:20223/railway?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "CCOgRXgBcUjLKxOZUFSMzVHSrwSUqXYJ";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}