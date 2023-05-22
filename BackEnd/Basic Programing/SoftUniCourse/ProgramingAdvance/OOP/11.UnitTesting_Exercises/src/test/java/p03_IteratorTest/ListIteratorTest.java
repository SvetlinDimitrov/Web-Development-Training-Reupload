package p03_IteratorTest;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {
    ListIterator iterator ;
    @Before
    public void setUp() throws OperationNotSupportedException {
        iterator = new ListIterator("yes", "no");
    }
    @Test
    public void testIfHasNextIsWorkingFine(){
        assertTrue(iterator.hasNext());
        iterator.move();
        assertFalse(iterator.hasNext());
        assertFalse(iterator.move());
    }
    @Test (expected = IllegalStateException.class)
    public void testPrintFail() throws OperationNotSupportedException {
        String [] strings = new String[0];
        iterator = new ListIterator(strings);
        iterator.print();
    }

}