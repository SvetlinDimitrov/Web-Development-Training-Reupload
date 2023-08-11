package com.example.pathfinder.domain.bindingViews;

import com.example.pathfinder.domain.entity.Comment;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ViewComment {
    private Long id;
    private Boolean approved;
    private LocalDate created;
    private String textContent;
    private String author;

    public ViewComment(Comment comment) {
        this.id = comment.getId();
        this.approved = comment.getApproved();
        this.created = comment.getCreated();
        this.textContent = comment.getTextContent();
        this.author = comment.getAuthor().getFullName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ViewComment that = (ViewComment) o;
        return Objects.equals(id, that.id) && Objects.equals(approved, that.approved) && Objects.equals(created, that.created) && Objects.equals(textContent, that.textContent) && Objects.equals(author, that.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, approved, created, textContent, author);
    }
}