package com.yernaryelemess.spring.rest.service;

import com.yernaryelemess.spring.rest.dao.EmployeeDAO;
import com.yernaryelemess.spring.rest.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAllEmployees() {

        return employeeDAO.getAllEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {

        employeeDAO.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployee(int employer_id) {
        return employeeDAO.getEmployee(employer_id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int employer_id) {
        employeeDAO.deleteEmployee(employer_id);
    }
}
