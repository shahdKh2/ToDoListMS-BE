package com.todolist.todolist.service;

import com.todolist.todolist.dto.TaskDTO;
import com.todolist.todolist.entity.Task;
import com.todolist.todolist.repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class TaskService {

    @Autowired
    private TaskRepository TaskRepository;

    @Autowired
    private ModelMapper modelMapper;

    public TaskDTO saveTask(TaskDTO TaskDTO){
        TaskRepository.save(modelMapper.map(TaskDTO, Task.class));
        return TaskDTO;
    }

    public List<TaskDTO> getAllTasks(){
        List<Task> TaskList = TaskRepository.findAll();
        return modelMapper.map(TaskList, new TypeToken<List<TaskDTO>>(){}.getType());
    }

    public TaskDTO updateTask(TaskDTO TaskDTO){
        TaskRepository.save(modelMapper.map(TaskDTO,Task.class));
        return TaskDTO;
    }

    public boolean deleteTask(TaskDTO TaskDTO){
        TaskRepository.delete(modelMapper.map(TaskDTO, Task.class));
        return true;
    }


}