package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.EmployeeDto;
import org.company.kovalchuk.model.dto.ProjectDto;
import org.company.kovalchuk.model.dto.TeamDto;
import org.company.kovalchuk.service.EmployeeToTeamToProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeToTeamToProjectController {

    private final EmployeeToTeamToProjectService employeeToTeamToProjectService;

    public EmployeeToTeamToProjectController(EmployeeToTeamToProjectService employeeToProjectService) {
        this.employeeToTeamToProjectService = employeeToProjectService;
    }

    @GetMapping(value = "/teams/{teamId:\\d+}/employees")
    public ResponseEntity<List<EmployeeDto>> handleGetEmployeesInTeam(@PathVariable long teamId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeToTeamToProjectService.getEmployeesInTeam(teamId));
    }

    @GetMapping(value = "/employees/{employeeId:\\d+}/teams")
    public ResponseEntity<List<TeamDto>> handleGetEmployeeTeams(@PathVariable long employeeId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeToTeamToProjectService.getEmployeeTeams(employeeId));
    }

    @GetMapping(value = "/projects/{projectId:\\d+}/teams")
    public ResponseEntity<List<TeamDto>> handleGetTeamsInProject(@PathVariable long projectId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeToTeamToProjectService.getTeamsInProject(projectId));
    }

    @GetMapping(value = "/teams/{teamId:\\d+}/projects")
    public ResponseEntity<List<ProjectDto>> handleGetTeamProjects(@PathVariable long teamId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(employeeToTeamToProjectService.getTeamProjects(teamId));
    }

    @PostMapping(value = "/employees/{employeeId:\\d+}/teams/{teamId:\\d+}")
    @ResponseStatus(HttpStatus.CREATED)
    public void handleAddEmployeeToTeam(@PathVariable long employeeId, @PathVariable long teamId) {
        employeeToTeamToProjectService.addEmployeeToTeam(employeeId, teamId);
    }

    @DeleteMapping(value = "/employees/{employeeId:\\d+}/teams/{teamId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleteEmployeeFromTeam(@PathVariable long employeeId, @PathVariable long teamId) {
        employeeToTeamToProjectService.deleteEmployeeFromTeam(employeeId, teamId);
    }

    @PostMapping(value = "/teams/{teamId:\\d+}/projects/{projectId:\\d+}")
    @ResponseStatus(HttpStatus.CREATED)
    public void handleAddTeamToProject(@PathVariable long teamId, @PathVariable long projectId) {
        employeeToTeamToProjectService.addTeamToProject(teamId, projectId);
    }

    @DeleteMapping(value = "/teams/{teamId:\\d+}/projects/{projectId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleteTeamFromProject(@PathVariable long teamId, @PathVariable long projectId) {
        employeeToTeamToProjectService.deleteTeamFromProject(teamId, projectId);
    }
}