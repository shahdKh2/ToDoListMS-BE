package com.todolist.todolist.service;

import com.todolist.todolist.dto.TaskDTO;
import com.todolist.todolist.entity.Task;
import com.todolist.todolist.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@Service
@Transactional
public class TaskService {
    private static final Logger logger = LoggerFactory.getLogger(TaskService.class);

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private ModelMapper modelMapper;
    // -----------------------------------------

    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = modelMapper.map(taskDTO, Task.class);
        Task savedTask = taskRepository.save(task);
        System.out.println("---------------------------");

        logger.info("Saved Task: {}", savedTask);
        return modelMapper.map(savedTask, TaskDTO.class);
    }
    // -----------------------------------------

    public List<TaskDTO> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        taskList.forEach(task -> logger.info("Fetched Task: {}", task));
        List<TaskDTO> taskDTOList = modelMapper.map(taskList, new TypeToken<List<TaskDTO>>() {}.getType());
        taskDTOList.forEach(taskDTO -> logger.info("Mapped TaskDTO: {}", taskDTO)); // *****
        return taskDTOList;
    }


    // -----------------------------------------

    public Task updateTask(Integer id, boolean is_complete) { // returns task
        Task existingTask = taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task not found"));
        System.out.println("---------------------------");

        System.out.println("Before update: " + existingTask.is_complete());
        System.out.println("---------------------------");
        existingTask.setComplete(is_complete);
        Task updatedTask = taskRepository.save(existingTask);

        System.out.println("Updated Task Completion Status ***after: " + updatedTask.is_complete());
        System.out.println("---------------------------");

        System.out.println(updatedTask.toString() + "  :tst");

        return updatedTask;
    }
    // -----------------------------------------

    public boolean deleteTask(Integer id) {
        try {
            Task task = taskRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Task not founddd"));

            taskRepository.delete(task);
            return true;
        } catch (Exception e) {
            throw new RuntimeException("Task deletion failed", e);
        }
    }

}
