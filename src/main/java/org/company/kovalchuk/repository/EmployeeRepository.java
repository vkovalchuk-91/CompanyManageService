package org.company.kovalchuk.repository;

import org.company.kovalchuk.model.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    Optional<Employee> getEmployeeById(int id);

    void insertEmployee(String firstName, String lastName,
                        int employeeTypeId, int programmerLevelId, int programmerTypeId);

    void updateEmployee(int id, String firstName, String lastName,
                        int employeeTypeId, int programmerLevelId, int programmerTypeId);

    void deleteEmployeeById(int id);
}
