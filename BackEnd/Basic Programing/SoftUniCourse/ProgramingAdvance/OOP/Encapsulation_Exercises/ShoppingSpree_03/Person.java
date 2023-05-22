import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private double money;
    private List<Product> productList;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.productList = new ArrayList<>();
    }

    public void setName(String name) {
        if(name != null && name.trim().length() >0){
            this.name = name;
        }else{
            throw new IllegalArgumentException("Name cannot be empty");
        }
    }

    public String getName() {
        return name;
    }
    public void buyProduct(Product product){
        if(money >= product.getCost()){
            productList.add(product);
            money-=product.getCost();
        }else{
            String name = String.format("%s can't afford %s",this.name,product.getName());
            throw new IllegalArgumentException(name);
        }
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setMoney(double money) {
        if(money >=0){
            this.money = money;
        }else{
            throw new IllegalArgumentException("Money cannot be negative");
        }

    }
}
