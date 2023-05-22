import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class IncreaseMinionsAge {
    private static final String GET_ALL_MINIONS = "SELECT * from `minions`;";
    private static final String UPDATE_THE_CHOSEN_MINIONS = "UPDATE `minions` SET `name` = lower(`name`) , `age` = `age` +1 WHERE `id` = ?;";

    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        int [] arr = Arrays.stream(sc.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        Connection connection = GetConnection.getConnection();

        PreparedStatement updAllMinionsStatement = connection.prepareStatement(UPDATE_THE_CHOSEN_MINIONS);
        for (int i = 0; i < arr.length; i++) {
            updAllMinionsStatement.setInt(1 ,arr[i]);
            updAllMinionsStatement.executeUpdate();
        }

        PreparedStatement getAllMinionsStatement = connection.prepareStatement(GET_ALL_MINIONS);
        ResultSet allMinions = getAllMinionsStatement.executeQuery();

        while(allMinions.next()){
          System.out.printf("%s %d%n",allMinions.getString("name") , allMinions.getInt("age"));
        }

        connection.close();
    }
}
