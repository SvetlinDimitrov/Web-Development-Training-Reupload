package barbershopjava;

public class Client {

    public String name;
    public int age;
    public Gender gender;
    public Barber barber;

    public Client(String name, int age, Gender gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public Barber getBarber() {
        return barber;
    }
}
