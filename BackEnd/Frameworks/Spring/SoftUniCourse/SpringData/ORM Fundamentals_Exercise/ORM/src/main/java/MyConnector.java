import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnector {
    private  static  final String URL = "jdbc:mysql://localhost:3306/soft_uni";
    private static  final String USERNAME = "root";
    private static  final String PASSWORD = "12345";
    private static Connection myConnector;

    public static Connection getConnection() throws SQLException {
        if(myConnector == null){
            Properties properties = new Properties();
            properties.setProperty("user" , USERNAME);
            properties.setProperty("password" , PASSWORD);
            myConnector = DriverManager.getConnection(URL , properties);
        }
        return  myConnector;
    }
}
