package com.example.cardriver.service.car;

import com.example.cardriver.dtos.json.quarry.CarDtoQuarry2;
import com.example.cardriver.dtos.json.quarry.CarDtoQuarry4;
import com.example.cardriver.dtos.json.quarry.PartsDtoQuarry4;
import com.example.cardriver.dtos.xml.quarry.CarDtoQuarry2Xml;
import com.example.cardriver.dtos.xml.quarry.CarDtoQuarry4Xml;
import com.example.cardriver.dtos.xml.quarry.PartDtoQuarry4Xml;
import com.example.cardriver.entity.Car;
import com.example.cardriver.repos.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {
    private final CarRepository carRepository;

    public CarServiceImpl(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Override
    public boolean isEmpty() {
        return carRepository.count() == 0;
    }

    @Override
    public void saveCar(Car c) {
        carRepository.save(c);
    }

    @Override
    public Car getRandomCar() {
        Random random = new Random();
        int n = random.nextInt((int) carRepository.count());
        return carRepository.getReferenceById(++n);
    }
    @Override
    @Transactional
    public List<CarDtoQuarry4> getAllCarsForQuarry4Json() {
        return carRepository.findAll()
                .stream()
                .map(c-> {
                    CarDtoQuarry4 car = new CarDtoQuarry4(c.getMake(), c.getModel(), c.getTravelledDistance());
                    car.setParts(c.getParts()
                            .stream()
                            .map(p->new PartsDtoQuarry4(p.getName(),p.getPrice()))
                            .toList());
                    return car;
                })
                .toList();
    }

    @Override
    @Transactional
    public List<CarDtoQuarry4Xml> getAllCarsForQuarry4Xml() {
        return carRepository.findAll()
                .stream()
                .map(c-> {
                    CarDtoQuarry4Xml car = new CarDtoQuarry4Xml(c.getMake(), c.getModel(), c.getTravelledDistance());
                    car.setParts(c.getParts()
                            .stream()
                            .map(p->new PartDtoQuarry4Xml(p.getName(),p.getPrice()))
                            .toList());
                    return car;
                })
                .toList();
    }

    @Override
    @Transactional
    public List<CarDtoQuarry2Xml> getAllCarsByMakeXml(String toyota) {
        return carRepository.getCarsByMakeOrderByModelAscTravelledDistance(toyota)
                .stream()
                .map(car -> new CarDtoQuarry2Xml(car.getId(),
                        car.getMake(),
                        car.getModel(),
                        car.getTravelledDistance()))
                .toList();
    }

    @Override
    @Transactional
    public List<CarDtoQuarry2> getAllCarsByMakeJson(String toyota) {
        return carRepository.getCarsByMakeOrderByModelAscTravelledDistance(toyota)
                .stream()
                .map(car -> new CarDtoQuarry2(car.getId(),
                        car.getMake(),
                        car.getModel(),
                        car.getTravelledDistance()))
                .toList();
    }
}
