package com.example.akshcp.Employee.REST.model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;


@Entity
@Table(name="task")
public class Task {

	@Id
	@Column(name="TASK_ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int task_ID;
	private String short_Name;
	private String task_Name;
	
	public Task() {
	
	}
	
	public Task(int task_ID){
		super();
		this.task_ID = task_ID;
	}
	
	public Task(int task_ID, String short_Name, String task_Name) {
		super();
		this.task_ID = task_ID;
		this.short_Name = short_Name;
		this.task_Name = task_Name;
	}

	public int getTask_ID() {
		return task_ID;
	}

	public void setTask_ID(int task_ID) {
		this.task_ID = task_ID;
	}

	public String getShort_Name() {
		return short_Name;
	}

	public void setShort_Name(String short_Name) {
		this.short_Name = short_Name;
	}

	public String getTask_Name() {
		return task_Name;
	}

	public void setTask_Name(String task_Name) {
		this.task_Name = task_Name;
	}
}
