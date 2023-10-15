package com.likebookapp.model.entity;
import com.likebookapp.model.enums.MoodConstance;
import lombok.Data;
import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class MoodEntity {

    @Id
    @GeneratedValue(strategy =   GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true , nullable = false)
    private MoodConstance name;

    private String description;

    @OneToMany
    private List<PostEntity> postss;


}
