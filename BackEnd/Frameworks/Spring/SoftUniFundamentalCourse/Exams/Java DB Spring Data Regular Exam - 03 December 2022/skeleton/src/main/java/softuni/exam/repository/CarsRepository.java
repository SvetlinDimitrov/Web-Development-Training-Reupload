package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Car;

import java.math.BigInteger;

@Repository
public interface CarsRepository extends JpaRepository<Car, Long> {

}
