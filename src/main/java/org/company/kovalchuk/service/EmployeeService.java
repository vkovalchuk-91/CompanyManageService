package org.company.kovalchuk.service;

import org.company.kovalchuk.model.Employee;

public interface EmployeeService {
    Employee getEmployee(int id);

    void createEmployee(String firstName, String lastName,
                        int employeeTypeId, int programmerLevelId, int programmerTypeId);

    void updateEmployee(int id, String firstName, String lastName,
                        int employeeTypeId, int programmerLevelId, int programmerTypeId);

    void deleteEmployee(int id);
}
