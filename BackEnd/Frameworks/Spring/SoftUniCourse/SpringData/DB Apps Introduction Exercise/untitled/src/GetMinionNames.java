import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class GetMinionNames {
    private static final String GET_VILLAIN_NAME_QUERY =
            "SELECT v.`name` " +
                    "FROM `villains` as v " +
                    "WHERE v.id = ?;";
    private static final String GET_MINIONS_BY_EVIL_ID_QUERY =
                    "SELECT m.`name` , m.`age` " +
                    "FROM `minions` as m " +
                    "JOIN `minions_villains` as mv ON m.id = mv.minion_id " +
                    "JOIN `villains` as v ON v.id = mv.villain_id " +
                    "WHERE v.id = ?;";
    private static int COUNTER = 1;
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection connection = GetConnection.getConnection();

        PreparedStatement getMinionsStatement = connection.prepareStatement(GET_MINIONS_BY_EVIL_ID_QUERY);
        PreparedStatement getEvilNameStatement = connection.prepareStatement(GET_VILLAIN_NAME_QUERY);
        int input = Integer.parseInt(sc.nextLine());


        getEvilNameStatement.setInt(1 , input);
        getMinionsStatement.setInt(1 , input);
        ResultSet resultMinions = getMinionsStatement.executeQuery();
        ResultSet resultEvilName = getEvilNameStatement.executeQuery();

        if(resultEvilName.next()){
            System.out.printf("Villain: %s%n",resultEvilName.getString("name"));
            while(resultMinions.next()){
                System.out.printf("%d. %s %d%n",COUNTER , resultMinions.getString("name") ,resultMinions.getInt("age"));
                COUNTER++;
            }
        }else{
            System.out.printf("No villain with ID %d exists in the database.",input);
        }

        connection.close();
    }
}
