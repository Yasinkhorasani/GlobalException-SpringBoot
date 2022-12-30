package com.controllerAdvice.Annotation.controller;

import java.util.List;

import com.controllerAdvice.Annotation.entity.Employee;
import com.controllerAdvice.Annotation.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class EmployeeController {
    @Autowired
    EmployeeService eService;

    @GetMapping("/employees")
    public List<Employee> getList () {
        return eService.getList();
    }

    @GetMapping("/employees/{id}")
    public Employee get (@PathVariable Integer id) {
        return eService.getEmployee(id);
    }
}
