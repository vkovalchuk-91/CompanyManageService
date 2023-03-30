package org.company.kovalchuk.repository;

import org.company.kovalchuk.model.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeRepositoryImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Optional<Employee> getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        Employee employee = session.get(Employee.class, id);
        return Optional.of(employee);
    }

    @Override
    public void insertEmployee(String firstName, String lastName,
                               int employeeTypeId, int programmerLevelId, int programmerTypeId) {

    }

    @Override
    public void updateEmployee(int id, String firstName, String lastName,
                               int employeeTypeId, int programmerLevelId, int programmerTypeId) {

    }

    @Override
    public void deleteEmployeeById(int id) {

    }
}
