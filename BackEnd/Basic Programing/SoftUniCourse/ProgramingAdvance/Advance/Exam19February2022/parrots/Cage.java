package JavaAdvance.Exams.Java_Advanced_Exam19February2022.parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {
    private List<Parrot> data;
    private String name;
    private int capacity;

    public Cage(String name, int capacity) {
        this.data = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot){
        if(capacity > data.size()) {
            data.add(parrot);
        }
    }

    public boolean remove(String name){
        int index=0;
        boolean toDelete=false;
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getName().equals(name)){
                toDelete=true;
                index = i;
                break;
            }
        }
        if(toDelete){
            data.remove(index);
        }
        return toDelete;
    }
    public Parrot sellParrot(String name){
        int index=0;
        boolean toDelete=false;
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getName().equals(name)){
                toDelete=true;
                index = i;
                break;
            }
        }
        if(toDelete){
            data.get(index).setAvailable(false);
            return data.get(index);
        }
        return null;
    }
    public List<Parrot> sellParrotBySpecies(String species){
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).getSpecies().equals(species)){
                data.get(i).setAvailable(false);
            }
        }
        return data.stream().filter(e-> e.getSpecies().equals(species))
                .collect(Collectors.toList());
    }

    public int count(){
        return data.size();
    }


    public String report(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("Parrots available at %s:%n",name));
        for (int i = 0; i < data.size(); i++) {
            if(data.get(i).isAvailable()){
                print.append(String.format("%s%n",data.get(i)));
            }
        }
        return print.toString();
    }
}
