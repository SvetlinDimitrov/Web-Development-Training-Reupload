import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveVillain {
    private static ArrayList<Integer> toRemove = new ArrayList<>();
    private static final String CHECK_CURRENT_EVIL_ID = "SELECT `minion_id` FROM `minions_villains` WHERE `villain_id` = ?;";
    private static final String DELETE_ALL_MINION_CONNECTION_WITH_EVIL = "DELETE FROM `minions_villains` WHERE `minion_id` = ?;";
    private static final String DELETE_EVIL = "DELETE FROM `villains` WHERE `id` = ?;";
    private static final String GET_EVIL_NAME = "Select * FROM `villains` WHERE `id` = ?;";
    public static void main(String[] args) throws SQLException {
        Scanner sc = new Scanner(System.in);
        Connection connection = GetConnection.getConnection();
        int id = sc.nextInt();

        PreparedStatement checkIdEvil = connection.prepareStatement(CHECK_CURRENT_EVIL_ID);
        checkIdEvil.setInt(1,id);
        ResultSet evilIdResult = checkIdEvil.executeQuery();

        while(evilIdResult.next()){
            toRemove.add(evilIdResult.getInt("minion_id"));
        }

        PreparedStatement removeConnectionWithEvilStatement = connection.prepareStatement(DELETE_ALL_MINION_CONNECTION_WITH_EVIL);

        PreparedStatement removeEvilStatement = connection.prepareStatement(DELETE_EVIL);
        removeEvilStatement.setInt(1, id);
        PreparedStatement getEvilNameStatement = connection.prepareStatement(GET_EVIL_NAME);
        getEvilNameStatement.setInt(1 , id);



        if(toRemove.size() != 0){
            for (int i = 0; i < toRemove.size(); i++) {
                removeConnectionWithEvilStatement.setInt(1, toRemove.get(i));
                removeConnectionWithEvilStatement.executeUpdate();
            }
            ResultSet evilNameResult = getEvilNameStatement.executeQuery();
            evilNameResult.next();
            removeEvilStatement.executeUpdate();
            System.out.printf("%s was deleted%n",evilNameResult.getString("name"));
            System.out.printf("%d minions released",toRemove.size());
        }else{
            System.out.printf("No such villain was found");
        }

        connection.close();
    }
}
