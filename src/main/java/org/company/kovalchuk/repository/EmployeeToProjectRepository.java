package org.company.kovalchuk.repository;

import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;

import java.util.List;
import java.util.Optional;

public interface EmployeeToProjectRepository {
    Optional<List<Project>> getProjectsListByEmployeeId(int employeeId);

    Optional<List<Employee>> getEmployeesListByProjectId(int projectId);

    void addEmployeeToProjectByIds(int employeeId, int projectId);

    void deleteEmployeeFromProjectByIds(int employeeId, int projectId);
}
