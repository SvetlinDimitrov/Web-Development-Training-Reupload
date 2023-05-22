import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PrintAllMinionNames {
    private static final String GET_ALL_MINIONS = "SELECT `name` from `minions`;";
    private static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) throws SQLException {
        Connection connection = GetConnection.getConnection();
        PreparedStatement getAllMinionsStatement = connection.prepareStatement(GET_ALL_MINIONS);
        ResultSet namesResult = getAllMinionsStatement.executeQuery();

        while(namesResult.next()){
            list.add(namesResult.getString("name"));
        }

        int start = 0;
        int count = 0;
        while(start < list.size()/2){
            if(count % 2== 0){
                System.out.println(list.get(start));
                count++;
            }else{
                System.out.println(list.get(list.size()-1 - start));
                start++;
                count++;
            }
        }
        connection.close();
    }
}
