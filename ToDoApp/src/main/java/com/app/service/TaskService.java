package com.app.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.models.Task;
import com.app.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository repository;
	public List<Task> getAllTasks(){
		return this.repository.findAll(); 
	}
	public void createTask(String title) {
		Task task = new Task();
		task.setTitle(title);
		task.setCompleated(false);
		this.repository.save(task);
		
	}
	
	public void deleteTask(Long id) {
		this.repository.deleteById(id);
		
	}
	public void toggleTask(Long id) {
		
		Task task =this.repository.findById(id)
		.orElseThrow(() -> new IllegalArgumentException("Invalid task id"));
		task.setCompleated(!task.isCompleated());
		this.repository.save(task);
		
	}
}
