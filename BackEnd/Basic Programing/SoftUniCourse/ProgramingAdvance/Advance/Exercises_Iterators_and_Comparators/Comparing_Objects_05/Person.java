package JavaAdvance.Exercises_Iterators_and_Comparators.Comparing_Objects_05;

public class Person implements Comparable<Person> {
    private String name;
    private int age;
    private String town;

    public Person(String name , int age , String town){
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getTown() {
        return town;
    }

    @Override
    public int compareTo(Person other) {
        if(getName().compareTo(other.getName()) == 0){
            if(getAge() == other.getAge()){
                if(getTown().compareTo(other.getTown())==0){
                    return 0;
                }
            }
        }
        return -1;
    }
}
