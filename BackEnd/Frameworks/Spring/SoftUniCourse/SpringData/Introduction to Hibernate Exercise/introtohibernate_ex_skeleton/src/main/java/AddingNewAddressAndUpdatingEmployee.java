import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.Scanner;

public class AddingNewAddressAndUpdatingEmployee {
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("easy").createEntityManager();
        String lastName = new Scanner(System.in).nextLine();

        manager.getTransaction().begin();

        Address address = new Address();
        address.setText("Vitoshka 15");
        manager.persist(address);

        manager.createQuery("Update Employee e SET e.address = :address WHERE e.lastName = :ln")
                .setParameter("ln", lastName)
                .setParameter("address", address)
                .executeUpdate();

        manager.getTransaction().commit();
        manager.close();

    }
}
