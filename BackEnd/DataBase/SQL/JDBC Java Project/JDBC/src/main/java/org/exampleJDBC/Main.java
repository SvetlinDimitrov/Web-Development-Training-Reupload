package org.exampleJDBC;

import org.exampleJDBC.dao.CustomerDAO;
import org.exampleJDBC.dao.OrderDAO;
import org.exampleJDBC.dao.dto.Customer;
import org.exampleJDBC.dao.dto.order.Order;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

public class Main {
    public static void main(String[] args) throws SQLException {
        DataBaseConnectionManager dataBaseConnectionManager =
                new DataBaseConnectionManager("localhost:3306", "hplussport", "root", "12345");

        Connection connection = dataBaseConnectionManager.getConnection();
        OrderDAO orderDAO = new OrderDAO(connection);
        Optional<Order> byId = orderDAO.findById(1100);
        System.out.println(byId.orElse(null));
    }

    private static Customer getCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Toshko");
        customer.setLastName("Toshkoov");
        customer.setEmail("Toshko@abv.bg");
        customer.setPhone("11111111111111");
        customer.setAddress("Toshkolandia.18");
        customer.setCity("Toshko city");
        customer.setState("Toshkov");
        customer.setZipCode("2222222");
        return customer;
    }
}