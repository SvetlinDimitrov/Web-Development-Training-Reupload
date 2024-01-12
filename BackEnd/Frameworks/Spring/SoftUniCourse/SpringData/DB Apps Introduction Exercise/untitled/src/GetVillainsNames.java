import java.sql.*;
import java.util.Properties;

public class GetVillainsNames {
    private static final String GET_VILLAINS_NAMES_QUERY =
            "SELECT v.`name` , COUNT(distinct m.`name`) as `count` " +
            "FROM `minions` as m " +
            "JOIN `minions_villains` as mv ON m.id = mv.minion_id " +
            "JOIN `villains` as v ON v.id = mv.villain_id " +
            "group BY v.`name` "+
            "having `count` > ?;";

    public static void main(String[] args) throws SQLException {

        Connection connection = GetConnection.getConnection();

        PreparedStatement statement = connection.prepareStatement(GET_VILLAINS_NAMES_QUERY);
        statement.setInt(1 , 15);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            System.out.printf("%s %d%n", result.getString("name"), result.getInt("count"));
        }
    }
}
