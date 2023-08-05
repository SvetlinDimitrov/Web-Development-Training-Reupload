package com.example.pathfinder.repos;

import com.example.pathfinder.domain.entity.Comment;
import com.example.pathfinder.domain.entity.Route;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByRoute(Route route);
}
