package christmasRaces.core;

import christmasRaces.core.interfaces.Controller;
import christmasRaces.entities.cars.Car;
import christmasRaces.entities.cars.MuscleCar;
import christmasRaces.entities.cars.SportsCar;
import christmasRaces.entities.drivers.Driver;
import christmasRaces.entities.drivers.DriverImpl;
import christmasRaces.entities.races.Race;
import christmasRaces.entities.races.RaceImpl;
import christmasRaces.repositories.interfaces.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static christmasRaces.common.ExceptionMessages.*;
import static christmasRaces.common.OutputMessages.*;

public class ControllerImpl implements Controller {
    private Repository<Driver> driverRepository ;
    private Repository<Car> carRepository;
    private Repository<Race> raceRepository;

    public ControllerImpl(Repository<Driver> driverRepository, Repository<Car> carRepository, Repository<Race> raceRepository) {
        this.driverRepository = driverRepository;
        this.carRepository = carRepository;
        this.raceRepository = raceRepository;
    }

    @Override
    public String createDriver(String driver) {
        Driver driverToAdd = new DriverImpl(driver);
        Driver ifIsThere = driverRepository.getByName(driver);
        if(ifIsThere == null){
            driverRepository.add(driverToAdd);
            return String.format(DRIVER_CREATED,driver);
        }
        throw new IllegalArgumentException(String.format(DRIVER_EXISTS,driver));
    }

    @Override
    public String createCar(String type, String model, int horsePower) {
        Car carToAdd = null;
        if(type.equals("Muscle")){
            carToAdd = new MuscleCar(model , horsePower);
        }else if (type.equals("Sports")){
            carToAdd = new SportsCar(model , horsePower);
        }

        Car ifItsThere = carRepository.getByName(model);
        if(ifItsThere == null){
            carRepository.add(carToAdd);
            return String.format(CAR_CREATED,carToAdd.getClass().getSimpleName(),model);
        }else {
            throw new IllegalArgumentException(String.format(CAR_EXISTS,model));
        }
    }

    @Override
    public String addCarToDriver(String driverName, String carModel) {
        Driver driver = driverRepository.getByName(driverName);
        Car car = carRepository.getByName(carModel);
        if(driver == null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }
        if(car == null){
            throw new IllegalArgumentException(String.format(CAR_NOT_FOUND,carModel));
        }
        driver.addCar(car);
        return String.format(CAR_ADDED,driverName , carModel);
    }

    @Override
    public String addDriverToRace(String raceName, String driverName) {
        Driver driver = driverRepository.getByName(driverName);
        Race race = raceRepository.getByName(raceName);
        if(driver == null){
            throw new IllegalArgumentException(String.format(DRIVER_NOT_FOUND,driverName));
        }
        if(race == null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        race.addDriver(driver);
        return String.format(DRIVER_ADDED,driverName,raceName);
    }

    @Override
    public String startRace(String raceName) {
        Race race = raceRepository.getByName(raceName);
        if(race == null){
            throw new IllegalArgumentException(String.format(RACE_NOT_FOUND,raceName));
        }
        if(race.getDrivers().size() <3){
            throw new IllegalArgumentException(String.format(RACE_INVALID,raceName,3));
        }

        List<Driver> drivers = race.getDrivers().stream()
                .sorted((f,s)->Double.compare(s.getCar().calculateRacePoints(race.getLaps()) ,f.getCar().calculateRacePoints(race.getLaps())))
                .collect(Collectors.toList());

        drivers.get(0).winRace();

        StringBuilder print = new StringBuilder();
        print.append(String.format("Driver %s wins %s race.%n",drivers.get(0).getName() , raceName));
        print.append(String.format("Driver %s is second in %s race.%n",drivers.get(1).getName() , raceName));
        print.append(String.format("Driver %s is third in %s race.",drivers.get(2).getName() , raceName));
        return print.toString();
    }

    @Override
    public String createRace(String name, int laps) {
        Race raceToAdd = new RaceImpl(name , laps);
        Race ifItsNotAdded = raceRepository.getByName(name);
        if(ifItsNotAdded == null){
            raceRepository.add(raceToAdd);
            return String.format(RACE_CREATED,name);
        }else{
           throw new IllegalArgumentException(String.format(RACE_EXISTS,name));
        }
    }
}
