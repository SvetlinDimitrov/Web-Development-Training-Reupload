package JavaAdvance.Exams.Java_Advanced_Retake_Exam13April2022.easterBasket;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private List<Egg> data;
    private String material;
    private int capacity;

    public Basket(String material, int capacity) {
        this.data = new ArrayList<>();
        this.material = material;
        this.capacity = capacity;
    }

    public void addEgg(Egg egg){
        if(data.size() <= capacity) {
            data.add(egg);
        }
    }

    public boolean removeEgg(String color){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getColor().equals(color)){
                data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Egg getStrongestEgg(){
        return data.stream().max((f,s)->Integer.compare(f.getStrength() , s.getStrength())).orElse(null);
    }

    public Egg getEgg(String color){
        for (Egg datum : data) {
            if(datum.getColor().equals(color)){
                return datum;
            }
        }
        return null;
    }

    public int getCount(){
        return data.size();
    }

    public String getMaterial() {
        return material;
    }

    public String report(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("%s basket contains:%n",getMaterial()));
        for (Egg egg : data) {
            print.append(String.format("%s%n",egg));
        }
        return print.toString();
    }

}
