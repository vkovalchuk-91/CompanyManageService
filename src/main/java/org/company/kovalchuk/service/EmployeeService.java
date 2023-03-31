package org.company.kovalchuk.service;

import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.dto.EmployeeDto;
import org.company.kovalchuk.model.dto.EmployeeWithProjectsDto;

public interface EmployeeService {
    EmployeeWithProjectsDto getEmployee(long id);

    void createEmployee(String firstName, String lastName,
                        long employeeTypeId, long programmerLevelId, long programmerTypeId);

    void updateEmployee(long id, String firstName, String lastName,
                        long employeeTypeId, long programmerLevelId, long programmerTypeId);

    void deleteEmployee(long id);
}
