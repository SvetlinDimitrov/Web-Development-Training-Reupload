package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Task;

import java.math.BigInteger;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {

}
