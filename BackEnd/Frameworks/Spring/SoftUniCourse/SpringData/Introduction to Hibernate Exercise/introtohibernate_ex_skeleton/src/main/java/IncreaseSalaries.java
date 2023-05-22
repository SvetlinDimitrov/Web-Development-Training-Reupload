import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class IncreaseSalaries {
    public static void main(String[] args) {
        //Engineering, Tool Design, Marketing or Information Services
        EntityManager manager = Persistence.createEntityManagerFactory("easy").createEntityManager();

        manager.getTransaction().begin();

        manager.createQuery("Select e from Employee e Where e.department.name In (:g1,:g2,:g3,:g4)", Employee.class)
                .setParameter("g1" , "Engineering")
                .setParameter("g2" , "Tool Design")
                .setParameter("g3" , "Marketing")
                .setParameter("g4" , "Information Services")
                .getResultList()
                .forEach(e-> {
                    e.setSalary(e.getSalary().add(e.getSalary().multiply(new BigDecimal("0.12"))));
                    manager.persist(e);
                    System.out.printf("%s %s ($%.8s)%n",e.getFirstName() ,e.getLastName() , e.getSalary());
                });

        manager.getTransaction().commit();
        manager.close();
    }
}
