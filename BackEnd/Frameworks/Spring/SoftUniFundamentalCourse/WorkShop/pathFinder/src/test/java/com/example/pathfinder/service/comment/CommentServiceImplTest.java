package com.example.pathfinder.service.comment;

import com.example.pathfinder.domain.bindingViews.ViewComment;
import com.example.pathfinder.domain.dtos.CreateCommendDto;
import com.example.pathfinder.domain.entity.Comment;
import com.example.pathfinder.domain.entity.Route;
import com.example.pathfinder.domain.entity.UserEntity;
import com.example.pathfinder.repos.CommentRepository;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.repos.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CommentServiceImplTest {

    @Mock
    private CommentRepository commentRepository;

    @Mock
    private UserRepository userRepository;

    @Mock
    private RouteRepository routeRepository;

    @InjectMocks
    private CommentServiceImpl commentService;

    private final static List<Comment> commentList = new ArrayList<>();
    private final static Long VALID_USER_ID = 1L;
    private final static Long VALID_ROUTE_ID = 1L;
    private final static Long INVALID_ROUTE_ID = 3L;
    private final static Long INVALID_USER_ID = 3L;
    private final static CreateCommendDto dto = new CreateCommendDto("test");

    @BeforeEach
    public void setUp() {
        commentList.addAll(
                List.of(new Comment(1L, false, LocalDate.parse("2018-12-27"), "Test", UserEntity.builder().fullName("Test Testov").build(), null),
                        new Comment(2L, false, LocalDate.parse("2018-12-27"), "Test2", UserEntity.builder().fullName("Test Testov1").build(), null),
                        new Comment(3L, false, LocalDate.parse("2018-12-27"), "Test3", UserEntity.builder().fullName("Test Testov2").build(), null))
        );
    }

    @Test
    public void saveTest_ReturnsTrueForSuccessfulCreation() {
        when(routeRepository.count()).thenReturn(2L);
        when(userRepository.count()).thenReturn(2L);
        when(userRepository.findById(VALID_USER_ID)).thenReturn(Optional.of(new UserEntity()));
        when(routeRepository.findById(VALID_ROUTE_ID)).thenReturn(Optional.of(new Route()));

        CreateCommendDto dto = new CreateCommendDto("test");

        boolean result = commentService.save(dto, VALID_USER_ID, VALID_ROUTE_ID);

        assertTrue(result);
    }

    @Test
    public void saveTest_ReturnsFalseForUnsuccessfulCreation() {
        when(routeRepository.count()).thenReturn(2L);
        when(userRepository.count()).thenReturn(2L);

        boolean result = commentService.save(dto, VALID_ROUTE_ID, INVALID_USER_ID);
        boolean result2 = commentService.save(dto, INVALID_ROUTE_ID, VALID_USER_ID);
        boolean result3 = commentService.save(null, VALID_ROUTE_ID, VALID_USER_ID);
        assertFalse(result);
        assertFalse(result2);
        assertFalse(result3);

    }

    @Test
    public void getAllByRouteIdTest_ReturnNullForWrongInput() {
        when(routeRepository.findById(INVALID_ROUTE_ID)).thenReturn(Optional.ofNullable(null));
        List<ViewComment> result = commentService.getAllByRouteId(INVALID_ROUTE_ID);
        assertNull(result);
    }

    @Test
    public void getAllByRouteIdTest_ReturnTheCorrectCommentsViews() {
        Route route = new Route();
        when(routeRepository.findById(VALID_ROUTE_ID)).thenReturn(Optional.of(route));
        when(commentRepository.findByRoute(route)).thenReturn(commentList);

        List<ViewComment> result = commentService.getAllByRouteId(VALID_ROUTE_ID);
        List<ViewComment> expected =
                List.of(
                        new ViewComment(1L, false,  LocalDate.parse("2018-12-27"), "Test", "Test Testov"),
                        new ViewComment(2L, false,  LocalDate.parse("2018-12-27"), "Test2", "Test Testov1"),
                        new ViewComment(3L, false,  LocalDate.parse("2018-12-27"), "Test3", "Test Testov2")
                );

        assertEquals(expected.get(0), result.get(0));
        assertEquals(expected.get(1), result.get(1));
        assertEquals(expected.get(2), result.get(2));
    }
}