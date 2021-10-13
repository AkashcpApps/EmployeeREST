package com.example.akshcp.Employee.REST.service;


import com.example.akshcp.Employee.REST.controller.TaskController;
import com.example.akshcp.Employee.REST.model.Task;
import com.example.akshcp.Employee.REST.repository.TaskRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class TaskService {
    static final Logger logger = LogManager.getLogger(TaskController.class.getName());

    @Autowired
    private TaskRepository departmentRepository;

    public List<Task> getAllTasks() {
        List<Task> departmentList = null;
        try {
			departmentList = (List<Task>) departmentRepository.findAll();
            return departmentList;
        } catch (Exception e) {
            logger.info("Error-----> " + e.getMessage());
            return departmentList;
        }


    }

    public boolean addTask(Task d) {
        try {
            departmentRepository.save(d);
            return true;
        } catch (Exception exception) {
            logger.info("Error-----> " + exception.getMessage());
            return false;

        }
    }


    public boolean updateTask(Task d, int id) {
        try {
            if (id == d.getTask_ID()) {
                departmentRepository.save(d);
                Task department = departmentRepository.findById(id);
                if (department.getTask_ID() > 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        } catch (Exception e) {
            logger.info("Error-----> " + e.getMessage());
        }
        return false;
    }

    public boolean deleteTaskByID(int id) {
        boolean isFound = departmentRepository.existsById(id);
        try {
            if (isFound) {
                Task department = new Task();
                department.setTask_ID(id);
                departmentRepository.delete(department);
                return true;
            } else {
                return false;
            }


        } catch (EntityNotFoundException e) {
            logger.info("Error-----> " + e.getMessage());
            return false;

        }
    }

}
