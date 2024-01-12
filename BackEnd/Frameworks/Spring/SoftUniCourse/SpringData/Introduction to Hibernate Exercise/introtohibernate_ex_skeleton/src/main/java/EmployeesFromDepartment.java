import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class EmployeesFromDepartment {
    private final static String FORMAT = "%S %S from %S - $%.8s%n";
    public static void main(String[] args) {
        EntityManager manager = Persistence
                .createEntityManagerFactory("easy")
                .createEntityManager();

        manager.createQuery("select e from Employee e WHERE e.department.name = :dpName order by e.salary , e.id", Employee.class)
                .setParameter("dpName" , "Research and Development")
                .getResultList()
                .forEach(e->{
                    System.out.printf(FORMAT , e.getFirstName() , e.getLastName() , e.getDepartment().getName() ,e.getSalary());
                });
    }
}
