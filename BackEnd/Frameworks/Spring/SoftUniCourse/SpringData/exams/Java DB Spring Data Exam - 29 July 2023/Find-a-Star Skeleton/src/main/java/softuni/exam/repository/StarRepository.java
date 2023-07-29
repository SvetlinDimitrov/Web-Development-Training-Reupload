package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Star;
import softuni.exam.util.enums.StarType;

import java.util.List;

@Repository
public interface StarRepository extends JpaRepository<Star, Long> {

    @Query("select s from Star s where s.star = :type and s.observers.size = 0 " +
            "order by  s.lightYears ")
    List<Star> extractsSpecificStars(StarType type);

}
