package com.example.pathfinder.service.comment;

import com.example.pathfinder.domain.bindingViews.ViewComment;
import com.example.pathfinder.domain.dtos.CreateCommendDto;

import java.util.List;

public interface CommentService {
    boolean save(CreateCommendDto dtoComment, Long routeId, Long userId);

    List<ViewComment> getAllByRouteId(Long routeId);
}
