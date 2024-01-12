import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

import java.util.List;

class Main {
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("entity").createEntityManager();

        Owner person1 = new Owner("Pesho");
        Pet pet1 = new Pet("p1");
        Pet pet2 = new Pet("p2");
        Pet pet3 = new Pet("p3");
        person1.getPets().addAll(List.of(pet1, pet2, pet3));
        manager.getTransaction().begin();

        manager.persist(pet1);
        manager.persist(pet2);
        manager.persist(pet3);

        manager.persist(person1);

        manager.getTransaction().commit();
        manager.close();
    }
}
