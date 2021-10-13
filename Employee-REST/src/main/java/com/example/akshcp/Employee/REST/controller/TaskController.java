package com.example.akshcp.Employee.REST.controller;


import com.example.akshcp.Employee.REST.model.ResponseModel;
import com.example.akshcp.Employee.REST.model.Task;
import com.example.akshcp.Employee.REST.service.TaskService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/task")
public class TaskController {

    static final Logger logger = LogManager.getLogger(TaskController.class.getName());

    @Autowired
    private TaskService departmentService;

    @Autowired
    private ResponseModel responseModel;

    @GetMapping("/getAllTasks")
    public ResponseModel getAllDepartment() {
        logger.info("GetAllDepartment Called Method->GET");
        if (departmentService.getAllTasks().size() > 0) {
            responseModel.setStatus(true);
            responseModel.setStatusCode(200);
            responseModel.setMessage("Data present");
            responseModel.setTaskList(departmentService.getAllTasks());
        } else {
            responseModel.setStatus(false);
            responseModel.setStatusCode(400);
            responseModel.setMessage("Data not present");
            responseModel.setEmployeeList(null);
            responseModel.setTaskList(null);

        }

        return responseModel;
    }


    @PostMapping("/insertTask")
    public ResponseModel addDepartment(@RequestBody Task task) {
        logger.info("addDepartment Called Method->POST");
        if (departmentService.addTask(task)) {
            responseModel.setStatus(true);
            responseModel.setStatusCode(200);
            responseModel.setMessage("Successfully insertion");
            responseModel.setEmployeeList(null);
            responseModel.setTaskList(null);
        } else {
            responseModel.setStatus(false);
            responseModel.setStatusCode(400);
            responseModel.setMessage("Failed to insert");
            responseModel.setEmployeeList(null);
            responseModel.setTaskList(null);
        }
        return responseModel;

    }

    @PutMapping("/UpdateTask/{id}")
    public ResponseModel updateDepartment(@RequestBody Task d, @PathVariable int id) {
        logger.info("UpdateDepartment Called Method->PUT id:" + id);
        if (departmentService.updateTask(d, id)) {
            responseModel.setStatus(true);
            responseModel.setStatusCode(200);
            responseModel.setMessage("Successfully Updated ");
            responseModel.setEmployeeList(null);
            responseModel.setTaskList(null);
        } else {
            responseModel.setStatus(false);
            responseModel.setStatusCode(400);
            responseModel.setMessage("Failed to Update");
            responseModel.setEmployeeList(null);
            responseModel.setTaskList(null);
        }
        return responseModel;
    }

    @DeleteMapping("deleteTask/{id}")
    public ResponseModel deleteDepartmentByID(@PathVariable int id) {
        logger.info("deleteDepartmentByID Called Method->Delete id:" + id);
        if (departmentService.deleteTaskByID(id)) {
            responseModel.setStatus(true);
            responseModel.setStatusCode(200);
            responseModel.setMessage("Successfully Deleted ");
            responseModel.setEmployeeList(null);
            responseModel.setTaskList(null);
        } else {
            responseModel.setStatus(false);
            responseModel.setStatusCode(400);
            responseModel.setMessage("Failed to Delete");
            responseModel.setEmployeeList(null);
            responseModel.setTaskList(null);
        }
        return responseModel;
    }


}
