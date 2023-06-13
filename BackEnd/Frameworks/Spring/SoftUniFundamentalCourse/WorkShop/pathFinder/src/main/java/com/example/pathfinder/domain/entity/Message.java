package com.example.pathfinder.domain.entity;


import com.example.pathfinder.domain.constants.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "messages")
public class Message extends BaseEntity {
    @Column(columnDefinition = "datetime(6)" , name = "date_time")
    private LocalDate dateTime;

    @Column(columnDefinition = "text" , name = "text_content")
    private String textContent;

    @ManyToOne
    private User author;

    @ManyToOne
    private User recipient;
}
