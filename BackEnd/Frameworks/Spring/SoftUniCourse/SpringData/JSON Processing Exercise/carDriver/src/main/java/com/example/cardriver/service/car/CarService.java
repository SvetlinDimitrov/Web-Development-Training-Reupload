package com.example.cardriver.service.car;

import com.example.cardriver.dtos.quarry2.CarDtoQuarry2;
import com.example.cardriver.dtos.quarry4.CarDtoQuarry4;
import com.example.cardriver.entity.Car;

import java.util.List;

public interface CarService {
    boolean isEmpty();

    void saveCar(Car c);
    Car getRandomCar();

    List<CarDtoQuarry2> getAllCarsByMake(String make);

    List<CarDtoQuarry4> getAllCarsForQuarry4();
}
