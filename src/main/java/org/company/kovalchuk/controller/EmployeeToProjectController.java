package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.EmployeeDto;
import org.company.kovalchuk.model.dto.ProjectDto;
import org.company.kovalchuk.service.EmployeeToProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeToProjectController {

    private final EmployeeToProjectService employeeToProjectService;

    public EmployeeToProjectController(EmployeeToProjectService employeeToProjectService) {
        this.employeeToProjectService = employeeToProjectService;
    }

    @GetMapping(value = "/employees/{employeeId:\\d+}/projects")
    public List<ProjectDto> getEmployeeProject(@PathVariable int employeeId) {
        return employeeToProjectService.getEmployeeProject(employeeId);
    }

    @GetMapping(value = "/projects/{projectId:\\d+}/employees")
    public List<EmployeeDto> getEmployeesOnProject(@PathVariable int projectId) {
        return employeeToProjectService.getEmployeesOnProject(projectId);
    }

    @PostMapping(value = "/projects/{projectId:\\d+}/employees/{employeeId:\\d+}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployeeToProject(@PathVariable int projectId, @PathVariable int employeeId) {
        employeeToProjectService.addEmployeeToProject(employeeId, projectId);
    }

    @DeleteMapping(value = "/projects/{projectId:\\d+}/employees/{employeeId:\\d+}")
    public void deleteEmployeeFromProject(@PathVariable int projectId, @PathVariable int employeeId) {
        employeeToProjectService.deleteEmployeeFromProject(employeeId, projectId);
    }
}