public class Citizen implements Person , Identifiable , Birthable{
    private String name;
    private String id;
    private String birthDate;
    private int age;

    public Citizen(String name, int age , String id , String birthDate) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthDate = birthDate;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public String getBirthDate() {
        return birthDate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", age=" + age +
                '}';
    }
}
