package archeologicalExcavations;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    Excavation data ;
    Archaeologist a1 ;
    Archaeologist a2 ;
    Archaeologist a3 ;

    @Before
    public void setUp(){
        data = new Excavation("DurtyDogs" , 10);
        a1 = new Archaeologist("Divan" , 100);
        a2 = new Archaeologist("Didko", 200);
        a3 = new Archaeologist("MyMilost" , 100000);
    }
    @Test
    public void testGetCount_ShouldReturnAEmptyCollection(){
        int expectedSize =0;
        assertEquals(expectedSize , data.getCount());
    }
    @Test
    public void testGetCount_ShouldReturnATheCorrectAmountOfAddedElements(){
        int expectedSize =3;
        data.addArchaeologist(a1);
        data.addArchaeologist(a2);
        data.addArchaeologist(a3);
        assertEquals(expectedSize , data.getCount());
    }
    @Test
    public void testGetName_ShouldReturnTheCorrectName(){
        String currentName ="DurtyDogs";
        assertEquals(currentName , data.getName());
    }
    @Test
    public void testCapacity_ShouldReturnTheCorrectAmountOfCapacity(){
        int correctAmount = 10;
        assertEquals(correctAmount , data.getCapacity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologist_ShouldThrowExceptionBecauseOfExistingArchaeologist(){
        data.addArchaeologist(a1);
        data.addArchaeologist(a1);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testAddArchaeologist_ShouldThrowExceptionBecauseOfToManyPeople(){
        for (int i = 0; i < 11; i++) {
            data.addArchaeologist(new Archaeologist(String.format("a%d",i) , i));
        }
    }
    @Test
    public void testRemoveArchaeologist_ShouldReturnTrue(){
        data.addArchaeologist(a1);
        assertTrue(data.removeArchaeologist(a1.getName()));
    }
    @Test
    public void testRemoveArchaeologist_ShouldReturnFalse(){
        data.addArchaeologist(a1);
        assertFalse(data.removeArchaeologist(a2.getName()));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetCapacity_ShouldThrowException(){
        Excavation data2 = new Excavation("ExceptionExcepted" , -1);
    }
    @Test(expected = NullPointerException.class)
    public void testSetName_ShouldThrowException(){
        Excavation data2 = new Excavation("     " , 2);
    }

}
