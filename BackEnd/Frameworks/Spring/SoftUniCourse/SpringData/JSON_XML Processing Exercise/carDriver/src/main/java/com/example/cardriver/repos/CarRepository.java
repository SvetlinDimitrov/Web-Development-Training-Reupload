package com.example.cardriver.repos;

import com.example.cardriver.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT c FROM Car c where c.make = :make " +
            "order by c.model asc , c.travelledDistance desc")
    List<Car> getCarsByMakeOrderByModelAscTravelledDistance(String make);
}

