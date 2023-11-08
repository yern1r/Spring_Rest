package com.yernaryelemess.spring.rest.controller;

import com.yernaryelemess.spring.rest.entity.Employee;

import com.yernaryelemess.spring.rest.exception_handling.NoSuchEmployeeException;
import com.yernaryelemess.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {


    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){

        List<Employee> allEmployees = employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployee(@PathVariable int id){

        Employee employee = employeeService.getEmployee(id);

        if (employee==null){
            throw new NoSuchEmployeeException("There is no employee with ID = "
                    + id + " in DataBase." );
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addNewEmployee(@RequestBody Employee employee){

         employeeService.saveEmployee(employee);
         return employee;

    }

}
