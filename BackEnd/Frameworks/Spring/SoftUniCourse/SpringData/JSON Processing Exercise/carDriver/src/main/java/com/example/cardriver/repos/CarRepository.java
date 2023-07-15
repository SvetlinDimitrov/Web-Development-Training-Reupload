package com.example.cardriver.repos;

import com.example.cardriver.dtos.quarry2.CarDtoQuarry2;
import com.example.cardriver.entity.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {
    @Query("SELECT new com.example.cardriver.dtos.quarry2.CarDtoQuarry2(c.id , c.make , c.model,c.travelledDistance)" +
            " FROM Car c where c.make = :make " +
            "order by c.model asc , c.travelledDistance desc")
    List<CarDtoQuarry2> getCarsByMakeOrderByModelAscTravelledDistance(String make);
}

