package com.example.pathfinder.service.route;

import com.example.pathfinder.domain.bindingViews.ViewRoute;
import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.dtos.RegisterRouteDto;
import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.domain.entity.Route;
import com.example.pathfinder.domain.entity.UserEntity;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.service.category.CategoryService;
import com.example.pathfinder.service.user.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.notNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RouteServiceImplTest {

    @Mock
    private RouteRepository routeRepository;
    @Mock
    private UserService userService;
    @Mock
    private CategoryService categoryService;
    @Mock
    private ModelMapper mapper;

    @InjectMocks
    private RouteServiceImpl routeService;

    private final static Long VALID_ID = 1L;
    private final static Long INVALID_ID = 99L;

    private static List<Route> routesList;

    private static List<ViewRoute> excepted;

    @BeforeEach
    public void setUp() {

        UserEntity user = new UserEntity().setFullName("Test Testov");
        user.setId(1L);

        routesList = List.of(
                Route.builder()
                        .gpxCoordinates("GpsTest1")
                        .description("descriptionTest1")
                        .level(Level.ADVANCED)
                        .name("Test1")
                        .videoUrl("videoUrlTest1")
                        .pictures(List.of())
                        .roles(Set.of())
                        .author(user)
                        .build(),
                Route.builder()
                        .gpxCoordinates("GpsTest2")
                        .description("descriptionTest")
                        .level(Level.ADVANCED)
                        .name("Test2")
                        .videoUrl("videoUrlTest2")
                        .pictures(List.of())
                        .roles(Set.of())
                        .author(user)
                        .build()
        );
        routesList.get(0).setId(1L);
        routesList.get(1).setId(2L);

        excepted = List.of(
                ViewRoute.builder()
                        .gpxCoordinates("GpsTest1")
                        .description("descriptionTest1")
                        .level(Level.ADVANCED)
                        .name("Test1")
                        .id(1L)
                        .videoUrl("videoUrlTest1")
                        .pictures(List.of())
                        .roles(Set.of())
                        .author("Test Testov")
                        .authorId(1L)
                        .build(),
                ViewRoute.builder()
                        .gpxCoordinates("GpsTest2")
                        .description("descriptionTest")
                        .level(Level.ADVANCED)
                        .id(2L)
                        .name("Test2")
                        .videoUrl("videoUrlTest2")
                        .pictures(List.of())
                        .roles(Set.of())
                        .author("Test Testov")
                        .authorId(1L)
                        .build()
        );
    }


    @Test
    void getViewRouteByIdTest_ReturnsTheCorrectViewRoute() {

        when(routeRepository.findById(VALID_ID)).thenReturn(Optional.of(routesList.get(0)));

        ViewRoute result = routeService.getViewRouteById(VALID_ID);

        assertEquals(excepted.get(0), result);
    }

    @Test
    void getViewRouteByIdTest_ThrowsFoNotExistingRoute() {

        when(routeRepository.findById(INVALID_ID)).thenReturn(null);

        assertThrows(RuntimeException.class, () -> routeService.getViewRouteById(INVALID_ID));
    }

    //:TODO
    @Test
    void saveRoteTest_CorrectlySaves() {

    }

    @Test
    void getAllViewRoutesTest_WorkCorrectly() {

        when(routeRepository.findAll()).thenReturn(routesList);
        List<ViewRoute> allViewRoutes = routeService.getAllViewRoutes();

        assertEquals(excepted, allViewRoutes);
    }


    @Test
    void getAllViewRoutesByCategoryConstOriginalId() {
        Integer level = 0;

        CategoryConstant categoryConstant = CategoryConstant.values()[level];
        Categorie category = new Categorie();
        when(categoryService.findByCategoryConstant(categoryConstant)).thenReturn(category);

        when(routeRepository.findAllByCategories(category)).thenReturn(routesList);

        List<ViewRoute> result = routeService.getAllViewRoutesByCategoryConstOriginalId(level);

        verify(categoryService).findByCategoryConstant(categoryConstant);
        verify(routeRepository).findAllByCategories(category);

        assertEquals(excepted, result);
    }
}