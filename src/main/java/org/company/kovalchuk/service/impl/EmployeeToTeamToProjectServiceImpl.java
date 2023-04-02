package org.company.kovalchuk.service.impl;

import org.company.kovalchuk.exception.EmployeeNotFoundException;
import org.company.kovalchuk.exception.ProjectNotFoundException;
import org.company.kovalchuk.exception.TeamNotFoundException;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.Team;
import org.company.kovalchuk.model.dto.*;
import org.company.kovalchuk.repository.ProjectRepository;
import org.company.kovalchuk.repository.TeamRepository;
import org.company.kovalchuk.service.EmployeeToTeamToProjectService;
import org.springframework.stereotype.Service;
import org.company.kovalchuk.repository.EmployeeRepository;

import java.util.List;
import java.util.Set;

@Service
public class EmployeeToTeamToProjectServiceImpl implements EmployeeToTeamToProjectService {
    private final EmployeeRepository employeeRepository;
    private final TeamRepository teamRepository;
    private final ProjectRepository projectRepository;

    public EmployeeToTeamToProjectServiceImpl(EmployeeRepository employeeRepository,
                                              TeamRepository teamRepository,
                                              ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.teamRepository = teamRepository;
        this.projectRepository = projectRepository;
    }

    @Override
    public List<EmployeeDto> getEmployeesInTeam(long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(teamId));
        return TeamWithEmployeesDtoAndProjectDto.getEmployeeDtoListFromModel(team);
    }

    @Override
    public List<TeamDto> getEmployeeTeams(long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        return EmployeeWithTeamsDto.getTeamDtoListFromModel(employee);
    }

    @Override
    public List<TeamDto> getTeamsInProject(long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        return ProjectWithTeamsDto.getTeamDtoListFromModel(project);
    }

    @Override
    public List<ProjectDto> getTeamProjects(long teamId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(teamId));
        return TeamWithEmployeesDtoAndProjectDto.getProjectDtoListFromModel(team);
    }

    @Override
    public void addEmployeeToTeam(long employeeId, long teamId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(teamId));

        Set<Employee> projectEmployees = team.getEmployees();
        projectEmployees.add(employee);

        Set<Team> employeeTeams = employee.getTeams();
        employeeTeams.add(team);

        teamRepository.save(team);
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployeeFromTeam(long employeeId, long teamId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new EmployeeNotFoundException(employeeId));
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(teamId));

        Set<Employee> teamEmployees = team.getEmployees();
        teamEmployees.remove(employee);

        Set<Team> employeeTeams = employee.getTeams();
        employeeTeams.remove(team);

        teamRepository.save(team);
        employeeRepository.save(employee);
    }

    @Override
    public void addTeamToProject(long teamId, long projectId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(teamId));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        Set<Team> projectTeams = project.getTeams();
        projectTeams.add(team);

        Set<Project> teamProjects = team.getProjects();
        teamProjects.add(project);

        teamRepository.save(team);
        projectRepository.save(project);
    }

    @Override
    public void deleteTeamFromProject(long teamId, long projectId) {
        Team team = teamRepository.findById(teamId)
                .orElseThrow(() -> new TeamNotFoundException(teamId));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        Set<Team> projectTeams = project.getTeams();
        projectTeams.remove(team);

        Set<Project> teamProjects = team.getProjects();
        teamProjects.remove(project);

        teamRepository.save(team);
        projectRepository.save(project);
    }
}
