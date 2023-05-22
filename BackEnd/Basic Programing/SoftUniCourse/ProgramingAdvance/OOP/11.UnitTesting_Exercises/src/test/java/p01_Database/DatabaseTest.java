package p01_Database;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    private Integer [] arr ;


    @Before
    public void setUp() throws Exception {
        arr = new Integer[]{1, 2, 3, 4, 5};
        database = new Database(arr);
    }

    @Test
    public void testTheSizeOfTheNewObject(){
        assertEquals(arr.length , database.getElements().length);
    }
    @Test
    public void testContractorCreating(){
        assertArrayEquals(arr, database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFallAddingNewElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testAddingNewElement() throws OperationNotSupportedException {
        Integer newInt = 6;
        database.add(newInt);
        assertNotEquals(arr.length , database.getElements().length);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testSettingNewElementsFaild() throws OperationNotSupportedException {
        Integer[] arr2 = new Integer[0];
        database = new Database(arr2);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveExpetion() throws OperationNotSupportedException {
        for (int i = 0; i < 6; i++) {
            database.remove();
        }
    }
}