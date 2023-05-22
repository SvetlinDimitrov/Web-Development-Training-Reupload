import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Instock implements ProductStock {
    private List<Product> productList ;

    public Instock() {
        this.productList = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return productList.size();
    }

    @Override
    public boolean contains(Product product) {
        for (Product products : productList) {
            if(products.equals(product)){
                return true;
            }
        }
        return false;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        for (Product currentProduct : productList) {
            if(currentProduct.getLabel().equals(product)){
                currentProduct.setQuantity(quantity);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Product find(int index) {
        if(productList.isEmpty() && ValidIndex(index)){
            throw new IndexOutOfBoundsException();
        }
        return productList.get(index);
    }

    @Override
    public Product findByLabel(String label) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<Product> iterator() {
        return productList.iterator();
    }
    private boolean ValidIndex(int index) {
        return productList.size()-1 >= index && index >=0;
    }

}
