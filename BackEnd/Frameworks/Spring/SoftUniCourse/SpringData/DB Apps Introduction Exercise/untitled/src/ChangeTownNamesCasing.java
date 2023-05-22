import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChangeTownNamesCasing {
    private static final String UPDATE_TOWN_NAME =
            "UPDATE `towns` SET `name` = ? WHERE `name` = ?;";
    private static final String GET_ALL_TOWNS =
            "Select `name` from `towns` WHERE `country` = ?;";
    private static int COUNT =0;
    private static ArrayList<String> saveChanges = new ArrayList<>();
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection connection = GetConnection.getConnection();
        String countryName = sc.nextLine();

        PreparedStatement getAllTownsStatement = connection.prepareStatement(GET_ALL_TOWNS);
        PreparedStatement updAllTownsStatement = connection.prepareStatement(UPDATE_TOWN_NAME);
        getAllTownsStatement.setString(1 , countryName);
        ResultSet townsResult = getAllTownsStatement.executeQuery();

        if(townsResult.isBeforeFirst()){
            while(townsResult.next()){
              String townName = townsResult.getString("name");
                updAllTownsStatement.setString(1,townName.toUpperCase());
                updAllTownsStatement.setString(2 , townName);
                updAllTownsStatement.executeUpdate();
                saveChanges.add(townName.toUpperCase());
            }
            System.out.printf("%d town names were affected.%n",saveChanges.size());
            System.out.printf("[%s]", String.join(", ", saveChanges));
        }else{
            System.out.println("No town names were affected.");
        }

        connection.close();
    }
}
