package com.example.pathfinder.domain.entity;

import com.example.pathfinder.domain.constants.BaseEntity;
import com.example.pathfinder.domain.constants.Level;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "users")
public class UserEntity extends BaseEntity {
    @Column
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column
    private Integer age;

    @Column
    private String password;

    @Column
    private String email;

    @ManyToMany(cascade = CascadeType.MERGE , fetch = FetchType.LAZY)
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

    @Enumerated(EnumType.STRING)
    @Column
    private Level level;

    @OneToMany(mappedBy = "author" )
    private List<Comment> comments;

    @OneToMany(mappedBy = "author" )
    private List<Route> route;

    @OneToMany(mappedBy = "author" )
    private List<Picture> pictures;

    @OneToMany(mappedBy = "author")
    private List<Message> messages;

    @OneToMany(mappedBy = "recipient" )
    private List<Message> recipients;


}
