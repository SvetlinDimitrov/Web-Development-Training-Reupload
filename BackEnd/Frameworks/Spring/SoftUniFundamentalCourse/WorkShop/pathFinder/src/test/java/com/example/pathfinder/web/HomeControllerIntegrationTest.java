package com.example.pathfinder.web;

import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.domain.dtos.RegisterUserDto;
import com.example.pathfinder.domain.entity.Role;
import com.example.pathfinder.repos.RoleRepository;
import com.example.pathfinder.service.security.UserDetailServiceImp;
import com.example.pathfinder.service.user.UserService;
import com.example.pathfinder.setUp.WithMockUserPrincipal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class HomeControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserService userService;

    @Autowired
    private RoleRepository roleRepository;


    @BeforeEach
    void setUp(){
       setUpUserRolesAndUser();
    }

    @Test
    @WithMockUserPrincipal(username = "test")
    public void getHome_testWithRegisteredUser_Successful() throws Exception {
        MockHttpSession session = new MockHttpSession();

        mockMvc.perform(MockMvcRequestBuilders.get("/")
                        .session(session))
                .andExpect(status().is2xxSuccessful());

        Object user = session.getAttribute("loggedUser");
        assertNotNull(user);
    }
    private void setUpUserRolesAndUser(){
        roleRepository.save(new Role(RoleConstant.USER));
        roleRepository.save(new Role(RoleConstant.ADMIN));
        roleRepository.save(new Role(RoleConstant.MODERATOR));

        userService.register(new RegisterUserDto(
                "test",
                "test testov",
                17,
                "12345",
                "test@abv.bg",
                "12345"));
    }
}
