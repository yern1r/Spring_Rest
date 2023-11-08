package com.yernaryelemess.spring.rest.dao;

import com.yernaryelemess.spring.rest.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    @Autowired
    private SessionFactory sessionFactory;



    @Override
    public List<Employee> getAllEmployees() {

        Session session = sessionFactory.getCurrentSession();

        Query<Employee> query = session.createQuery("from Employee"
                , Employee.class);

        List<Employee> allEmployees = query.getResultList();


        return allEmployees;
    }

    @Override
    public void saveEmployee(Employee employee) {

        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployee(int employer_id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class , employer_id);
        return employee;
    }

    @Override
    public void deleteEmployee(int employer_id) {

        Session session = sessionFactory.getCurrentSession();
        Query<Employee> query = session.createQuery("delete from Employee " +
                "where employer_id =: employeeId");
        query.setParameter("employeeId", employer_id);
        query.executeUpdate();
    }
}
