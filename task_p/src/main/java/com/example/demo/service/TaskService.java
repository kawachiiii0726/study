package com.example.demo.service;


import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dto.TaskUpdateRequest;
import com.example.demo.dto.TaskRequest;
import com.example.demo.entity.TaskEntity;
import com.example.demo.repository.TaskRepository;



@Service
@Transactional(rollbackFor = Exception.class)

public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	  public List<TaskEntity> searchAll() {
		    return taskRepository.findAll();
     }
	  
	  public TaskEntity findById(Integer id) {
		    return taskRepository.getOne(id);
		  }
	  
	  public void create(TaskRequest taskRequest) {
		    Date now = new Date();
		    TaskEntity task = new TaskEntity();
		    task.setTaskName(taskRequest.getTaskName());
		    task.setTaskStatus(taskRequest.getTaskStatus());
		    task.setStartDate(now);
		    task.setEndDate(now);
		    taskRepository.save(task);
	  }
	  
	  public void update(TaskUpdateRequest taskUpdateRequest) {
		    TaskEntity task = findById(taskUpdateRequest.getTaskId());	    
		    task.setTaskName(taskUpdateRequest.getTaskName());
		    task.setTaskStatus(taskUpdateRequest.getTaskStatus());
		    task.setStartDate(new Date());
		    task.setEndDate(new Date());
		    taskRepository.save(task);
		  }
	  
	 
	  public void delete(Integer id) {
	        TaskEntity del = findById(id);
	        taskRepository.delete(del);
   }
}
