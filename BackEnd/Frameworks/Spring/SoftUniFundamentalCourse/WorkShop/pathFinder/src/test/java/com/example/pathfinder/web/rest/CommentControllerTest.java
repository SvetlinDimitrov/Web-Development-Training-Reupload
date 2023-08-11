package com.example.pathfinder.web.rest;

import com.example.pathfinder.domain.bindingViews.ViewComment;
import com.example.pathfinder.service.comment.CommentService;
import com.example.pathfinder.setUp.WithMockUserPrincipal;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class CommentControllerTest {

    @MockBean
    private CommentService commentService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;
    @BeforeEach
    void setUp(){
        objectMapper = new ObjectMapper();
    }

    @Test
    public void getAllComments_WithValidRouteId_Successful() throws Exception {
        List<ViewComment> list = createComments();
        Long VALID_ID = 1L;
        when(commentService.getAllByRouteId(VALID_ID)).thenReturn(list);

        mockMvc.perform(MockMvcRequestBuilders.get("/comment/"+ VALID_ID))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].author" , is("TestAuthor1")))
                .andExpect(jsonPath("$[1].author" , is("TestAuthor2")))
                .andExpect(jsonPath("$[2].author" , is("TestAuthor3")));
    }

    @Test
    public void getAllComments_WithInvalidRouteId_NotFound() throws Exception {
        Long IN_VALID_ID = 1L;
        when(commentService.getAllByRouteId(IN_VALID_ID)).thenReturn(null);

        mockMvc.perform(MockMvcRequestBuilders.get("/comment/"+ IN_VALID_ID))
                .andExpect(status().isNotFound());
    }


    @Test
    public void createCommand_WithNotLoggedUser_Redirected() throws Exception {
        ViewComment viewComment = createComments().get(0);

        when(commentService.save(any() , any(), any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders.post("/comment/create/1/1")
                        .content(objectMapper.writeValueAsString(viewComment))
                        .contentType("application/json")
                        .with(csrf()))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/users/login"));
    }

    @Test
    @WithMockUserPrincipal
    public void createCommand_WithLoggedUser_Successful() throws Exception {
        ViewComment viewComment = createComments().get(0);

        when(commentService.save(any() , any(), any())).thenReturn(true);

        mockMvc.perform(MockMvcRequestBuilders
                .post("/comment/create/1/1")
                        .content(objectMapper.writeValueAsString(viewComment))
                        .contentType("application/json")
                        .with(csrf()))
                .andExpect(status().isAccepted());
    }

    private List<ViewComment> createComments() {
        return List.of(
                ViewComment.builder()
                        .id(1L)
                        .approved(true)
                        .author("TestAuthor1")
                        .textContent("testNaContent1")
                        .build(),
                ViewComment.builder()
                        .id(2L)
                        .approved(true)
                        .author("TestAuthor2")
                        .textContent("testNaContent2")
                        .build(),
                ViewComment.builder()
                        .id(3L)
                        .approved(true)
                        .author("TestAuthor3")
                        .textContent("testNaContent3")
                        .build()
        );
    }
}