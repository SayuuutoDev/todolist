package com.arhs.todolist.mapper;

import com.arhs.todolist.dto.TaskDTO;
import com.arhs.todolist.models.Task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskMapperTest {
    private TaskMapper taskMapper;

    public  TaskMapperTest() {
        taskMapper = new TaskMapper();
    }

    @Test
    void toDTOTest() {
        Task task = Task
                .builder()
                .taskId(1)
                .title("test task")
                .completed(false)
                .description("test task description")
                .build();

        TaskDTO taskDTO = taskMapper.toDto(task);
        assertNotNull(taskDTO, "taskDto must not be null");
        assertEquals(taskDTO.getTaskId(),task.getTaskId(),"task id not equal");
        assertEquals(taskDTO.getCompleted(),task.getCompleted());
    }

    @Test
    void toDTOWithNullTaskTest() {

        TaskDTO taskDTO = taskMapper.toDto((Task) null);
        assertNull(taskDTO, "taskDto must not be null");
    }


}
