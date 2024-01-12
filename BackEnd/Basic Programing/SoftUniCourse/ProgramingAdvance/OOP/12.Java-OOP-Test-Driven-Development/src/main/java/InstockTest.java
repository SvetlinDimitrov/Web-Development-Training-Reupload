import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class InstockTest {
    private Instock instock;
    private Product product1 = new Product("cat" ,12.00 ,1);
    private Product product2 = new Product("dog" ,15.00 ,2);
    private Product product3 = new Product("ass" ,19.00 ,3);
    private Product product4 = new Product("butt" ,20.00 ,4);
    private Product product5 = new Product("buttAss" ,21.00 ,4);
    private void MultiAdding(List<Product>list) {
        instock.add(product1);
        instock.add(product2);
        instock.add(product3);
        instock.add(product4);
        instock.add(product5);
        list.add(product1);
        list.add(product2);
        list.add(product3);
        list.add(product4);
        list.add(product5);

    }

    @Before
    public void setUp(){
        instock = new Instock();
    }

    @Test
    public void testAdd_SingleAdd(){
        instock.add(product1);
        assertTrue(instock.contains(product1));
    }

    @Test
    public void testAdd_MultyAdd(){
        instock.add(product1);
        instock.add(product2);
        instock.add(product3);
        int expectedSize = 3;
        assertEquals(expectedSize , instock.getCount());
    }

    @Test
    public void testAdd_AddingTheSameProductTwiceShouldNotBeAllowed(){
        instock.add(product1);
        instock.add(product1);
        int expectedSize = 1;
        assertEquals(expectedSize , instock.getCount());
    }

    @Test
    public void testContains_SearchingForValidProductShouldReturnTrue(){
        testAdd_SingleAdd();
    }

    @Test
    public void testContains_SearchingForInvalidProductShouldReturnFalse(){
        instock.add(product1);
        assertFalse(instock.contains(product2));
    }

    @Test
    public void testContains_OnAnEmptyDataShouldThrowFalse(){
        assertFalse(instock.contains(product2));
    }

    @Test
    public void testGetCount_WithOneElement(){
        instock.add(product1);
        int expectedSize = 1;
        assertEquals(expectedSize , instock.getCount());
    }
    @Test
    public void testGetCount_WithMultiElements(){
        testAdd_MultyAdd();
    }
    @Test
    public void testFind_SearchingValidIndex(){
        instock.add(product1);
        assertEquals(product1 , instock.find(0));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testFind_SearchingInvalidIndex(){
        instock.add(product1);
        assertEquals(product1 , instock.find(1));
    }
    @Test (expected = IndexOutOfBoundsException.class)
    public void testFind_PuttingInvalidNegativeIndex(){
        assertNotEquals(product2 , instock.find(-1));
    }
    @Test
    public void testChangeQuantity_GivingValidProductShouldChangeItCorrectly(){
        instock.add(product1);
        int expectedQuantity = 2;
        instock.changeQuantity(product1.getLabel() , expectedQuantity);
        Product currentProduct = instock.find(0);
        assertEquals(expectedQuantity , currentProduct.getQuantity());
    }
    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantity_GivingInvalidProductExceptedException(){
        instock.add(product1);
        int expectedQuantity = 2;
        instock.changeQuantity(product2.getLabel() , expectedQuantity);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testChangeQuantity_ThrowingExceptionOnEmptyInstock(){
        instock.changeQuantity(product2.getLabel() , 2);
    }
    @Test
    public void testFindByLabel_ShouldReturnTheCorrectProduct(){
        instock.add(product1);
        assertEquals(product1 , instock.findByLabel(product1.getLabel()));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabel_ShouldThrowExceptionForInvalidProduct(){
        instock.add(product1);
        assertEquals(product1 , instock.findByLabel(product2.getLabel()));
    }
    @Test(expected = IllegalArgumentException.class)
    public void testFindByLabel_ShouldThrowExceptionForEmptyInstock(){
        assertEquals(product1 , instock.findByLabel(product2.getLabel()));
    }

    @Test
    public void testFindFirstByAlphabeticalOrder_ShouldReturnTheCorrectSizeOfTheIterable(){
        List<Product> products= new ArrayList<>();
        MultiAdding(products);
        products = products.stream().sorted(Comparator.comparing(Product::getLabel))
                .limit(3).collect(Collectors.toList());
        int realCount = 0;
        for (Product product : instock.findFirstByAlphabeticalOrder(3)) {
            realCount++;
        }
        assertEquals(products.size() , realCount);
    }
    @Test
    public void testFindFirstByAlphabeticalOrder_ShouldReturnTheCorrectAlfabeticalOrder(){
        List<Product> list = new ArrayList<>();
        MultiAdding(list);

        list = list.stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());
        int count = 0;
        for (Product product : instock.findFirstByAlphabeticalOrder(2)) {
            assertEquals(list.get(count) , product);
            count++;
        }

    }

    @Test
    public void testFindFirstByAlphabeticalOrder_SizeShouldBeZero(){
        List<Product>products = new ArrayList<>();
        for (Product product : instock.findFirstByAlphabeticalOrder(2)) {
            products.add(product);
        }
        assertEquals(0 , products.size());
    }

    @Test
    public void testFindAllInRange_ShouldReturnAnEmptyCollection(){
        List<Product>products = new ArrayList<>();
        for (Product product : instock.findAllInRange(10, 12)) {
            products.add(product);
        }
        int expectedSize = 0;
        assertEquals(expectedSize , products.size());
    }
    @Test
    public void testFindAllInRange_ShouldReturnTheCorrectSize(){
        List<Product>products = new ArrayList<>();
        MultiAdding(products);

        products = products.stream()
                .filter(e->e.getPrice() >12.00 && e.getPrice() <= 20)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());
        int size = 0;
        for (Product product : instock.findAllInRange(12, 20)) {
            size++;
        }
        assertEquals(products.size() , size);
    }

    @Test
    public void testFindAllInRange_ShouldReturnTheCorrectProducts(){
        List<Product>products = new ArrayList<>();
        MultiAdding(products);

        products = products.stream()
                .filter(e->e.getPrice() >12.00 && e.getPrice() <= 20)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        int count = -1;
        for (Product product : instock.findAllInRange(12, 20)) {
            count++;
            assertEquals(products.get(count) , product);
        }
    }
    @Test
    public void testFindAllByPrice_ShouldReturnAnEmptyCollection(){
        List<Product>products = new ArrayList<>();
        for (Product product : instock.findAllByPrice(12)) {
            products.add(product);
        }
        int expectedSize = 0;
        assertEquals(expectedSize , products.size());
    }
    @Test
    public void testFindAllByPrice_ShouldReturnTheCorrectSize(){
        List<Product>products = new ArrayList<>();
        MultiAdding(products);

        products = products.stream()
                .filter(e->Double.compare(e.getPrice() , 20.00) == 0)
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());

        int count =0;
        for (Product product : instock.findAllByPrice(20.00)) {
            count++;
        }
        assertEquals(products.size() , count);
    }



    @Test
    public void testFindAllByPrice_ShouldReturnTheCorrectProducts(){
        List<Product>products = new ArrayList<>();
        MultiAdding(products);

        products = products.stream()
                .filter(e->Double.compare(e.getPrice() , 20.00) == 0)
                .sorted(Comparator.comparing(Product::getLabel))
                .collect(Collectors.toList());

       int count = -1;
        for (Product product : instock.findAllByPrice(20.00)) {
            count++;
            assertEquals(products.get(count) , product);
        }
    }
    @Test
    public void testFindFirstMostExpensiveProducts_ShouldReturnAnEmptyCollection(){
        List<Product>products = new ArrayList<>();
        for (Product product : instock.findFirstMostExpensiveProducts(2)) {
            products.add(product);
        }
        int expectedSize = 0;
        assertEquals(expectedSize , products.size());
    }
    @Test
    public void testFindFirstMostExpensiveProducts_ShouldReturnTheCorrectSize(){
        List<Product>products = new ArrayList<>();
        MultiAdding(products);
        int countToReturn = 2;
        products = products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(countToReturn)
                .collect(Collectors.toList());

        int count =0;
        for (Product product : instock.findFirstMostExpensiveProducts(countToReturn)) {
            count++;
        }
        assertEquals(products.size() , count);
    }
    @Test
    public void testFindFirstMostExpensiveProducts_ShouldReturnTheCorrectProducts() {
        List<Product> products = new ArrayList<>();
        MultiAdding(products);
        int countToReturn = 2;

        products = products.stream()
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(countToReturn)
                .collect(Collectors.toList());

        int count = -1;
        for (Product product : instock.findFirstMostExpensiveProducts(countToReturn)) {
            count++;
            assertEquals(products.get(count), product);
        }
    }
    @Test
    public void testFindAllByQuantity_ShouldReturnAnEmptyCollection(){
        List<Product>products = new ArrayList<>();
        for (Product product : instock.findAllByQuantity(4)) {
            products.add(product);
        }
        int expectedSize = 0;
        assertEquals(expectedSize , products.size());
    }
    @Test
    public void testFindAllByQuantity_ShouldReturnTheCorrectSize(){
        List<Product>products = new ArrayList<>();
        MultiAdding(products);
        int givenQuantity = 4;
        products = products.stream()
                .filter(e->e.getQuantity() == givenQuantity)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        int count =0;
        for (Product product : instock.findAllByQuantity(givenQuantity)) {
            count++;
        }
        assertEquals(products.size() , count);
    }
    @Test
    public void testFindAllByQuantity_ShouldReturnTheCorrectProducts() {
        List<Product> products = new ArrayList<>();
        MultiAdding(products);
        int givenQuantity = 4;
        products = products.stream()
                .filter(e->e.getQuantity() == givenQuantity)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

        int count = -1;
        for (Product product : instock.findAllByQuantity(givenQuantity)) {
            count++;
            assertEquals(products.get(count), product);
        }
    }

}