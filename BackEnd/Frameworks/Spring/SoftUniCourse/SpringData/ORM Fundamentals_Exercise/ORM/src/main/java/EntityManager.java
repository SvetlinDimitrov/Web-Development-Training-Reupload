import anotationTest.Column;
import anotationTest.Entity;
import anotationTest.Id;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class EntityManager<E> implements DatabaseContent<E> {

    private static final String INSERT = "INSERT INTO %s (%s) VALUES (%s);";
    private static final String UPDATE = "UPDATE %s SET %s WHERE id = %s";
    private static final String SELECT_ALL = "SELECT * FROM %s";
    private static final String SELECT_WITH_CONDITION = "SELECT * FROM %s %s";
    private static final String CREATE_TABLE = "CREATE TABLE %s (%s);";
    private static final String ALTER_TABLE = "ALTER TABLE %s ADD %s datatype;";

    @Override
    public boolean persist(E entity) throws Exception {
        if (getId(entity) == 0) {
            return insertRecuest(entity);
        }
        return updRecuest(entity);
    }

    @Override
    public Iterable<E> find(Class<E> table) throws Exception {
        return find(table, null);
    }

    @Override
    public Iterable<E> find(Class<E> table, String where) throws Exception {
        ArrayList<Object> list = new ArrayList<>();
        String selectStatement = "";

        if (!table.isAnnotationPresent(Entity.class)) {
            throw new Exception("Wrong table budy");
        }

        if (where == null) {
            selectStatement = String.format(SELECT_ALL, table.getAnnotation(Entity.class).name());
        }else{
            selectStatement = String.format(SELECT_WITH_CONDITION , table.getAnnotation(Entity.class).name() , where);
        }

        ResultSet resultSet = MyConnector.getConnection().prepareStatement(selectStatement).executeQuery();
        getAllEntatys(table, list, resultSet);
        return (Iterable<E>) list;
    }


    @Override
    public E findFirst(Class<E> table) throws Exception {
        return findFirst(table , null);
    }

    @Override
    public E findFirst(Class<E> table, String where) throws Exception {
        ArrayList<E> result = new ArrayList<>();
        Iterable<E> iterable = find(table, where);
        iterable.forEach(result::add);
        return result.get(0);
    }

    @Override
    public void doCreate(Class<E> entityClass) throws Exception {
        Entity annotation = entityClass.getAnnotation(Entity.class);
        if(annotation == null){
            throw new Exception("Problem buddy , no Entity si putNal nad classA , go sega i si si go putNi 4e da know what to do");
        }
        E entity = entityClass.getDeclaredConstructor().newInstance();
        String tableName = getTableName(entity);

        Field[] declaredFields = entityClass.getDeclaredFields();
        ArrayList<String> columnForCreate = new ArrayList<>();

        for (Field field : declaredFields) {
            String columnToAdd = makeMeColumn(field);
            columnForCreate.add(columnToAdd);
        }
        String CREATE_STATEMENT = String.format(CREATE_TABLE , tableName, String.join("," , columnForCreate));
        MyConnector.getConnection().prepareStatement(CREATE_STATEMENT).execute();
    }

    @Override
    public void alterTable(E entity) throws Exception {
        Entity annotation = entity.getClass().getAnnotation(Entity.class);
        if(annotation == null){
            throw new Exception("Problem buddy , no Entity si putNal nad classA , go sega i si si go putNi 4e da know what to do");
        }
        String tableName = getTableName(entity);


    }

    private String makeMeColumn(Field field) {
        String columnToReturn = "";
        if(field.isAnnotationPresent(Id.class)){
            columnToReturn = String.format("%s %s %s %s",field.getAnnotation(Id.class).name() , "INT" , "PRIMARY KEY" , "AUTO_INCREMENT");
        }else if(field.isAnnotationPresent(Column.class)){
            if(field.getType() == int.class || field.getType() == Integer.class){
                columnToReturn = String.format("%s %s",field.getAnnotation(Column.class).name() , "INT");
            }else{
                columnToReturn = String.format("%s %s",field.getAnnotation(Column.class).name() , "VARCHAR(45)");
            }
        }
        return columnToReturn;
    }

    private boolean updRecuest(E entity) throws Exception {
        String tableName = getTableName(entity);
        String id = String.valueOf(getId(entity));
        Map<String, String> map = getPair(entity);
        ArrayList<String> list = new ArrayList<>();

        map.forEach((key, value) -> list.add(String.format("%s = %s", key, value)));
        String updStatement = String.format(UPDATE, tableName, String.join(",", list), id);
        return MyConnector.getConnection().prepareStatement(updStatement).execute();
    }

    private Map<String, String> getPair(E entity) throws IllegalAccessException {
        Map<String, String> map = new HashMap<>();

        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Column.class)) {
                String nameField = field.getAnnotation(Column.class).name();
                String valueField = String.format("\"%s\"", field.get(entity).toString());
                map.put(nameField, valueField);
            }
        }
        return map;
    }

    private boolean insertRecuest(E entity) throws SQLException, IllegalAccessException {
        String tableName = getTableName(entity);
        String rowTableNames = getRowNames(entity);
        String valuesToInsert = getValuesToInsert(entity);

        String insertStatement = String.format(INSERT, tableName, rowTableNames, valuesToInsert);
        return MyConnector.getConnection().prepareStatement(insertStatement).execute();
    }

    private String getValuesToInsert(E entity) throws IllegalAccessException {
        ArrayList<String> list = new ArrayList<>();
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Column.class)) {
                list.add(String.format("\"%s\"", field.get(entity).toString()));
            }
        }
        return String.join(",", list);
    }

    private String getRowNames(E entity) {
        return Arrays.stream(entity.getClass().getDeclaredFields())
                .filter(e -> e.isAnnotationPresent(Column.class))
                .map(e -> e.getAnnotation(Column.class).name())
                .collect(Collectors.joining(","));
    }

    private String getTableName(E entity) {
        return entity.getClass().getAnnotation(Entity.class).name();
    }

    private int getId(E entity) throws Exception {
        for (Field field : entity.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(Id.class)) {
                return Integer.parseInt(field.get(entity).toString());
            }
        }
        throw new Exception("Bro no tableName exist");
    }

    private void getAllEntatys(Class<E> table, ArrayList<Object> list, ResultSet resultSet) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, SQLException {

        while (resultSet.next()) {
            E user = table.getDeclaredConstructor().newInstance();
            for (Field field : user.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                if (field.isAnnotationPresent(Column.class) || field.isAnnotationPresent(Id.class)) {

                    String name = field.isAnnotationPresent(Column.class)
                            ? field.getAnnotation(Column.class).name() : field.getAnnotation(Id.class).name();

                    if (field.getType() == int.class || field.getType() == Integer.class) {
                        int value = resultSet.getInt(name);
                        field.set(user, value);
                    } else if (field.getType() == LocalDate.class) {
                        field.set(user, LocalDate.parse(resultSet.getString(name)));
                    } else {
                        field.set(user, resultSet.getString(name));
                    }
                }

            }
            list.add(user);

        }

    }
}
