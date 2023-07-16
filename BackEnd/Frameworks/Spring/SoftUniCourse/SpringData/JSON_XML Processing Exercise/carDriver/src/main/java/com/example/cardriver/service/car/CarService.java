package com.example.cardriver.service.car;

import com.example.cardriver.dtos.json.quarry.CarDtoQuarry2;
import com.example.cardriver.dtos.json.quarry.CarDtoQuarry4;
import com.example.cardriver.dtos.xml.quarry.CarDtoQuarry2Xml;
import com.example.cardriver.dtos.xml.quarry.CarDtoQuarry4Xml;
import com.example.cardriver.entity.Car;

import java.util.List;

public interface CarService {
    boolean isEmpty();

    void saveCar(Car c);
    Car getRandomCar();

    List<CarDtoQuarry4> getAllCarsForQuarry4Json();

    List<CarDtoQuarry4Xml> getAllCarsForQuarry4Xml();

    List<CarDtoQuarry2Xml> getAllCarsByMakeXml(String toyota);

    List<CarDtoQuarry2> getAllCarsByMakeJson(String toyota);
}
