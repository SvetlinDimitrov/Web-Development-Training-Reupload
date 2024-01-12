package p02_ExtendedDatabase;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DatabaseTest {
    private Database database;
    Person person1 = new Person(1 , "Gosho");
    Person person2 = new Person(2 , "Tosho");
    Person person3 = new Person(3 , "Pesho");
    Person [] personArrayList = {person1 , person2 , person3};


    @Before
    public void setUp() throws OperationNotSupportedException {
        database = new Database(personArrayList);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfAddThrowsExceptionIfInputIsNull() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void testIfAddingIsOke() throws OperationNotSupportedException {
        database.add(new Person(4 , "ciganin"));
        assertEquals(4 , database.getElements().length);
    }
    @Test
    public void ifRemoveIsRemovingOke() throws OperationNotSupportedException {
        database.remove();
        assertEquals(2 , database.getElements().length);
    }
    @Test(expected = OperationNotSupportedException.class)
    public void ifRemoveIsThrowingExceptions() throws OperationNotSupportedException {
        for (int i = 0; i < 4; i++) {
            database.remove();
        }
    }
    @Test
    public void testIfTheElementsAreGivingProperly(){
        assertArrayEquals(personArrayList , database.getElements());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testIfFindByUsernameIsThrowingExceptions() throws OperationNotSupportedException {
        database.findByUsername(null);
    }
    @Test
    public void testIfPersonIsTheCorrectOne() throws OperationNotSupportedException {
        assertEquals(person1 , database.findByUsername("Gosho"));
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testIfTheSizeIsNotOkeWhenFindingPersons() throws OperationNotSupportedException {
        for (int i = 0; i < 3; i++) {
            database.remove();
        }
        database.findByUsername("Mitko");
    }
    @Test(expected = OperationNotSupportedException.class)
    public void testFailedToFindThePersonById() throws OperationNotSupportedException {
        database.findById(15);
    }
    @Test
    public void testFailedToFindThePersonById2() throws OperationNotSupportedException {
        assertEquals(person1,database.findById(1));
    }
}