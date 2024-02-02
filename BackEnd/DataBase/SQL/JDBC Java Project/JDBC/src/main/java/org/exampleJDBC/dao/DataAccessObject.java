package org.exampleJDBC.dao;

import org.exampleJDBC.dao.dto.DataTransferObject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

public abstract class DataAccessObject <T extends DataTransferObject>{
    protected final Connection connection;
    protected final static String LAST_VAL = "select last_value from";
    protected DataAccessObject(Connection connection) {
        this.connection = connection;
    }

    public abstract Optional<T> findById(long id);
    public abstract List<T> findAll();
    public abstract T update (T dto);
    public abstract boolean create (T dto);
    public abstract void delete (long id);

    protected int getLastVal(String sequence){
        int key = 0;
        String sql = LAST_VAL + sequence;
        try (Statement statement = connection.createStatement()){
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                key = rs.getInt(1);
            }
            return key;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
