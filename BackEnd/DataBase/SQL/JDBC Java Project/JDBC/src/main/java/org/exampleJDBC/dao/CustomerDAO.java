package org.exampleJDBC.dao;

import org.exampleJDBC.dao.dto.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerDAO extends DataAccessObject<Customer> {
    enum Commands {
        ;
        public final static String INSERT = "INSERT INTO customer " +
                "(first_name,last_name,email,phone,address,city,state,zipcode) " +
                "VALUES (?,?,?,?,?,?,?,?)";
        public final static String GET_ONE = "SELECT " +
                "customer_id , first_name , last_name,email,phone,address,city,state,zipcode " +
                "FROM customer " +
                "WHERE customer_id = ?";
        public static final String UPDATE = "UPDATE customer " +
                "SET first_name=?,last_name=?,email=?,phone=?,address=?,city=?,state=?,zipcode=? " +
                "WHERE customer_id = ?";

        public static final String DELETE = "DELETE from customer " +
                "where customer_id = ?";

        public static final String SELECT_ALL = "SELECT * FROM customer";
    }

    public CustomerDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Customer> findById(long id) {

        Customer customer = new Customer();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Commands.GET_ONE);
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()) {
                extractCustomer(customer, rs);
                return Optional.of(customer);
            }else{
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Customer> findAll() {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Commands.SELECT_ALL);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Customer> customers = new ArrayList<>();
            while (resultSet.next()) {
                Customer customer = new Customer();
                extractCustomer(customer, resultSet);
                customers.add(customer);
            }
            return customers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Customer update(Customer dto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Commands.UPDATE);
            prepareStatement(dto, preparedStatement);
            preparedStatement.setLong(9, dto.getId());
            preparedStatement.execute();
            return findById(dto.getId()).get();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean create(Customer dto) {
        try {
            PreparedStatement statement = connection.prepareStatement(Commands.INSERT);
            prepareStatement(dto, statement);
            return statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Commands.DELETE);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void extractCustomer(Customer customer, ResultSet rs) throws SQLException {
        customer.setId(rs.getLong("customer_id"));
        customer.setFirstName(rs.getString("first_name"));
        customer.setLastName(rs.getString("last_name"));
        customer.setEmail(rs.getString("email"));
        customer.setPhone(rs.getString("phone"));
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setState(rs.getString("state"));
        customer.setZipCode(rs.getString("zipcode"));
    }

    private static void prepareStatement(Customer dto, PreparedStatement statement) throws SQLException {
        statement.setString(1, dto.getFirstName());
        statement.setString(2, dto.getLastName());
        statement.setString(3, dto.getEmail());
        statement.setString(4, dto.getPhone());
        statement.setString(5, dto.getAddress());
        statement.setString(6, dto.getCity());
        statement.setString(7, dto.getState());
        statement.setString(8, dto.getZipCode());
    }

}
