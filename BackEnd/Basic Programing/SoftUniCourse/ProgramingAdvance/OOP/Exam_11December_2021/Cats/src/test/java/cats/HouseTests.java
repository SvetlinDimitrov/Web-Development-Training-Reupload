package cats;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    House house ;
    Cat cat ;

    @Before
    public void setUp(){
        house = new House("Divania" , 10);
        cat = new Cat("Divanka");
    }

    @Test(expected = NullPointerException.class)
    public void testSetName_ShouldThrowException(){
        House house2 = new House(null , 10);
    }

    @Test(expected = NullPointerException.class)
    public void testSetName_ShouldThrowException2(){
        House house2 = new House("      " , 10);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity_ShouldThrowException(){
        House house2 = new House("fuckyea" , -1);
    }

    @Test
    public void testGetCapacity_ShouldReturnTheCorrectCapacity(){
        assertEquals(10 , house.getCapacity());
    }
    @Test
    public void testGetCount_ShouldReturnTheCorrectCount(){
        assertEquals(0 , house.getCount());
    }
    @Test
    public void testAddCat_ShouldAddTheCat(){
        house.addCat(cat);
        assertEquals(1 , house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddCat_ShouldThrowException(){
        for (int i = 0; i < 100; i++) {
            house.addCat(new Cat("i"));
        }
    }
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveCat_ShouldThrowException(){
        house.removeCat(cat.getName());
    }
    @Test
    public void testRemoveCat_ShouldRemoveTheCatSuccessful(){
        house.addCat(cat);
        house.removeCat(cat.getName());
        assertEquals(0 , house.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCatForSale_ShouldThrowException(){
        house.catForSale(cat.getName());
    }
    @Test
    public void testCatForSale_ShouldDoItSuccessfully(){
        house.addCat(cat);
        Cat cat1 = house.catForSale(cat.getName());

        assertFalse(cat1.isHungry());
    }
    @Test
    public void testStatistics_ShouldDoItSuccessfully(){
        String yes = "The cat Divanka is in the house Divania!";
        house.addCat(cat);
        assertEquals(yes , house.statistics());
    }
    @Test
    public void testGetName_ShouldDoItSuccessfully(){
        house.addCat(cat);
        assertEquals("Divania" , house.getName());
    }
}
