package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.models.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
