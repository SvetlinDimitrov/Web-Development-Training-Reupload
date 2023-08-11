package com.example.pathfinder.web;

import com.example.pathfinder.domain.bindingViews.ViewUser;
import com.example.pathfinder.domain.constants.Level;
import com.example.pathfinder.domain.constants.RoleConstant;
import com.example.pathfinder.service.user.UserService;
import com.example.pathfinder.setUp.WithMockUserPrincipal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;
import java.util.Set;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    private ViewUser viewUser;

    @BeforeEach
    void setUp() {
        viewUser = ViewUser.builder()
                .username("test")
                .fullName("test testov")
                .age(17)
                .email("test@abv.bg")
                .level(Level.BEGINNER)
                .roles(Set.of())
                .route(List.of())
                .pictures(List.of())
                .messages(List.of())
                .build();
        viewUser.setId(1L);

    }

    @Test
    public void getRegisterPage_withNotLoggedUser_SuccessfullyLoad() throws Exception {
        mockMvc.perform(get("/users/register"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void register_withCorrectData_SuccessfullyRegistered() throws Exception {
        //TODO:fix null forward URL
        mockMvc.perform(MockMvcRequestBuilders.post("/users/register")
                        .param("username" , "testUsername")
                        .param("fullName" , "testFullName")
                        .param("age" , "20")
                        .param("password" , "12345")
                        .param("email" , "testEmail@abv.bg")
                        .param("confirmPassword" , "12345")
                        .with(csrf())
                )
                .andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
//                .andExpect(f("http://localhost/users/login"));
    }

    @Test
    public void register_withNotCorrectData_() throws Exception {
        //TODO:fix null forward URL
        mockMvc.perform(MockMvcRequestBuilders.post("/users/register")
                        .param("username" , "")
                        .param("fullName" , "testFullName")
                        .param("age" , "20")
                        .param("password" , "12345")
                        .param("email" , "")
                        .param("confirmPassword" , "1232222245")
                        .with(csrf())
                )
                .andExpect(model().hasErrors());
//                .andExpect(forwardedUrlTemplate("register"));
    }

    @Test
    public void getLoginPage_defaultPage_Successful() throws Exception {
        mockMvc.perform(get("/users/login"))
                .andExpect(status().is2xxSuccessful());
    }

    @Test
    public void profile_withNotLoggedUser_Redirect() throws Exception {
        mockMvc.perform(get("/users/profile"))
                .andExpect(status().is3xxRedirection())
                .andExpect(MockMvcResultMatchers.redirectedUrl("http://localhost/users/login"));
    }
    @Test
    @WithMockUserPrincipal
    public void profile_withLoggedUser_Successful() throws Exception {

        MockHttpSession session = new MockHttpSession();
        session.setAttribute("loggedUser", viewUser);


        mockMvc.perform(get("/users/profile")
                        .session(session))
                .andExpect(status().is2xxSuccessful())
                .andExpect(view().name("profile"));
    }

    @Test
    public void admin_WithNotLoggedUser_Redirected() throws Exception {
        mockMvc.perform(get("/users/admin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    @WithMockUserPrincipal(roles = {RoleConstant.USER , RoleConstant.MODERATOR})
    public void admin_WithLoggedUserNotValidRoles_Forbidden() throws Exception {
        mockMvc.perform(get("/users/admin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUserPrincipal(roles = {RoleConstant.ADMIN})
    public void admin_WithLoggedUserValidRole_Successful() throws Exception {
        mockMvc.perform(get("/users/admin"))
                .andExpect(status().is2xxSuccessful());
    }


}