import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.Set;

public class RemoveTowns {
    public static void main(String[] args) {

        String name = new Scanner(System.in).nextLine();
        EntityManager manager = Persistence
                .createEntityManagerFactory("easy").createEntityManager();
        manager.getTransaction().begin();

        List<Address> addresses = manager.createQuery("select a from Address a where town.name = :name" , Address.class)
                .setParameter("name", name)
                .getResultList();

        List<Employee> employees = manager.createQuery("select a from Employee a" , Employee.class)
                .getResultList();


        for(Address address : addresses){
            employees
                    .stream().filter(e->e.getAddress() != null)
                    .forEach(e->{
                if (Objects.equals(e.getAddress().getId(), address.getId())) {
                    e.setAddress(null);
                    manager.persist(e);
                }
            });
            manager.remove(address);
        }

        int i = addresses.size();

        manager.getTransaction().commit();
        manager.close();

        System.out.printf("%d address in %s deleted%n", i , name);
    }

}
