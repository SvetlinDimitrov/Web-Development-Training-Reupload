import entities.Employee;
import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.*;

public class GetEmployeeWithProject {
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("easy").createEntityManager();
        int id = Integer.parseInt(new Scanner(System.in).nextLine());


        Employee employee = manager.createQuery("Select e from Employee e Where e.id = :id", Employee.class)
                .setParameter("id", id)
                .getSingleResult();

        System.out.printf("%s %s - %s%n",employee.getFirstName() , employee.getLastName(),employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p ->System.out.println(p.getName()));

    }
}
