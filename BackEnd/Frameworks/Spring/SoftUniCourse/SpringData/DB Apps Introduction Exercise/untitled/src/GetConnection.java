import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

class GetConnection {
    private static final String USER_NAME = "root";
    private static final String PASSWORD = "12345";
    private static final String CONNECTION_URL ="jdbc:mysql://localhost:3306/minions_db";


    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();
        props.setProperty("user" , USER_NAME);
        props.setProperty("password" , PASSWORD);
        return DriverManager.getConnection(CONNECTION_URL, props);
    }
}
