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

    @GetMapping(value = "/teams/{teamId:\\d+}/projects")
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
    public void addEmployeeToTeam(@PathVariable int employeeId, @PathVariable int teamId) {
        employeeToTeamToProjectService.addEmployeeToTeam(employeeId, teamId);
    }

    @DeleteMapping(value = "/employees/{employeeId:\\d+}/teams/{teamId:\\d+}")
    public void deleteEmployeeFromTeam(@PathVariable int employeeId, @PathVariable int teamId) {
        employeeToTeamToProjectService.deleteEmployeeFromTeam(employeeId, teamId);
    }

    @PostMapping(value = "/teams/{teamId:\\d+}/projects/{projectId:\\d+}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTeamToProject(@PathVariable int teamId, @PathVariable int projectId) {
        employeeToTeamToProjectService.addTeamToProject(teamId, projectId);
    }

    @DeleteMapping(value = "/teams/{teamId:\\d+}/projects/{projectId:\\d+}")
    public void deleteTeamFromProject(@PathVariable int teamId, @PathVariable int projectId) {
        employeeToTeamToProjectService.deleteTeamFromProject(teamId, projectId);
    }
}