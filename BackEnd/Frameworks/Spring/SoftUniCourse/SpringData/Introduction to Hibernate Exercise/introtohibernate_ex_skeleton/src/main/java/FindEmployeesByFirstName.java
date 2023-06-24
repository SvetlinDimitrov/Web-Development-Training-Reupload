import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.Scanner;

public class FindEmployeesByFirstName {
    public static void main(String[] args) {
        String pattern = String.format("%s",new Scanner(System.in).nextLine());
        EntityManager manager = Persistence.createEntityManagerFactory("easy").createEntityManager();

        manager.createQuery("Select e From Employee e Where e.firstName LIKE :pattern order by firstName desc " , Employee.class)
                .setParameter("pattern" , String.format("%s",pattern) + "%")
                .getResultList()
                .forEach(e->System.out.printf("%s %s - %s - ($%.8s)%n",e.getFirstName(),e.getLastName(),e.getJobTitle(),e.getSalary()));
    }
}
