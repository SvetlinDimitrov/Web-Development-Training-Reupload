package petStore;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PetStoreTests {
    private Animal  animal;
    private Animal  animal2;
    private PetStore store;

    @Before
    public void setUp(){
        animal = new Animal("Water" , 20 , 60.00);
        animal2 = new Animal("Air" , 40 , 55.00);

        store = new PetStore();

    }
    @Test
    public void testGetAnimals_ShouldReturnTheCorrectCollection(){
        store.addAnimal(animal);
        List<Animal> listToAssert = List.of(animal);
        assertEquals(listToAssert , store.getAnimals());
    }
    @Test
    public void testGetCount_ShouldReturnZero(){
        assertEquals(0 ,store.getCount());
    }
    @Test
    public void testGetCount_ShouldReturnCorrect(){
        store.addAnimal(animal);
        assertEquals(1 ,store.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddAnimal_ShouldThrowException(){
        store.addAnimal(null);
    }
    @Test
    public void testFindAllAnimalsWithMaxKilograms_ShouldReturnTheCorrectOrder(){
        List<Animal> listToAssert = List.of(animal2);
        store.addAnimal(animal);
        store.addAnimal(animal2);
        assertEquals(listToAssert , store.findAllAnimalsWithMaxKilograms(25));
    }
    @Test
    public void testGetTheMostExpensiveAnimal_ShouldReturnTheCorrectOrder(){
        List<Animal> listToAssert = List.of(animal);
        store.addAnimal(animal);
        store.addAnimal(animal2);
        assertEquals(listToAssert.get(0) , store.getTheMostExpensiveAnimal());
    }
    @Test
    public void testGetTheMostExpensiveAnimal_ShouldReturnNull(){
        Animal animal15 = store.getTheMostExpensiveAnimal();
        assertNull(animal15);
    }
    @Test
    public void testFindAllAnimalsBySpecies_ShouldReturnTheCorrectOrder(){
        List<Animal> listToAssert = List.of(animal);
        store.addAnimal(animal);
        store.addAnimal(animal2);
        assertEquals(listToAssert, store.findAllAnimalBySpecie("Water"));
    }
}

