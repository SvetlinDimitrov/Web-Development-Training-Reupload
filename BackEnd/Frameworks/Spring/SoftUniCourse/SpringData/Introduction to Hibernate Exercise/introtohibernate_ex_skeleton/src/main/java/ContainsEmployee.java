import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("easy");
        EntityManager manager = entityManagerFactory.createEntityManager();

        List<Employee> resultList = manager.createQuery("Select e from Employee e WHERE e.firstName = :fn AND e.lastName = :ln", Employee.class)
                .setParameter("fn" , name.split(" ")[0])
                .setParameter("ln" , name.split(" ")[1])
                .getResultList();


        if(resultList.size() != 0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
