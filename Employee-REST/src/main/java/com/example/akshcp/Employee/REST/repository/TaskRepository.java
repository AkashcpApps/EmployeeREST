package com.example.akshcp.Employee.REST.repository;


import com.example.akshcp.Employee.REST.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface TaskRepository extends JpaRepository<Task, Integer> {

    Task findById(int id);

    long deleteById(@Param("TASK_ID") int TASK_ID);

}
