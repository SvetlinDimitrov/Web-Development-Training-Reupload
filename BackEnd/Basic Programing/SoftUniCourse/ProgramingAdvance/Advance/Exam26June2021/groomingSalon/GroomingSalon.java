package JavaAdvance.Exams.Java_Advanced_Exam26June2021.groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private List<Pet>data;
    private int capacity;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        data = new ArrayList<>();
    }

    public void add(Pet pet){
        if(capacity > data.size()){
            data.add(pet);
        }
    }

    public boolean remove(String name){
        Pet petToRemove = data.stream().filter(e->e.getName().equals(name)).findFirst().orElse(null);
        if(petToRemove != null){
            data.remove(petToRemove);
            return true;
        }else{
            return false;
        }
    }

    public Pet getPet(String name, String owner){
        return data.stream().filter(e->e.getName().equals(name) && e.getOwner().equals(owner))
                .findFirst().orElse(null);
    }
    public int getCount(){
        return data.size();
    }
    public String getStatistics(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("The grooming salon has the following clients:%n"));
        for (Pet datum : data) {
            print.append(String.format("%s %s%n",datum.getName() , datum.getOwner()));
        }
        return print.toString();
    }
}
