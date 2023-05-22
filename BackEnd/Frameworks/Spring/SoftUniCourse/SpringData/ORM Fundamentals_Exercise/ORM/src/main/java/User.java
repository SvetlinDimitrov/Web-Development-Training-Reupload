import anotationTest.Column;
import anotationTest.Entity;
import anotationTest.Id;

import java.time.LocalDate;
@Entity(name = "user")
public class User {
    @Id (name = "id")
    private int id ;
    @Column(name ="username")
    private String username;

    @Column(name = "registration")
    private LocalDate registration;
    @Column(name = "age")
    private int age;

    public User(String username, LocalDate registration, int age) {
        this.username = username;
        this.registration = registration;
        this.age = age;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDate getRegistration() {
        return registration;
    }

    public void setRegistration(LocalDate registration) {
        this.registration = registration;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", registration=" + registration +
                ", age=" + age +
                '}';
    }
}
