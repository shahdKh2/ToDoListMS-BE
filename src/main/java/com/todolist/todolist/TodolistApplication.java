package com.todolist.todolist;

import com.todolist.todolist.dto.TaskDTO;
import com.todolist.todolist.entity.Task;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TodolistApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodolistApplication.class, args);
	}



	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.typeMap(Task.class, TaskDTO.class)

				.addMappings(mapper -> mapper.map(Task::is_complete, TaskDTO::setComplete));
		return modelMapper;
	}

}
