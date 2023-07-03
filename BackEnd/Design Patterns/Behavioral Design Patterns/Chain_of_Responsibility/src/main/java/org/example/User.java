package org.example;

public class User {
    private String name;
    private Integer age;
    private String password;
    private String confirmPassword;
    private String email;

    public User(String name, Integer age, String password, String confirmPassword, String email) {
        this.name = name;
        this.age = age;
        this.password = password;
        this.confirmPassword = confirmPassword;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public User setName(String name) {
        this.name = name;
        return this;
    }

    public Integer getAge() {
        return age;
    }

    public User setAge(Integer age) {
        this.age = age;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public User setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }
}
