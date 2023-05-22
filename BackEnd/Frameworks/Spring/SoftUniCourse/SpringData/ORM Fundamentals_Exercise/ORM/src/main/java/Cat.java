import anotationTest.Column;
import anotationTest.Entity;
import anotationTest.Id;

@Entity(name = "cats")
public class Cat {
    @Id(name = "id")
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name ;
    @Column(name = "age")
    private int age ;

    @Column(name = "power")
    private String power = "doNothing";

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat() {
    }
}
