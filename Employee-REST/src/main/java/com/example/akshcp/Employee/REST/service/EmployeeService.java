package com.example.akshcp.Employee.REST.service;


import com.example.akshcp.Employee.REST.controller.TaskController;
import com.example.akshcp.Employee.REST.model.Employee;
import com.example.akshcp.Employee.REST.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;


@Service
public class EmployeeService {
    static final Logger logger = LogManager.getLogger(TaskController.class.getName());

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = null;
        try {
			employeeList = (List<Employee>) employeeRepository.findAll();
            return employeeList;
        } catch (Exception e) {
            logger.info("Error-----> " + e.getMessage());
            return employeeList;

        }
    }


    public boolean addEmployee(Employee e) {
        try {
            employeeRepository.save(e);
            return true;
        } catch (Exception exception) {
            logger.info("Error-----> " + exception.getMessage());
            return false;

        }

    }

    // updating employee by id
    public boolean updateEmployee(Employee emp, int id) {
        try {
            if (id == emp.getEmployeeID()) {
                employeeRepository.save(emp);
                Employee department = employeeRepository.findById(id);
                if (department.getEmployeeID() > 0) {
                    return true;
                } else {
                    return false;
                }
            }
            return false;

        } catch (Exception e) {
            logger.info("Error-----> " + e.getMessage());
            return false;
        }
    }


    public boolean deleteEmployeeByID(int id) {
        boolean isFound = employeeRepository.existsById(id);
        try {
            if (isFound) {
                Employee department = new Employee();
                department.setEmployeeID(id);
                employeeRepository.delete(department);
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
