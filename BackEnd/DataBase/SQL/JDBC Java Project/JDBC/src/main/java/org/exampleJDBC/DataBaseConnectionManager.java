package org.exampleJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataBaseConnectionManager {
    private final String url;
    private final Properties properties;

    public DataBaseConnectionManager(String host, String databaseName , String username , String password) {
        this.url = "jdbc:mysql://"+host +"/" + databaseName;
        //jdbc:mysql://${MYSQL_HOST:localhost}:3306/db_example
        this.properties = new Properties();
        this.properties.setProperty("user" , username);
        this.properties.setProperty("password" , password);
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url , properties);
    }
}
