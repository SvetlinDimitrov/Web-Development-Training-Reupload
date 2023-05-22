import entities.Employee;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("easy");
        EntityManager manager = entityManagerFactory.createEntityManager();
        manager.getTransaction().begin();

        manager.createQuery("select t from Town as t WHERE Char_length(t.name) >= 5", Town.class)
                .getResultList()
                .forEach(e->{
                    e.setName(e.getName().toUpperCase());
                    manager.persist(e);
                });

        manager.getTransaction().commit();
        manager.close();
    }
}
