package JavaAdvance.Exams.Java_Advanced_Exam23October2021.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Person> roster;
    private String name;
    private int capacity;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster=new ArrayList<>();

    }

    public void add(Person person){
        if(capacity > roster.size()) {
            roster.add(person);
        }
    }
    public boolean  remove(String name){
        int index = -1;
        for (int i = 0; i < roster.size(); i++) {
            if(roster.get(i).getName().equals(name)){
                index = i;
                break;
            }
        }
        if(index != -1){
            roster.remove(index);
            return true;
        }
        return false;
    }
    public Person getPerson(String name, String hometown){
        for (Person person : roster) {
            if(person.getName().equals(name) && person.getHometown().equals(hometown)){
                return person;
            }
        }
        return null;
    }
    public int getCount(){
        return roster.size();
    }
    public String getStatistics(){
        StringBuilder print = new StringBuilder();
        print.append(String.format("The people in the JavaAdvance.Exams.Java_Advanced_Exam23October2021.hotel %s are:%n",name));
        for (Person person : roster) {
            print.append(String.format("%s%n",person));
        }
        return print.toString();
    }
}
