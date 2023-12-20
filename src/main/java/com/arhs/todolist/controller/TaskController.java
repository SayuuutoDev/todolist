package com.arhs.todolist.controller;

import com.arhs.todolist.dto.TaskDTO;
import com.arhs.todolist.exception.NotFoundException;
import com.arhs.todolist.models.Task;
import com.arhs.todolist.models.User;
import com.arhs.todolist.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api")
public class TaskController {
    @Autowired
    TaskService taskService ;

    @GetMapping("/task")
    private List<TaskDTO> listTasks(){
        return taskService.listTasks();
    }
    @PostMapping("/save-task")
    private ResponseEntity<TaskDTO> saveTask(@Valid @RequestBody TaskDTO taskDTO){
            return ResponseEntity.ok(taskService.saveTask(taskDTO));
    }

    @DeleteMapping("/delete/{taskId}")
    public ResponseEntity<?> deleteTask(@PathVariable int taskId) {
            taskService.deleteTask(taskId);
            return ResponseEntity.ok().build();

    }
    @PostMapping("/select-task/{taskId}")
    private ResponseEntity<TaskDTO> selectTask(@PathVariable int taskId){
        Optional<TaskDTO> selectedTask = taskService.selectTask(taskId);
        if (selectedTask.isPresent()){
            return ResponseEntity.ok(selectedTask.get());
        }else {
            throw new NotFoundException("La tache n'existe pas");
        }
    }



}
