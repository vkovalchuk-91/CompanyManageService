package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.EmployeeDto;
import org.company.kovalchuk.model.dto.ProjectDto;
import org.company.kovalchuk.model.dto.TeamDto;
import org.company.kovalchuk.service.EmployeeToTeamToProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeToTeamToProjectController {

    private final EmployeeToTeamToProjectService employeeToTeamToProjectService;

    public EmployeeToTeamToProjectController(EmployeeToTeamToProjectService employeeToProjectService) {
        this.employeeToTeamToProjectService = employeeToProjectService;
    }

    @GetMapping(value = "/teams/{teamId:\\d+}/employees")
    public List<EmployeeDto> getEmployeesInTeam(@PathVariable long teamId) {
        return employeeToTeamToProjectService.getEmployeesInTeam(teamId);
    }

    @GetMapping(value = "/employees/{employeeId:\\d+}/teams")
    public List<TeamDto> getEmployeeTeams(@PathVariable long employeeId) {
        return employeeToTeamToProjectService.getEmployeeTeams(employeeId);
    }

    @GetMapping(value = "/projects/{projectId:\\d+}/teams")
    public List<TeamDto> getTeamsInProject(@PathVariable long projectId) {
        return employeeToTeamToProjectService.getTeamsInProject(projectId);
    }

    @GetMapping(value = "/teams/{teamId:\\d+}/projects")
    public List<ProjectDto> getTeamProjects(@PathVariable long teamId) {
        return employeeToTeamToProjectService.getTeamProjects(teamId);
    }

    @PostMapping(value = "/employees/{employeeId:\\d+}/teams/{teamId:\\d+}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addEmployeeToTeam(@PathVariable long employeeId, @PathVariable long teamId) {
        employeeToTeamToProjectService.addEmployeeToTeam(employeeId, teamId);
    }

    @DeleteMapping(value = "/employees/{employeeId:\\d+}/teams/{teamId:\\d+}")
    public void deleteEmployeeFromTeam(@PathVariable long employeeId, @PathVariable long teamId) {
        employeeToTeamToProjectService.deleteEmployeeFromTeam(employeeId, teamId);
    }

    @PostMapping(value = "/teams/{teamId:\\d+}/projects/{projectId:\\d+}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeamToProject(@PathVariable long teamId, @PathVariable long projectId) {
        employeeToTeamToProjectService.addTeamToProject(teamId, projectId);
    }

    @DeleteMapping(value = "/teams/{teamId:\\d+}/projects/{projectId:\\d+}")
    public void deleteTeamFromProject(@PathVariable long teamId, @PathVariable long projectId) {
        employeeToTeamToProjectService.deleteTeamFromProject(teamId, projectId);
    }
}