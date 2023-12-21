package com.arhs.todolist.controller;

import com.arhs.todolist.TodolistApplication;
import com.arhs.todolist.dto.TaskDTO;
import com.arhs.todolist.service.TaskService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TodolistApplication.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class TaskControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TaskService service;

    @Test
    public void givenEmployees_whenGetEmployees_thenStatus200()
            throws Exception {
        TaskDTO task = TaskDTO.builder().title("title1").build();
        Mockito.when(service.listTasks()).thenReturn(List.of(task));

        mvc.perform(get("/api/task")).andDo(print())
                .andExpect(status().isOk())
                .andExpect(content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$[0].title", is("title1")));
        Mockito.verify(service).listTasks();
    }
}
