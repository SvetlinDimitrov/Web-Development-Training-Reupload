package com.example.mobileleweb.domain.entity;

import com.example.mobileleweb.domain.constants.BaseEntity;
import com.example.mobileleweb.domain.constants.ModelCategory;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Reference;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "models")
public class Model extends BaseEntity {

    @Column(columnDefinition = "varchar(255)")
    private String name;

    @Column(columnDefinition = "int(11)")
    @Enumerated
    private ModelCategory category;

    @Column(name = "image_url" ,columnDefinition = "varchar(512)")
    private String imageUrl;

    @Column(name = "start_year" , columnDefinition = "int(11)")
    private Integer startYear;

    @Column(name = "end_year" , columnDefinition = "int(11)")
    private Integer endYear;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate created;

    @Column(columnDefinition = "datetime(6)")
    private LocalDate modified;

    @ManyToOne(fetch = FetchType.EAGER)
    private Brand brand;

}
