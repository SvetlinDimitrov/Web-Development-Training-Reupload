package com.example.mobilelegraderebuild.web.controller;

import com.example.mobilelegraderebuild.service.User.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;


//    @Test
//    void getRegister_GetTheDefaultPage_returnDefaultPageSuccessfully() throws Exception {
//        mockMvc.perform(get("/users/register"))
//                .andExpect(status().isOk()) // Expect HTTP status code 200 (OK)
//                .andExpect(view().name("auth-register")) // Expect the view name to be "auth-register"
//                .andExpect(model().attributeExists("userRegister", "roles")); // Expect these model attributes to exist
//
//    }

    @Test
    void register() {

    }

    @Test
    void getLogin() throws Exception {
        mockMvc.perform(get("/users/login"))
                .andExpect(status().is2xxSuccessful());
    }
}