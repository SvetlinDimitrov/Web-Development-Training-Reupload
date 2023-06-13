package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@Table(name = "users")
public class User extends BaseEntity {
    @Column(columnDefinition = "varchar(255)")
    @Length(min = 2)
    private String username;

    @Column(name = "full_name" , columnDefinition = "varchar(255)")
    private String fullName;

    @Column(columnDefinition = "int")
    private Integer age;

    @Column(columnDefinition = "varchar(255)")
    @Length(min = 2)
    private String password;

    @Column(columnDefinition = "varchar(255)")
    //TODO:Accepts values, which contain the '@' symbol
    private String email;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_entity_id",
                    referencedColumnName = "id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "roles_id",
                    referencedColumnName = "id"
            )
    )
    private Set<Role> roles;

    @Enumerated
    @Column(columnDefinition = "varchar(255)")
    private Level level;

    @OneToMany(mappedBy = "author")
    private List<Comment> comments;

    @OneToMany(mappedBy = "author")
    private List<Route> route;

    @OneToMany(mappedBy = "author")
    private List<Picture> pictures;

    @OneToMany(mappedBy = "author")
    private List<Message> messages;

    @OneToMany(mappedBy = "recipient")
    private List<Message> recipients;
    public User() {
        this.roles = new HashSet<>();
        roles.add(new Role(RoleConstant.USER));
    }
}
