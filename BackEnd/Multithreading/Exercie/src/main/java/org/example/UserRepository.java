package org.example;

import org.example.models.UserEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class UserRepository{
    private final JdbcTemplate jdbcTemplate = new JdbcTemplate();

    public UserRepository() {
        setDriverManagerDataSource();
        createTable();
    }

    public void save(UserEntity user) {
        String sql = "INSERT INTO users (gmail, number, username) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, user.getGmail(), user.getNumber(), user.getUsername());
    }

    private void setDriverManagerDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/myDb");
        dataSource.setUsername("root");
        dataSource.setPassword("12345");
        jdbcTemplate.setDataSource(dataSource);
    }

    private void createTable (){
        String createTableSql = "CREATE TABLE IF NOT EXISTS users (" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "gmail VARCHAR(255) NOT NULL," +
                "username VARCHAR(255) NOT NULL," +
                "number INT" +
                ")";
        jdbcTemplate.execute(createTableSql);
    }
}
