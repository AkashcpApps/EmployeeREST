package com.example.akshcp.Employee.REST.model;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResponseModel {
    private int statusCode;
    private boolean isStatus;
    private String message;
    List<Employee> employeeList;
    List<Task> taskList;

    public ResponseModel(int statusCode, boolean isStatus, String message, List<Employee> employeeList, List<Task> taskList) {
        this.statusCode = statusCode;
        this.isStatus = isStatus;
        this.message = message;
        this.employeeList = employeeList;
        this.taskList = taskList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public ResponseModel() {
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public boolean isStatus() {
        return isStatus;
    }

    public void setStatus(boolean status) {
        isStatus = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
