package com.company;

import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {


        Properties props = new Properties();
        props.setProperty("user", "root");
        props.setProperty("password", "12345");

        Connection connection = DriverManager
                .getConnection("jdbc:mysql://localhost:3306/soft_uni", props);

        PreparedStatement stmt =
                connection.prepareStatement("SELECT * FROM employees WHERE salary > ?");

        String stmt2 = "SELECT * FROM employees WHERE salary > 50000";


        stmt.setDouble(1, Double.parseDouble("50000"));
        ResultSet rs = stmt.executeQuery();

        while(rs.next()){
            System.out.println(rs.getString("first_name") + " " + rs.getString("last_name"));
        }
        connection.close();
    }
}