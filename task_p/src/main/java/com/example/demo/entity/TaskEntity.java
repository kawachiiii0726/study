package com.example.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;




@Data
@Entity
@Table(name = "Task", schema = "public")
public class TaskEntity {

	
	
	 @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "Task_id")
	  private Integer TaskId;
	 
	  @Column(name = "Task_name")
	  private String TaskName;
	  
	  @Column(name = "Task_status")
	  private String TaskStatus;
	  
	  @Column(name = "start_date")
	  private Date startDate;
	  
	  @Column(name = "end_date")
	  private Date endDate;
}
	