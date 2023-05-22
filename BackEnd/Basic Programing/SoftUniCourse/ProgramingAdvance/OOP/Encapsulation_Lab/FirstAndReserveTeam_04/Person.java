public class Person {
    private String firstName;
    private String lastName;
    private int age;

    private double salary;


     Person(String firstName, String lastName, int age, double salary) {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);
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
        if(salary <= 460.0){
            throw new IllegalArgumentException("Salary can't be less than 460 leva");
        }
        this.salary = salary;
    }

    public void setFirstName(String firstName) {
        if(firstName.length() <= 3) {
            throw  new IllegalArgumentException("First name must be at least 3 symbols");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if(lastName.length() <= 3) {
            throw  new IllegalArgumentException("Last name must be at least 3 symbols");
        }
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age < 0){
            throw new IllegalArgumentException("Age must not be zero or negative integer");
        }
        this.age = age;
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