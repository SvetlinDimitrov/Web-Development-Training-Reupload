import entities.Department;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class EmployeesMaximumSalaries {
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("easy").createEntityManager();
        Map<String , BigDecimal> map = new HashMap<>();

        manager.createQuery("Select d From Department d" , Department.class)
                .getResultList()
                .stream()
                .filter(d->{
                    BigDecimal decimal = d.getEmployees()
                            .stream()
                            .map(Employee::getSalary)
                            .sorted(Comparator.reverseOrder())
                            .limit(1)
                            .reduce(new BigDecimal("0") , BigDecimal::add);

                    map.put(d.getName() , decimal);

                    return !(new BigDecimal("30000").compareTo(decimal) <=0 && new BigDecimal("70000").compareTo(decimal) >=0);
                })
                .forEach(e-> System.out.printf("%s %.8s%n",e.getName(),map.get(e.getName())));
    }
}
