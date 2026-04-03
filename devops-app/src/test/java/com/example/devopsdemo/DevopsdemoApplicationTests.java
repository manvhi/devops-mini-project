package com.example.devopsdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class DevopsdemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTasksReturnsEmptyList() throws Exception {
        mockMvc.perform(get("/tasks"))
               .andExpect(status().isOk())
               .andExpect(content().json("[]"));
    }

    @Test
    void testAddTask() throws Exception {
        mockMvc.perform(post("/tasks")
               .contentType(MediaType.APPLICATION_JSON)
               .content("\"Buy groceries\""))
               .andExpect(status().isOk())
               .andExpect(content().string("Task added"));
    }

    @Test
    void testGetTasksAfterAdding() throws Exception {
        mockMvc.perform(post("/tasks")
               .contentType(MediaType.APPLICATION_JSON)
               .content("\"Study DevOps\""));

        mockMvc.perform(get("/tasks"))
               .andExpect(status().isOk())
               .andExpect(content().string(org.hamcrest.Matchers.containsString("Study DevOps")));
    }
}