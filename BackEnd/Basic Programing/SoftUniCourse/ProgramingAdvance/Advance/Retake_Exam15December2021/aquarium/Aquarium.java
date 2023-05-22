package JavaAdvance.Exams.Java_Advanced_Retake_Exam15December2021.aquarium;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private List<Fish> fishInPool;
    private String name;
    private int capacity;
    private int size;

    public Aquarium(String name, int capacity, int size) {
        this.fishInPool = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    public int getFishInPool(){
        return fishInPool.size();
    }

    public void add(Fish fish){
        if(capacity >= fishInPool.size()) {
            fishInPool.add(fish);
        }
    }
    public boolean remove(String name){
        int indexToRemove = -1;
        for (int i = 0; i < fishInPool.size(); i++) {
            if (fishInPool.get(i).getName().equals(name)){
                indexToRemove = i;
                break;
            }
        }
        if(indexToRemove != -1){
            fishInPool.remove(indexToRemove);
            return true;
        }
        return false;
    }

    public Fish findFish(String name){
        for (Fish fish : fishInPool) {
            if (fish.getName().equals(name)){
                return fish;
            }
        }
        return null;
    }

    public String report(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("Aquarium: %s ^ Size: %d%n",name,size));
        for (Fish fish : fishInPool) {
            print.append(String.format("%s%n",fish));
        }
        return print.toString();
    }
}
