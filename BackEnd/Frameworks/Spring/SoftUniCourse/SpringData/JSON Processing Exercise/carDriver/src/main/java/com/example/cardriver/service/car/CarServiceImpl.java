package com.example.cardriver.service.car;

import com.example.cardriver.dtos.quarry2.CarDtoQuarry2;
import com.example.cardriver.dtos.quarry4.CarDtoQuarry4;
import com.example.cardriver.dtos.quarry4.PartsDtoQuarry4;
import com.example.cardriver.entity.Car;
import com.example.cardriver.repos.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Random;

@Service
public class CarServiceImpl implements CarService {
    private CarRepository carRepository;

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
    public List<CarDtoQuarry2> getAllCarsByMake(String make) {
        return carRepository.getCarsByMakeOrderByModelAscTravelledDistance(make);
    }

    @Override
    @Transactional
    public List<CarDtoQuarry4> getAllCarsForQuarry4() {
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
}
