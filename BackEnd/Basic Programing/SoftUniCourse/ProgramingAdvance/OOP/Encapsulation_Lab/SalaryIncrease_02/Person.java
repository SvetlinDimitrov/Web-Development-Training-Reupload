package JavaOOP.Encapsulation_Lab.SalaryIncrease_02;

public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;


    public Person(String firstName, String lastName, int age, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void increaseSalary(double bonus) {
        if (age < 30) {
            salary += salary * ((bonus / 100) / 2);
        } else {
            salary += salary * (bonus / 100);
        }
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("%s %s gets %.1f leva.", getFirstName(), getLastName(), getSalary());
    }
}
//    • firstName: String
//    • lastName: String
//    • age: int