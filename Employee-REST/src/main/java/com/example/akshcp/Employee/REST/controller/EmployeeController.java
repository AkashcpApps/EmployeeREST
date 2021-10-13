package com.example.akshcp.Employee.REST.controller;



import com.example.akshcp.Employee.REST.model.Employee;
import com.example.akshcp.Employee.REST.model.ResponseModel;
import com.example.akshcp.Employee.REST.service.EmployeeService;
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
@RequestMapping("/employee")
public class EmployeeController {

    static final Logger logger = LogManager.getLogger(EmployeeController.class.getName());

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private ResponseModel responseModel;

    @GetMapping("/getAllEmployees")
    public ResponseModel getAllEmployee() {
        if (employeeService.getAllEmployees().size() > 0) {
            responseModel.setStatus(true);
            responseModel.setStatusCode(200);
            responseModel.setMessage("Data present");
            responseModel.setTaskList(null);
            responseModel.setEmployeeList(employeeService.getAllEmployees());

        } else {
            responseModel.setStatus(false);
            responseModel.setStatusCode(400);
            responseModel.setMessage("Data not present");
            responseModel.setEmployeeList(null);
            responseModel.setTaskList(null);
        }
        return responseModel;

    }


    @PostMapping("/InsertEmployee")
    public ResponseModel addEmployees(@RequestBody Employee employee) {
        if (employeeService.addEmployee(employee)) {
            responseModel.setStatus(true);
            responseModel.setStatusCode(200);
            responseModel.setMessage("Successfully insertion");
            responseModel.setEmployeeList(null);
        } else {
            responseModel.setStatus(false);
            responseModel.setStatusCode(400);
            responseModel.setMessage("Failed to insert");
            responseModel.setEmployeeList(null);
        }
        return responseModel;
    }

    @PutMapping("/UpdateEmployee/{id}")
    public ResponseModel updateEmployee(@RequestBody Employee e, @PathVariable int id) {
        if (employeeService.updateEmployee(e, id)) {
            responseModel.setStatus(true);
            responseModel.setStatusCode(200);
            responseModel.setMessage("Successfully Updated ");
            responseModel.setEmployeeList(null);
        } else {
            responseModel.setStatus(false);
            responseModel.setStatusCode(400);
            responseModel.setMessage("Failed to Update");
            responseModel.setEmployeeList(null);
        }
        return responseModel;
    }


    @DeleteMapping("deleteEmployee/{id}")
    public ResponseModel deleteEmployeeByID(@PathVariable int id) {
        if (employeeService.deleteEmployeeByID(id)) {
            responseModel.setStatus(true);
            responseModel.setStatusCode(200);
            responseModel.setMessage("Successfully Deleted ");
            responseModel.setEmployeeList(null);
        } else {
            responseModel.setStatus(false);
            responseModel.setStatusCode(400);
            responseModel.setMessage("Failed to Delete");
            responseModel.setEmployeeList(null);
        }
        return responseModel;
    }


}


