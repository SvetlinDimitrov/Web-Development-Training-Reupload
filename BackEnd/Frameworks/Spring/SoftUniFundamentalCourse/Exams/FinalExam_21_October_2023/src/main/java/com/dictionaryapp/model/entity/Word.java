package com.dictionaryapp.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "words")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Word {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private String translation;

    @Column(columnDefinition = "text")
    private String example;

    @Column(nullable = false , columnDefinition = "date")
    private Date inputDate;

    @ManyToOne
    private Language language;

    @ManyToOne
    private User addedBy;


}
