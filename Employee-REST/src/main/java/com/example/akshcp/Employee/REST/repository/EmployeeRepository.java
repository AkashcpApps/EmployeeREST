package com.example.akshcp.Employee.REST.repository;


import com.example.akshcp.Employee.REST.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;


// interface extending crud repository
@Component
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

  /*  Employee findOne(@PathVariable int id);
    void delete(@PathVariable int id);*/

    Employee findById(int id);
	
}
