package JavaAdvance.Exams.Java_Advanced_Retake_Exam18August2022.Elephant_Sanctuary_03;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
    private List<Elephant> elephantList;
    private int capacity;

    public Habitat(int capacity) {
        this.elephantList = new ArrayList<>();
        this.capacity = capacity;
    }

    public void add(Elephant elephant){
        if(elephantList.size() < capacity) {
            elephantList.add(elephant);
        }
    }

    public boolean remove(String name){
        for (int i = 0; i < elephantList.size(); i++) {
            if(elephantList.get(i).getName().equals(name)){
                elephantList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Elephant getElephant(String retiredFrom){

        for (Elephant elephant : elephantList) {
            if (elephant.getRetiredFrom().equals(retiredFrom)) {
                return elephant;
            }
        }
        return null;
    }

    public Elephant getOldestElephant(){
       return elephantList.stream().max((f,s)->Integer.compare(f.getAge(),s.getAge())).orElse(null);

    }

    public int getAllElephants(){
        return elephantList.size();
    }

    public String getReport(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("Saved elephants in the park:%n"));
        for (Elephant elephant : elephantList) {
            print.append(String.format("%s came from: %s%n",elephant.getName(),elephant.getRetiredFrom()));
        }
        return print.toString();
    }
}
