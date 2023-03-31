package org.company.kovalchuk.service;

import org.company.kovalchuk.model.dto.EmployeeDto;
import org.company.kovalchuk.model.dto.ProjectDto;

import java.util.List;

public interface EmployeeToProjectService {
    List<EmployeeDto> getEmployeesOnProject(long projectId);
    List<ProjectDto> getEmployeeProject(long employeeId);
    void addEmployeeToProject(long employeeId, long projectId);
    void deleteEmployeeFromProject(long employeeId, long projectId);
}
