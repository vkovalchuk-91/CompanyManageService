package org.company.kovalchuk.service;

import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;

import java.util.List;

public interface EmployeeToProjectService {
    List<Employee> getEmployeesOnProject(int projectId);
    List<Project> getEmployeeProject(int employeeId);
    void addEmployeeToProject(int employeeId, int projectId);
    void deleteEmployeeFromProject(int employeeId, int projectId);
}
