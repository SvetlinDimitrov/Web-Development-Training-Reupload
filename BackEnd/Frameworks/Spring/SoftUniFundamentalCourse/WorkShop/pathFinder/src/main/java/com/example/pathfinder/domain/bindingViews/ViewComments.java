package com.example.pathfinder.domain.bindingViews;

import com.example.pathfinder.domain.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ViewComments {
    private Long id;
    private Boolean approved;
    private LocalDate created;
    private String textContent;
    private String author;

    public ViewComments(Comment comment) {
        this.id = comment.getId();
        this.approved = comment.getApproved();
        this.created = comment.getCreated();
        this.textContent = comment.getTextContent();
        this.author = comment.getAuthor().getFullName();
    }
}