package com.example.demo.controller;


import com.example.demo.entity.UserEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserController userController;


    private static final Long existingUserId = 2L;

    private static final Long nonExistingUserId=100000L;


    @Test
    public void shouldReturnExistingUser() throws Exception{
        // it can be crashed if we delete user with id 2
        String url = "/user?userId="+existingUserId;
        this.mockMvc.perform(get(url)).andDo(print()).andExpectAll(status().isOk());

    }

    @Test
    public void shouldReturnBadRequestAfterAskingAboutNonExistingUser() throws Exception{
        String url = "/user?userId="+nonExistingUserId;
        this.mockMvc.perform(get(url)).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void contextLoads() throws Exception{
        assertThat(userController).isNotNull();
    }

    @Test
    public void testInsertObject() throws Exception {
        String url =  "/user";
        UserEntity user = new UserEntity();
        user.setPassword("adgsdg");
        user.setUsername("Oleg");



        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
        ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
        String requestJson=ow.writeValueAsString(user);

        //... more
        mockMvc.perform(MockMvcRequestBuilders
                        .post(url)
                        .content(requestJson)
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }

}
