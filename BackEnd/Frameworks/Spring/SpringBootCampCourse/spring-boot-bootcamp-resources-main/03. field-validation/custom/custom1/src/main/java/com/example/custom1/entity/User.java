package com.example.custom1.entity;

import com.example.custom1.annotations.EmailMain;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class User {


    @NotBlank(message = "First name cannot be blank")

    private String firstName;
    @NotBlank(message = "Last name cannot be blank")

    private String lastName;
    @NotBlank(message = "Username cannot be blank")
    private String userName;
    @NotBlank(message = "Email cannot be blank")
    @EmailMain
    private String email;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;


    public User(String firstName, String lastName, String userName, String email, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
