import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseAgeStoredProcedure {
    private static final String UPDATE_AGE = "Update minions Set age = age + 1 where id = ?;";
    private static final String SELECT_BY_ID = "select * from minions where id = ?";
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int idMinion = Integer.parseInt(sc.nextLine());
        Connection connection = GetConnection.getConnection();

        try {
            connection.setAutoCommit(false);
            PreparedStatement updAllMinionsStatement =
                    connection.prepareStatement(UPDATE_AGE);
            updAllMinionsStatement.setInt(1,idMinion);
            updAllMinionsStatement.executeUpdate();

            connection.commit();
            PreparedStatement getMinionsStatement =
                    connection.prepareStatement(SELECT_BY_ID);
            getMinionsStatement.setInt(1 , idMinion);
            ResultSet resultSet = getMinionsStatement.executeQuery();
            if(resultSet.next()){
                String output = String.format("Name = %s , Age = %s",
                        resultSet.getString("name"),
                        resultSet.getInt("age"));
                System.out.println(output);
            }

        } catch(SQLException se){

            connection.rollback();
        }


    }
}
