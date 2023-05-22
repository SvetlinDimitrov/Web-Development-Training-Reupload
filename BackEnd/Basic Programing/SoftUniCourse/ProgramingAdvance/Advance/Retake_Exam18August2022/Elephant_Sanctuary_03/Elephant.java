package JavaAdvance.Exams.Java_Advanced_Retake_Exam18August2022.Elephant_Sanctuary_03;

public class Elephant {
    private String name;
    private int age;
    private String retiredFrom;

    public Elephant(String name, int age, String retiredFrom) {
        this.name = name;
        this.age = age;
        this.retiredFrom = retiredFrom;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRetiredFrom() {
        return retiredFrom;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRetiredFrom(String retiredFrom) {
        this.retiredFrom = retiredFrom;
    }

    @Override
    public String toString() {
        return String.format("%s %d - %s",name,age,retiredFrom);
    }
}
