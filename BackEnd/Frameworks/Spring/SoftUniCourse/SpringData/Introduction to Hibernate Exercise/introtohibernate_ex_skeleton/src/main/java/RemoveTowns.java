import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {
        String name = new Scanner(System.in).nextLine();
        EntityManager manager = Persistence.createEntityManagerFactory("easy").createEntityManager();



    }

}
