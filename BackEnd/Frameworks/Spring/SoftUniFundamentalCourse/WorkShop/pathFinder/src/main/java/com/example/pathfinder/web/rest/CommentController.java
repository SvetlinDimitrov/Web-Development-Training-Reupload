package com.example.pathfinder.web.rest;

import com.example.pathfinder.domain.bindingViews.ViewComment;
import com.example.pathfinder.domain.dtos.CreateCommendDto;
import com.example.pathfinder.service.comment.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @GetMapping("/{routeId}")
    public ResponseEntity<List<ViewComment>> getAllComments(@PathVariable(name = "routeId") Long routeId) {

        List<ViewComment> comments = commentService.getAllByRouteId(routeId);

        return comments != null ? new ResponseEntity<>(comments, HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/create/{routeId}/{userId}")
    public ResponseEntity<HttpStatus> createCommand(@PathVariable(name = "routeId") Long routeId,
                                                    @PathVariable(name = "userId") Long userId,
                                                    @RequestBody CreateCommendDto dtoComment) {
        return commentService.save(dtoComment, routeId,userId) ? ResponseEntity.accepted().build() : ResponseEntity.badRequest().build();
    }
}
