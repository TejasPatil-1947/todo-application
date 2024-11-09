package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.models.Task;
import com.app.service.TaskService;



@Controller
public class TaskController {

	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public String getTask(Model model) {
		List<Task> tasks= this.taskService.getAllTasks();
		model.addAttribute("tasks", tasks);
		return "tasks";
	}
	
	@PostMapping
	public String createTask(@RequestParam String title) {
		this.taskService.createTask(title);
		return "redirect:/";
	}
	
	@GetMapping("/{id}/delete")
	public String deleteTask(@PathVariable Long id) {
		this.taskService.deleteTask(id);
		return "redirect:/";
	}
	@GetMapping("/{id}/toggle")
	public String toggleTask(@PathVariable Long id) {
		this.taskService.toggleTask(id);
		return "redirect:/";
	}
}
