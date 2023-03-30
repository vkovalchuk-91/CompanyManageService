package org.company.kovalchuk.repository;

import org.springframework.stereotype.Repository;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;

import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeToProjectRepositoryImpl implements EmployeeToProjectRepository {
    @Override
    public Optional<List<Project>> getProjectsListByEmployeeId(int employeeId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Employee>> getEmployeesListByProjectId(int projectId) {
        return Optional.empty();
    }

    @Override
    public void addEmployeeToProjectByIds(int employeeId, int projectId) {

    }

    @Override
    public void deleteEmployeeFromProjectByIds(int employeeId, int projectId) {

    }
}
