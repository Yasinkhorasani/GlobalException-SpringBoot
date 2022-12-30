package com.controllerAdvice.Annotation.service;

import com.controllerAdvice.Annotation.entity.Employee;
import com.controllerAdvice.Annotation.exception.NoDataFoundException;
import com.controllerAdvice.Annotation.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private static List<Employee> list = new ArrayList<>();
    static {
     /*   list.add(new Employee(1,"Employee 1", 25,"Deutschland"));
        list.add(new Employee(2,"Employee 2", 27, " Iran"));
        list.add(new Employee(3, "Employee 3", 40," Italian"));
        list.add(new Employee(4, "Employee 4", 22," Frankreich"));
        list.add(new Employee(5, "Employee 5", 47," Afghanistan"));*/
    }

    public List<Employee> getList() {
        if (list.size() > 0) {
            return list;
        }
        throw new NoDataFoundException("No Employee data found");
    }
    public Employee getEmployee(Integer id){
        Optional<Employee> theEmployee = list.stream().filter(e ->e.getId() ==id).findFirst();
       if (!theEmployee.isPresent()){
           throw new ResourceNotFoundException("Employee ist not found for the id" + id);
       }
        return theEmployee.get();
    }
}
