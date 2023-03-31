package org.company.kovalchuk.service.impl;

import org.company.kovalchuk.exception.EmployeeNotFoundException;
import org.company.kovalchuk.exception.ProjectNotFoundException;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.dto.EmployeeDto;
import org.company.kovalchuk.model.dto.EmployeeWithProjectsDto;
import org.company.kovalchuk.model.dto.ProjectDto;
import org.company.kovalchuk.model.dto.ProjectWithEmployeesDto;
import org.company.kovalchuk.repository.ProjectRepository;
import org.company.kovalchuk.service.EmployeeToProjectService;
import org.springframework.stereotype.Service;
import org.company.kovalchuk.repository.EmployeeRepository;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeToProjectServiceImpl implements EmployeeToProjectService {
    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    public EmployeeToProjectServiceImpl(EmployeeRepository employeeRepository,
                                        ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<EmployeeDto> getEmployeesOnProject(long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        return ProjectWithEmployeesDto.getEmployeeDtoListFromModel(project);
    }

    @Override
    public List<ProjectDto> getEmployeeProject(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        return EmployeeWithProjectsDto.getProjectDtoListFromModel(employee);
    }

    @Override
    public void addEmployeeToProject(long employeeId, long projectId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        Set<Employee> projectEmployees = project.getEmployees();
        projectEmployees.add(employee);

        Set<Project> employeeProjects = employee.getProjects();
        employeeProjects.add(project);

        projectRepository.save(project);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeFromProject(long employeeId, long projectId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        Set<Employee> projectEmployees = project.getEmployees();
        projectEmployees.remove(employee);

        Set<Project> employeeProjects = employee.getProjects();
        employeeProjects.remove(project);

        projectRepository.save(project);
        employeeRepository.save(employee);
    }
}
