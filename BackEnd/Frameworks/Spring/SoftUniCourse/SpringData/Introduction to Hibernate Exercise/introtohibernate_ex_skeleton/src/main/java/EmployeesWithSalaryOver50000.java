import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("easy")
                .createEntityManager();

        manager.createQuery("Select e from Employee e where e.salary >= 50000", Employee.class)
                .getResultList()
                .stream()
                .map(Employee::getFirstName)
                .forEach(System.out::println);
    }
}
