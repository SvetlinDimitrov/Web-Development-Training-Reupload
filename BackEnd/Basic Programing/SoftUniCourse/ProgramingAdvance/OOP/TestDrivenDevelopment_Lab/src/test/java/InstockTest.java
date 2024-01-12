import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest implements Iterable{
    private Instock data;
    private final static Product PRODUCT1 = new Product("eat" , 24.0 , 1);
    private final static Product PRODUCT2 = new Product("dog" , 240.0 , 1);
    private final static Product PRODUCT3 = new Product("divan" , 2.0 , 1);

    @Before
    public void setUp()  {
        data = new Instock();
    }

    @Test
    public void testMethodAddIfItsWorking(){
        data.add(PRODUCT1);
        assertTrue(data.contains(PRODUCT1));
    }

    @Test
    public void testMethodAddForMultiAdding(){
        data.add(PRODUCT1);
        data.add(PRODUCT2);
        data.add(PRODUCT3);
        assertTrue(data.contains(PRODUCT1));
        assertTrue(data.contains(PRODUCT2));
        assertTrue(data.contains(PRODUCT3));
        assertFalse(data.contains(null));
    }

    @Test
    public void testIfMethodGetCountReturnsTheTrueValue(){
        assertEquals(0 , data.getCount());
        data.add(PRODUCT1);
        assertEquals(1 , data.getCount());
        data.add(PRODUCT2);
        data.add(PRODUCT3);
        assertEquals(3 , data.getCount());
    }
    @Test
    public void testIfFindByIndexIsWorkingCorrect(){
        data.add(PRODUCT1);
        Product currentProduct = data.find(0);
        assertEquals(PRODUCT1 , currentProduct);
        data.add(PRODUCT2);
        data.add(PRODUCT3);
        currentProduct = data.find(2);
        assertEquals(PRODUCT3 , currentProduct);

    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testIfFindByIndexIsThrowingExceptionForWrongIndex(){
        data.find(0);
    }

    @Test
    public void testIfMethodChangingQuantityByLabelIsWorking(){
        data.add(PRODUCT1);
        int currentQuantity = PRODUCT1.getQuantity();
        String quantity = PRODUCT1.getLabel();
        data.changeQuantity(quantity , 2);
        int newQuantity = data.find(0).getQuantity();
        assertNotEquals(currentQuantity , newQuantity);
    }

    @Test(expected =IllegalArgumentException.class )
    public void testIfMethodChangingQuantityByLabelThrowsExceptions(){
        String quantity = PRODUCT1.getLabel();
        data.changeQuantity(quantity , 2);
    }

    @Test
    public void testFindFirstByAlphabeticalOrder(){
        addMulty();
        int limitProducts = 2;
        data.findFirstByAlphabeticalOrder(limitProducts);
        List<Product> ordered =new ArrayList<>();
        ordered.add(PRODUCT3);
        ordered.add(PRODUCT1);



    }

    private void addMulty() {
        data.add(PRODUCT1);
        data.add(PRODUCT3);
        data.add(PRODUCT2);
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}