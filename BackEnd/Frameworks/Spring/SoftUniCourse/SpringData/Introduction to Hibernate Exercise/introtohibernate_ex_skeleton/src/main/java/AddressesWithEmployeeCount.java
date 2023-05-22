import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class AddressesWithEmployeeCount {
    public static void main(String[] args) {
        EntityManager easy = Persistence.createEntityManagerFactory("easy").createEntityManager();

        easy.createQuery("select a from Address a order by a.employees.size desc", Address.class)
                .setMaxResults(10)
                .getResultList()
                .forEach(e->{
                    System.out.printf("%s , %s - %d employees%n",e.getText()
                            ,e.getTown() == null ? " " : e.getTown().getName()
                            ,e.getEmployees().size());
                });
    }
}
