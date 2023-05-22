package garage;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GarageTests {
    Garage garage ;
    Car car;
    @Before
    public void setUp(){
        garage = new Garage();
        car = new Car("Gorin" , 200 ,1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCar_ShouldThrowException(){
        garage.addCar(null);
    }
    @Test
    public void testAddCar_ShouldIncreaseTheCount(){
        garage.addCar(car);
        assertEquals(1 , garage.getCount());
    }
    @Test
    public void testAddCar_ShouldReturnZero(){
        assertEquals(0 , garage.getCount());
    }
    @Test
    public void testGetCars_ShouldReturnTheRightCollection(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        garage.addCar(car);
        assertEquals(cars , garage.getCars());
    }
    @Test
    public void testFindAllCarsWithMaxSpeedAbove_ShouldReturnTheRightCollection(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        garage.addCar(car);
        assertEquals(cars , garage.findAllCarsWithMaxSpeedAbove(100));
    }
    @Test
    public void testGetTheMostExpensiveCar_ShouldReturnNull(){
        assertNull(garage.getTheMostExpensiveCar());
    }
    @Test
    public void testGetTheMostExpensiveCar_ShouldReturnTheMostExpensiveCar(){
        garage.addCar(car);
        garage.addCar(new Car("cotka" , 22 , 0));
        assertEquals(car , garage.getTheMostExpensiveCar());
    }
    @Test
    public void testFindAllCarsByBrand_ShouldReturnZeroSize(){
        garage.addCar(car);
        assertEquals(0 , garage.findAllCarsByBrand("cotka").size());
    }
    @Test
    public void testGetTheMostExpensiveCar_ShouldReturnTheRightCollection(){
        List<Car> cars = new ArrayList<>();
        cars.add(car);
        garage.addCar(car);
        garage.addCar(new Car("cotka" , 22 , 0));
        assertEquals(cars , garage.findAllCarsByBrand("Gorin"));
    }
}