package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Mechanics;

import java.math.BigInteger;

@Repository
public interface MechanicsRepository extends JpaRepository<Mechanics , Long> {
    Mechanics findByFirstName(String name);

}
