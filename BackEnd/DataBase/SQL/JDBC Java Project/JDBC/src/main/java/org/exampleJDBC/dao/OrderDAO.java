package org.exampleJDBC.dao;

import org.exampleJDBC.dao.dto.order.CustomOrder;
import org.exampleJDBC.dao.dto.order.Order;
import org.exampleJDBC.dao.dto.order.ProductOrder;
import org.exampleJDBC.dao.dto.order.SalesmanOrder;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class OrderDAO extends DataAccessObject<Order>{
    private enum SqlCommands{
        ;
        static final String FIND_ONE = "select " +
                "c.first_name , c.last_name , c.email," +
                " o.order_id , o.creation_date ,o.total_due, o.status," +
                " s.first_name , s.last_name , s.email ," +
                " ol.quantity , p.code , p.name, p.size , p.variety , p.price " +
                "from orders o " +
                "join customer c on o.customer_id = c.customer_id " +
                "join salesperson s on " +
                "o.salesperson_id = s.salesperson_id " +
                "join order_item ol on ol.order_id = o.order_id " +
                "join product p on ol.product_id = p.product_id " +
                "where o.order_id = ?;";
    }

    public OrderDAO(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<Order> findById(long id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SqlCommands.FIND_ONE);
            preparedStatement.setLong(1 , id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                CustomOrder customOrder =
                        new CustomOrder(resultSet.getString("c.first_name") ,
                                resultSet.getString("c.last_name") ,
                                resultSet.getString("c.email"));
                SalesmanOrder salesmanOrder =
                        new SalesmanOrder(resultSet.getString("s.first_name"),
                                resultSet.getString("s.last_name") ,
                                resultSet.getString("s.email"));
                ProductOrder productOrder =
                        new ProductOrder(resultSet.getString("p.code"),
                                resultSet.getString("p.name"),
                                resultSet.getInt("p.size"),
                                resultSet.getString("p.variety"),
                                new BigDecimal(resultSet.getString("p.price")));
                Order order = new Order();
                order.setId(resultSet.getLong("o.order_id"));
                order.setCustomer(customOrder);
                order.setDate(resultSet.getString("o.creation_date"));
                order.setProduct(productOrder);
                order.setQuantity(resultSet.getInt("ol.quantity"));
                order.setSalesman(salesmanOrder);
                order.setStatus(resultSet.getString("o.status"));
                order.setTotal(new BigDecimal(resultSet.getString("o.total_due")));
                return Optional.of(order);
            }else{
                return Optional.empty();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public Order update(Order dto) {
        return null;
    }

    @Override
    public boolean create(Order dto) {
        return false;
    }

    @Override
    public void delete(long id) {

    }
}
