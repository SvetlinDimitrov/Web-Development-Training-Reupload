package JavaAdvance.Exams.Java_Advanced_Exam22October2022.shelter;

import java.util.ArrayList;
import java.util.List;

public class Shelter {
    private List<Animal> data;
    private int capacity;

    public Shelter(int capacity) {
        this.capacity = capacity;
        data=new ArrayList<>();
    }
    public void add(Animal animal){
        if(capacity > data.size()){
            data.add(animal);
        }
    }
    public boolean remove(String name){
        Animal animal = data.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
        if(animal == null){
            return false;
        }else{
            data.remove(animal);
            return true;
        }
    }
    public Animal getAnimal(String name, String caretaker){
        return data.stream().filter(e-> e.getName().equals(name) && e.getCaretaker().equals(caretaker))
                .findFirst().orElse(null);
    }
    public Animal getOldestAnimal(){
        return data.stream().max((f,s) -> Integer.compare(f.getAge(),s.getAge())).orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("The JavaAdvance.Exams.Java_Advanced_Exam22October2022.shelter has the following animals:%n"));
        for (Animal datum : data) {
            print.append(String.format("%s %s%n",datum.getName(),datum.getCaretaker()));
        }
        return print.toString();
    }
}
