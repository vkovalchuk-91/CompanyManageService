package org.company.kovalchuk.service;

import org.company.kovalchuk.model.dto.EmployeeWithProjectsDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeWithProjectsDto> getAllEmployees();
    EmployeeWithProjectsDto getEmployee(long id);

    void createEmployee(String firstName, String lastName,
                        long employeeTypeId, long programmerLevelId, long programmerTypeId);

    void updateEmployee(long id, String firstName, String lastName,
                        long employeeTypeId, long programmerLevelId, long programmerTypeId);

    void deleteEmployee(long id);
}
