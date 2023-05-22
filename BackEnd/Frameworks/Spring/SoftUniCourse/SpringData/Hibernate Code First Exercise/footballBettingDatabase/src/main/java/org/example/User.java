package org.example;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends IdExtender{
    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private Double balance;
}
