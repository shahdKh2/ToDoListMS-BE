package com.todolist.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.todolist.todolist.dto.TaskDTO;
import com.todolist.todolist.entity.Task; // Make sure to import Task here

// import com.todolist.todolist.entity.Task; //* */

import com.todolist.todolist.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tasks")
@CrossOrigin
public class TaskController {

    @Autowired
    private TaskService taskService;

   

    @GetMapping("/getTasks") // done
    public ResponseEntity<List<TaskDTO>> getTasks() {
        try {
            List<TaskDTO> tasks = taskService.getAllTasks();
            return ResponseEntity.ok(tasks);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping("/saveTask") // done
    public TaskDTO saveTask(@RequestBody TaskDTO taskDTO) {
        return taskService.saveTask(taskDTO);
    }

    // -----------------------------------------

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Integer id, @RequestBody TaskDTO taskDTO) {
        try {
            System.out.println(
                    "Received update request for task ID: " + id + " with isComplete: " + taskDTO.is_complete());
            Task updatedTask = taskService.updateTask(id, taskDTO.is_complete());
            System.out.println("Returning updated task: " + updatedTask);
            return ResponseEntity.ok(updatedTask);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    // -----------------------------------------

    @DeleteMapping("/deleteTask/{id}") // done
    public ResponseEntity<Boolean> deleteTask(@PathVariable Integer id) {
        try {
            boolean result = taskService.deleteTask(id);
            return ResponseEntity.ok(result);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(false);
        }
    }

}
