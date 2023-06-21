package com.example.battleships.repos;

import com.example.battleships.domain.entity.Ship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ShipRepository extends JpaRepository<Ship , Long> {
    Optional<Ship> findByName(String name);
    @Query(value = "select s from Ship s where s.user.username not in (:name)")
    List<Ship> findAllShipsNotWithTheCurrentUser(String name);

}
