package toyStore;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class ToyStoryTest {
    ToyStore store ;
    Toy toy;

    @Before
    public void setUp(){
        store = new ToyStore();
        toy = new Toy("ProLama" , "1");
    }
    @Test (expected = IllegalArgumentException.class)
    public void addToy_ShouldThrowException() throws OperationNotSupportedException {
        store.addToy("J" , toy);
    }
    @Test (expected = OperationNotSupportedException.class)
    public void addToy_ShouldThrowException2() throws OperationNotSupportedException {
        store.addToy("G" , null);
    }
    @Test (expected = IllegalArgumentException.class)
    public void addToy_ShouldThrowException3() throws OperationNotSupportedException {
        store.addToy("G" , toy);
        store.addToy("G" , toy);
    }
    @Test
    public void addToy_ShouldTAllBeFine() throws OperationNotSupportedException {
        Assert.assertEquals("Toy:1 placed successfully!", store.addToy("G", toy));
    }
    @Test (expected = IllegalArgumentException.class)
    public void removeToy_ShouldThrowException() {
        store.removeToy("P" , toy);
    }
    @Test (expected = IllegalArgumentException.class)
    public void removeToy_ShouldThrowException2() throws OperationNotSupportedException {
        store.addToy("G",toy);
        String yes = toy.getManufacturer();
        String yes2 = toy.getToyId();
        store.removeToy("G" ,new Toy("nz" , "2"));
    }
    @Test
    public void removeToy_ShouldTAllBeFine() throws OperationNotSupportedException {
        store.addToy("G", toy);
        Assert.assertEquals("Remove toy:1 successfully!" , store.removeToy("G" , toy));
    }
    @Test
    public void getToyShelf_ShouldTAllBeFine() throws OperationNotSupportedException {
        for (Toy value : store.getToyShelf().values()) {
            Assert.assertNull(value);
        }
    }
}