package org.company.kovalchuk.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.Team;

import java.util.ArrayList;
import java.util.List;

public class TeamWithEmployeesDtoAndProjectDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("employees")
    private List<EmployeeDto> employees;
    @JsonProperty("projects")
    private List<ProjectDto> projects;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }

    public static TeamWithEmployeesDtoAndProjectDto fromModel(Team team) {
        TeamWithEmployeesDtoAndProjectDto dto = new TeamWithEmployeesDtoAndProjectDto();
        dto.setName(team.getName());
        List<EmployeeDto> employeeDtos = new ArrayList<>();
        List<ProjectDto> projectDtos = new ArrayList<>();

        for (Employee employee : team.getEmployees()) {
            employeeDtos.add(EmployeeDto.fromModel(employee));
        }

        for (Project project : team.getProjects()) {
            projectDtos.add(ProjectDto.fromModel(project));
        }

        dto.setEmployees(employeeDtos);
        dto.setProjects(projectDtos);

        return dto;
    }

    public static List<EmployeeDto> getEmployeeDtoListFromModel(Team team) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for (Employee employee : team.getEmployees()) {
            employeeDtoList.add(EmployeeDto.fromModel(employee));
        }

        return employeeDtoList;
    }

    public static List<ProjectDto> getProjectDtoListFromModel(Team team) {
        List<ProjectDto> projectDtoList = new ArrayList<>();

        for (Project project : team.getProjects()) {
            projectDtoList.add(ProjectDto.fromModel(project));
        }

        return projectDtoList;
    }
}
