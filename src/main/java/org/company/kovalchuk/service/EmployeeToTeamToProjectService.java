package org.company.kovalchuk.service;

import org.company.kovalchuk.model.dto.EmployeeDto;
import org.company.kovalchuk.model.dto.ProjectDto;
import org.company.kovalchuk.model.dto.TeamDto;

import java.util.List;

public interface EmployeeToTeamToProjectService {
    List<EmployeeDto> getEmployeesInTeam(long teamId);
    List<TeamDto> getEmployeeTeams(long employeeId);
    List<TeamDto> getTeamsInProject(long projectId);
    List<ProjectDto> getTeamProjects(long teamId);
    void addEmployeeToTeam(long employeeId, long teamId);
    void deleteEmployeeFromTeam(long employeeId, long teamId);
    void addTeamToProject(long teamId, long projectId);
    void deleteTeamFromProject(long teamId, long projectId);
}
