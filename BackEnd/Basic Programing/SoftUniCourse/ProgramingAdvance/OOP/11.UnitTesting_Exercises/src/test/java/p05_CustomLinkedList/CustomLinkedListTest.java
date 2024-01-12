package p05_CustomLinkedList;

import static org.junit.Assert.*;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private CustomLinkedList<Integer> data;

    @Before
    public void setUp()  {
        data = new CustomLinkedList<>();
    }

    @Test
    public void testAddGet(){
        Integer numToSearch = 1;
        data.add(numToSearch);
        assertEquals(numToSearch , data.get(0));
        for (int i = 2; i < 10; i++) {
            numToSearch = i;
            data.add(numToSearch);
            assertEquals(numToSearch , data.get(i-1));
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void testGetGivesException(){
        data.get(0);
    }

    @Test
    public void testSetMethod(){
        Integer num1 = 1;
        Integer num2 = 2;
        Integer num3 = 3;
        data.add(num3);
        data.add(num2);
        data.add(num3);
        data.set(data.indexOf(num3),num1);
        assertEquals(num1 , data.get(0));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testSetMethodGivesException(){
        data.set(1,2);
    }
    @Test
    public void testRemoveAtMethod(){
        for (int i = 1; i <= 10; i++) {
            data.add(i);
        }

        Integer firstAddedNum = 1;
        Integer removedValue = data.removeAt(0);
        assertEquals(firstAddedNum , removedValue);

        for (int i = 2; i <=10 ; i++) {
            Integer currentNum = i;
            removedValue = data.removeAt(0);
            assertEquals(currentNum , removedValue);
        }
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveAtThrowsException(){
        data.removeAt(0);
    }

    @Test
    public void testRemoveMethod(){
        for (int i = 0; i < 10; i++) {
            data.add(i);
            assertEquals(0 , data.remove(i));
        }
        assertNotEquals(0 , data.remove(0));
    }
    @Test
    public void testIndexOfMethod(){
        for (int i = 0; i <= 10; i++) {
            data.add(i);
            assertEquals(i , data.indexOf(i));
        }
        assertEquals(10 , data.indexOf(10));
    }
    @Test
    public void testIndexOfMethodIfThrowMinusOneIfInvalid(){
        assertNotEquals(1 , data.indexOf(0));
    }

    @Test
    public void testContainsMethodIfItsWorking(){
        data.add(1);
        assertTrue(data.contains(1));
    }
    @Test
    public void testContainsMethodIfTheValueIsInvalid(){
        data.add(2);
        assertFalse(data.contains(1));
    }
}