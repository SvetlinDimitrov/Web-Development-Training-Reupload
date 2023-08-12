package com.example.pathfinder.web;

import com.example.pathfinder.domain.constants.CategoryConstant;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.entity.Categorie;
import com.example.pathfinder.domain.entity.Role;
import com.example.pathfinder.domain.entity.Route;
import com.example.pathfinder.domain.entity.UserEntity;
import com.example.pathfinder.repos.CategoryRepository;
import com.example.pathfinder.repos.RoleRepository;
import com.example.pathfinder.repos.RouteRepository;
import com.example.pathfinder.repos.UserRepository;
import com.example.pathfinder.service.picture.PictureService;
import com.example.pathfinder.service.route.RouteService;
import com.example.pathfinder.setUp.WithMockUserPrincipal;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("test")
public class RouteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private RouteService routeService;
    @Autowired
    private PictureService pictureService;

    @BeforeEach
    void setUp() {

        setUpUserRolesAndUser();
        setCategories();
        setViewRoutes();

    }

    @Test
    public void getRoutes_WithNotLoggedUser_Successful() throws Exception {

        mockMvc.perform(get("/routes"))
                .andExpect(model().attributeExists("routes"))
                .andExpect(model().attribute("routes", Matchers.hasSize(2)))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void getDetailAboutTheRoute_TestWithValidAndNonValid_SuccessfulInBothScenarios() throws Exception {
        long INVALID_ID = routeRepository.count()+1;
        mockMvc.perform(get("/routes/details/1"))
                .andExpect(model().attributeExists("route"))
                .andExpect(model().attribute("route", Matchers.hasProperty("name", Matchers.equalTo("Test1"))))
                .andExpect(model().attributeExists("routeId"))
                .andExpect(model().attribute("routeId", Matchers.equalTo(1L)))
                .andExpect(status().is2xxSuccessful());


        mockMvc.perform(get("/routes/details/"+INVALID_ID))
                .andExpect(view().name("error"))
                .andExpect(status().is2xxSuccessful());

    }

    @Test
    public void getAddPageAddRoute_TestTheAddPageAndPostRequestWithNotLoggedUser_RedirectAndRedirect() throws Exception {

        mockMvc.perform(get("/routes/add"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));

        mockMvc.perform(
                        multipart("/routes/add")
                                .file((MockMultipartFile) getGpxCoordinatesFile())
                                .param("name", "Route Name")
                                .param("description", "Route Description")
                                .param("level", "BEGINNER")
                                .param("videoUrl", "https://example.com/video")
                                .param("categories", "PEDESTRIAN", "BICYCLE")
                                .contentType(MediaType.MULTIPART_FORM_DATA)
                                .with(csrf())

                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));

    }

    @Test
    @WithMockUserPrincipal
    public void getAddPageAddRoute_TestTheAddPageAndPostRequestWithLoginUser_SuccessfulAndSuccessful() throws Exception {

        mockMvc.perform(get("/routes/add"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("registerRoute"));

        mockMvc.perform(
                        multipart("/routes/add")
                                .file((MockMultipartFile) getGpxCoordinatesFile())
                                .param("name", "Route Name")
                                .param("description", "Route Description")
                                .param("level", "BEGINNER")
                                .param("videoUrl", "https://example.com/video")
                                .param("categories", "PEDESTRIAN", "BICYCLE")
                                .contentType(MediaType.MULTIPART_FORM_DATA)
                                .with(csrf())

                )
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/routes"));

        routeRepository.deleteById(routeRepository.count());
    }

    @Test
    public void getUniqueCategorical_WithValidCategoryIdOrdinal_Successful() throws Exception {
        //            case 0 -> view("pedestrian.html", modelAndView);
        //            case 1 -> view("bicycle.html", modelAndView);
        //            case 2 -> view("motorcycle.html", modelAndView);
        //            case 3 -> view("car.html", modelAndView);

        mockMvc.perform(get("/routes/difficulty/0"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("routes"))
                .andExpect(model().attribute("routes", Matchers.hasSize(1)));

        mockMvc.perform(get("/routes/difficulty/1"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("routes"))
                .andExpect(model().attribute("routes", Matchers.hasSize(2)));

        mockMvc.perform(get("/routes/difficulty/2"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("routes"))
                .andExpect(model().attribute("routes", Matchers.hasSize(1)));

        mockMvc.perform(get("/routes/difficulty/3"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeExists("routes"))
                .andExpect(model().attribute("routes", Matchers.hasSize(2)));

        mockMvc.perform(get("/routes/difficulty/999"))
                .andExpect(status().is2xxSuccessful())
                .andExpect(model().attributeDoesNotExist("routes"))
                .andExpect(view().name("error"));

    }

    private void setUpUserRolesAndUser() {
        if(roleRepository.count() == 0){
            roleRepository.save(new Role(RoleConstant.USER));
            roleRepository.save(new Role(RoleConstant.ADMIN));
            roleRepository.save(new Role(RoleConstant.MODERATOR));
        }
        if (userRepository.count() == 0) {
            UserEntity user = UserEntity.builder()
                    .username("test")
                    .fullName("test testov")
                    .age(17)
                    .password("secret")
                    .email("test@abv.bg")
                    .level(Level.BEGINNER)
                    .roles(Set.of(roleRepository.findByRole(RoleConstant.USER).orElseThrow()))
                    .route(List.of())
                    .pictures(List.of())
                    .messages(List.of())
                    .build();
            UserEntity admin = UserEntity.builder()
                    .username("test")
                    .fullName("test testov")
                    .age(17)
                    .password("secret")
                    .email("test@abv.bg")
                    .level(Level.BEGINNER)
                    .roles(Set.of(roleRepository.findByRole(RoleConstant.ADMIN).orElseThrow()))
                    .route(List.of())
                    .pictures(List.of())
                    .messages(List.of())
                    .build();
            userRepository.saveAndFlush(user);
            userRepository.saveAndFlush(admin);
        }
    }

    private void setViewRoutes() {
        if (routeRepository.count() == 0) {
            List<Route> routes = List.of(
                    Route.builder()
                            .gpxCoordinates("GpsTest1")
                            .description("descriptionTest1")
                            .level(Level.ADVANCED)
                            .name("Test1")
                            .videoUrl("videoUrlTest1")
                            .pictures(List.of())
                            .roles(new HashSet<>(categoryRepository.findAll()))
                            .author(userRepository.findAll().get(0))
                            .build(),
                    Route.builder()
                            .gpxCoordinates("GpsTest2")
                            .description("descriptionTest")
                            .level(Level.ADVANCED)
                            .name("Test2")
                            .videoUrl("videoUrlTest2")
                            .pictures(List.of())
                            .roles(Set.of(categoryRepository.findByName(CategoryConstant.CAR).orElseThrow()
                                    , categoryRepository.findByName(CategoryConstant.BICYCLE).orElseThrow()))
                            .author(userRepository.findAll().get(0))
                            .build()
            );
            routeRepository.saveAndFlush(routes.get(0));
            routeRepository.saveAndFlush(routes.get(1));
        }
    }

    private void setCategories() {
        if(categoryRepository.count() == 0){
            categoryRepository.saveAndFlush(new Categorie(1L, CategoryConstant.CAR, "samo za Koli"));
            categoryRepository.saveAndFlush(new Categorie(2L, CategoryConstant.BICYCLE, "samo za BICYCLE"));
            categoryRepository.saveAndFlush(new Categorie(3L, CategoryConstant.PEDESTRIAN, "samo za PEDESTRIAN"));
            categoryRepository.saveAndFlush(new Categorie(4L, CategoryConstant.MOTORCYCLE, "samo za MOTORCYCLE"));
        }
    }

    private MultipartFile getGpxCoordinatesFile() {
        return new MockMultipartFile(
                "gpxCoordinates",
                "gpx-file.xml",
                MediaType.APPLICATION_XML_VALUE,
                "your gpx content".getBytes()
        );
    }
}
