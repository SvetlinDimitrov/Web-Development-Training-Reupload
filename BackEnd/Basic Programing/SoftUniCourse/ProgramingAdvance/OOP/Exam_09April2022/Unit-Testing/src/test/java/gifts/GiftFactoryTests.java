package gifts;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class GiftFactoryTests {
    GiftFactory factory ;
    Gift gift1 ;

    @Before
    public void setUp(){
        factory = new GiftFactory();
        gift1 =new Gift("Cat" , 120);
    }
    @Test
    public void testGetCount_ShouldReturnZero(){
        assertEquals(0 , factory.getCount());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testCreateGift_ShouldThrowException(){
        factory.createGift(gift1);
        factory.createGift(gift1);
    }
    @Test
    public void testCreateGift_ShouldWorkCorrectly(){
        assertEquals("Successfully added gift Cat with magic 120.00.",factory.createGift(gift1));
        assertEquals(1 , factory.getCount());
    }
    @Test(expected = NullPointerException.class)
    public void testRemoveGift_ShouldThrowNullPointerException(){
        factory.removeGift(null);
    }
    @Test(expected = NullPointerException.class)
    public void testRemoveGift_ShouldThrowNullPointerExceptionAgain(){
        factory.removeGift("         ");
    }
    @Test
    public void testRemoveGift_ShouldRemoveItCorrectly(){
        factory.createGift(gift1);
        factory.removeGift("Cat");
        assertEquals(0,factory.getCount());
    }
    @Test
    public void testGetPresentWithLeastMagic_ShouldReturnNull(){
        assertNull(factory.getPresentWithLeastMagic());
    }
    @Test
    public void testGetPresentWithLeastMagic_ShouldReturnCorrectly(){
        factory.createGift(gift1);
        assertEquals( gift1 , factory.getPresentWithLeastMagic());
    }
    @Test
    public void testGetPresent_ShouldReturnNull(){
        assertNull(factory.getPresent(null));
    }
    @Test
    public void testGetPresent_ShouldReturnCorrectly(){
        factory.createGift(gift1);
        assertEquals( gift1, factory.getPresent(gift1.getType()));
    }
    @Test
    public void testGetPresents_ShouldReturnCorrectly(){
        factory.createGift(gift1);
        for (Gift present : factory.getPresents()) {
            assertEquals(gift1 , present);
        }
    }

}
