package org.company.kovalchuk.service;

import org.company.kovalchuk.exception.EmployeeNotFoundException;
import org.company.kovalchuk.exception.ProjectNotFoundException;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.repository.EmployeeToProjectRepository;
import org.company.kovalchuk.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.company.kovalchuk.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeToProjectServiceImpl implements EmployeeToProjectService {
    private final EmployeeToProjectRepository employeeToProjectRepository;
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeToProjectServiceImpl(EmployeeToProjectRepository employeeToProjectRepository,
                                        EmployeeRepository employeeRepository,
                                        ProjectRepository projectRepository) {
        this.employeeToProjectRepository = employeeToProjectRepository;
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Employee> getEmployeesOnProject(int projectId) {
        return employeeToProjectRepository.getEmployeesListByProjectId(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
    }

    @Override
    public List<Project> getEmployeeProject(int employeeId) {
        return employeeToProjectRepository.getProjectsListByEmployeeId(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
    }

    @Override
    public void addEmployeeToProject(int employeeId, int projectId) {
        projectRepository.getProjectById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        employeeRepository.getEmployeeById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        employeeToProjectRepository.addEmployeeToProjectByIds(employeeId, projectId);
    }

    @Override
    public void deleteEmployeeFromProject(int employeeId, int projectId) {
        projectRepository.getProjectById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        employeeRepository.getEmployeeById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        employeeToProjectRepository.deleteEmployeeFromProjectByIds(employeeId, projectId);
    }
}
