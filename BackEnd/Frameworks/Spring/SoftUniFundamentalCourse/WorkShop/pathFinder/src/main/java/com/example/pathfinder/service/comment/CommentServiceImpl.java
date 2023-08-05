package com.example.pathfinder.service.comment;

import com.example.pathfinder.domain.bindingViews.ViewComments;
import com.example.pathfinder.domain.dtos.CreateCommendDto;
import com.example.pathfinder.domain.entity.Comment;
import com.example.pathfinder.domain.entity.Route;
import com.example.pathfinder.repos.CommentRepository;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.repos.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final RouteRepository routeRepository;
    private final UserRepository userRepository;

    @Override
    public boolean save(CreateCommendDto dtoComment, Long routeId, Long userId) {
        if (routeRepository.count() < routeId || userRepository.count() < userId) {
            return false;
        }
        Comment comment = toComment(dtoComment , routeId , userId);
        commentRepository.save(comment);
        return true;
    }

    @Override
    @Transactional
    public List<ViewComments> getAllByRouteId(Long routeId) {

        Optional<Route> route = routeRepository.findById(routeId);

        return route.isPresent() ?
                commentRepository.findByRoute(route.orElseThrow())
                .stream()
                .map(ViewComments::new)
                .collect(Collectors.toList())
                :
                null;

    }

    private Comment toComment(CreateCommendDto dto, Long routeId, Long userId) {
        return Comment.builder()
                .approved(false)
                .created(LocalDate.now())
                .textContent(dto.getCommentText())
                .author(userRepository.findById(userId).orElseThrow())
                .route(routeRepository.findById(routeId).orElseThrow())
                .build();
    }
//
//    @PostConstruct
//    public void initAfterCreate(){
//        if(commentRepository.count() == 0){
//            commentRepository.saveAll(
//                    List.of(
//                            Comment.builder()
//                                    .approved(false)
//                                    .created(LocalDate.now())
//                                    .textContent("lemoni za smet")
//                                    .author(userRepository.findById(1L).orElseThrow())
//                                    .route(routeRepository.findById(1L).orElseThrow())
//                                    .build(),
//                            Comment.builder()
//                                    .approved(false)
//                                    .created(LocalDate.now())
//                                    .textContent("lemoni za smet2")
//                                    .author(userRepository.findById(1L).orElseThrow())
//                                    .route(routeRepository.findById(1L).orElseThrow())
//                                    .build(),
//                            Comment.builder()
//                                    .approved(false)
//                                    .created(LocalDate.now())
//                                    .textContent("lemoni za smet3")
//                                    .author(userRepository.findById(1L).orElseThrow())
//                                    .route(routeRepository.findById(1L).orElseThrow())
//                                    .build()
//                    )
//            );
//        }
//    }

}
