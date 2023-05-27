package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class TodoControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private TodoController todoController;

    private final static Long existingUserId = 2L;

    private final static Long nonExistingUserId=100000L;

    private final static Long existingTaskId = 1L;

    @Test
    public void contextLoads() throws Exception{
        assertThat(todoController).isNotNull();
    }

    @Test
    public void shouldReturnTasksFromExistingUser() throws Exception{
        String url = "/todo?todoId="+existingUserId;
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldUpdateStatusTasksFromExistingUser() throws Exception{

        String url = "/todo?id="+existingTaskId;
        this.mockMvc.perform(put(url)).andDo(print()).andExpect(status().isOk());

    }

    @Test
    public void shouldReturnBadRequestAfterAskingNonExistingUserTasks() throws Exception{
        String url = "/todo?todoId="+nonExistingUserId;
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isBadRequest());
    }
}
