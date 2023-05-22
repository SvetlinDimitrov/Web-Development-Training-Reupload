import jdk.jshell.spi.ExecutionControl;

import java.util.*;
import java.util.stream.Collectors;

public class Instock implements ProductStock {
    private Map<String , Product> productMap = new HashMap<>();
    @Override
    public int getCount() {
        return productMap.size();
    }

    @Override
    public boolean contains(Product product) {
        return productMap.containsKey(product.getLabel());
    }

    @Override
    public void add(Product product) {
        productMap.putIfAbsent(product.getLabel() , product);
    }

    @Override
    public void changeQuantity(String product, int quantity) {
        if(productMap.isEmpty() || !productMap.containsKey(product)) {
            throw new IllegalArgumentException();
        }
        productMap.get(product).setQuantity(quantity);
    }

    @Override
    public Product find(int index) {
        if(productMap.size() <= index || productMap.isEmpty() || index <0) {
            throw new IndexOutOfBoundsException();
        }
        int count = -1;
        Product product = null;
        for (Product value : productMap.values()) {
            count++;
            if(count == index){
                product= value;
            }
        }
        return product;
    }

    @Override
    public Product findByLabel(String label) {
        if(productMap.containsKey(label)){
            return productMap.get(label);
        }
        throw new IllegalArgumentException();
    }

    @Override
    public Iterable<Product> findFirstByAlphabeticalOrder(int count) {
        List<Product> productList = new ArrayList<>();
        productMap.values().stream()
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count)
                .forEach(productList::add);
        return productList;
    }

    @Override
    public Iterable<Product> findAllInRange(double lo, double hi) {
        List<Product>products = new ArrayList<>();

         productMap.values().stream()
                .filter(e->e.getPrice() >12.00 && e.getPrice() <= 20)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .forEach(products::add);
        return products;
    }

    @Override
    public Iterable<Product> findAllByPrice(double price) {
        List<Product>products = new ArrayList<>();

        productMap.values().stream()
                .filter(e->Double.compare(e.getPrice() , 20.00) == 0)
                .sorted(Comparator.comparing(Product::getLabel))
                .forEach(products::add);

        return products;
    }

    @Override
    public Iterable<Product> findFirstMostExpensiveProducts(int count) {

        return productMap.values().stream()
        .sorted(Comparator.comparing(Product::getPrice).reversed())
        .limit(count)
        .collect(Collectors.toList());
    }

    @Override
    public Iterable<Product> findAllByQuantity(int quantity) {
        return productMap.values().stream()
                .filter(e->e.getQuantity() == quantity)
                .sorted(Comparator.comparing(Product::getPrice).reversed())
                .collect(Collectors.toList());

    }

    @Override
    public Iterator<Product> iterator() {
        return productMap.values().stream().iterator();
    }
}
