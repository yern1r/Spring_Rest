package com.yernaryelemess.spring.rest.service;

import com.yernaryelemess.spring.rest.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee>  getAllEmployees();

    public void saveEmployee(Employee employee);

    public Employee getEmployee(int employer_id);

    public  void  deleteEmployee(int employer_id);
}
