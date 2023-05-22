import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AddMinion {
    private static final String CHECK_TOWN_QUERY =
            "SELECT * FROM `towns` WHERE name = ?;";
    private static final String CREATE_TOWN_QUERY =
            "insert into `towns`(`name`) values (?);";
    private static final String CHECK_ID_OF_TOWN =
            "select `id` from `towns` WHERE `name` = ?;";
    private static final String CHECK_EVIL_ID =
            "SELECT `id` FROM `villains` WHERE name = ?;";
    private static final String MINION_ID =
            "SELECT `id` FROM `minions` WHERE name = ?;";
    private static final String CREATE_EVIL =
            "insert into `villains` (`name` , `evilness_factor`) values (? , 'evil');";
    private static final String CREATE_MINION_QUERY =
            "insert into `minions` (`name` , `age` , `town_id`) values (? , ? , ?);";
    private static final String MINION_EVIL_CONNECTION =
            "insert into `minions_villains` (`minion_id` , `villain_id`) values (?,?);";
    public static void main(String[] args) throws SQLException {
        Connection connection = GetConnection.getConnection();
        Scanner sc = new Scanner(System.in);

        System.out.print("Minion: ");
        String minionInput = sc.nextLine();
        System.out.print("Villain: ");
        String evilNameInput = sc.nextLine();

        String minionName = minionInput.split(" ")[0];
        String minionTown = minionInput.split(" ")[2];
        int minionAge = Integer.parseInt(minionInput.split(" ")[1]);
        String evilName = evilNameInput;

        PreparedStatement townStatement = connection.prepareStatement(CHECK_TOWN_QUERY);
        townStatement.setString(1 , minionTown);
        ResultSet townResult = townStatement.executeQuery();
        if(!townResult.next()){
            PreparedStatement createTown = connection.prepareStatement(CREATE_TOWN_QUERY);
            createTown.setString(1, minionTown);
            createTown.executeUpdate();
            System.out.printf("Town %s was added to the database.%n",minionTown);
        }

        PreparedStatement evilStatement = connection.prepareStatement(CHECK_EVIL_ID);
        evilStatement.setString(1 , evilName);
        ResultSet evilResult = evilStatement.executeQuery();
        if(!evilResult.next()){
            PreparedStatement createEvil = connection.prepareStatement(CREATE_EVIL);
            createEvil.setString(1, evilName);
            createEvil.executeUpdate();
            System.out.printf("Villain %s was added to the database.%n",evilName);
        }

        PreparedStatement getIdOfTownStatement = connection.prepareStatement(CHECK_ID_OF_TOWN);
        getIdOfTownStatement.setString(1,minionTown);
        ResultSet idTown = getIdOfTownStatement.executeQuery();
        idTown.next();
        int id_town = idTown.getInt("id");
        PreparedStatement minionStatement = connection.prepareStatement(CREATE_MINION_QUERY);
        minionStatement.setString(1,minionName);
        minionStatement.setInt(2 , minionAge);
        minionStatement.setInt(3 , id_town);
        minionStatement.executeUpdate();

        PreparedStatement getMinionIdStatement = connection.prepareStatement(MINION_ID);
        getMinionIdStatement.setString(1,minionName);
        ResultSet minionIdResult = getMinionIdStatement.executeQuery();
        minionIdResult.next();

        PreparedStatement getEvilIdStatement = connection.prepareStatement(CHECK_EVIL_ID);
        getEvilIdStatement.setString(1,evilName);
        ResultSet evilIdResult = getEvilIdStatement.executeQuery();
        evilIdResult.next();

        PreparedStatement connectMinionToEvilStatement = connection.prepareStatement(MINION_EVIL_CONNECTION);
        connectMinionToEvilStatement.setInt(1 , minionIdResult.getInt("id"));
        connectMinionToEvilStatement.setInt(2 , evilIdResult.getInt("id"));
        connectMinionToEvilStatement.executeUpdate();

        System.out.printf("Successfully added %s to be minion of %s.",minionName , evilName);
        connection.close();

    }
}
