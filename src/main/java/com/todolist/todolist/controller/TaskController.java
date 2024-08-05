package com.todolist.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.todolist.todolist.dto.TaskDTO;
import com.todolist.todolist.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService TaskService;

    @GetMapping("/getTasks")
    public List<TaskDTO> getTasks() {
        return TaskService.getAllTasks();
    }

    @PostMapping("/saveTask") //add Task
    public TaskDTO saveTask(@RequestBody TaskDTO TaskDTO) {
        return TaskService.saveTask(TaskDTO);
    }

    @PutMapping("/updateTask")
    public TaskDTO updateTask(@RequestBody TaskDTO TaskDTO) {
        return TaskService.updateTask(TaskDTO);
    }

    @DeleteMapping("/deleteTask")
    public boolean deleteTask(@RequestBody TaskDTO TaskDTO) {
        return TaskService.deleteTask(TaskDTO);
    }
}
