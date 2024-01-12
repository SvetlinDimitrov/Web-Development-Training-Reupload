import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.Comparator;

public class FindLatest10Projects {
    private static final String OUTPUT_FORMAT =
            "Project name: %s%n" +
            "     Project Description: %s%n" +
            "     Project Start Date:%s%n" +
            "     Project End Date: %s%n";
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("easy").createEntityManager();

        manager.createQuery("Select p from Project p order by startDate desc" , Project.class)
                .getResultList()
                .stream()
                .limit(10)
                .sorted(Comparator.comparing(Project::getName))
                .forEach(p-> System.out.printf(OUTPUT_FORMAT ,p.getName()
                        ,p.getDescription()
                        ,p.getStartDate().toString()
                        ,p.getEndDate() == null ? null : p.getEndDate().toString()));
    }
}
