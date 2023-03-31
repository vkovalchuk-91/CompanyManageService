package org.company.kovalchuk.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;

import java.util.ArrayList;
import java.util.List;

public class EmployeeWithProjectsDto {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("employeeType")
    private String employeeType;
    @JsonProperty("employeeLevel")
    private String employeeLevel;
    @JsonProperty("programmerType")
    private String programmerType;
    @JsonProperty("projects")
    private List<ProjectDto> projects;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public String getProgrammerType() {
        return programmerType;
    }

    public void setProgrammerType(String programmerType) {
        this.programmerType = programmerType;
    }

    public List<ProjectDto> getProjects() {
        return projects;
    }

    public void setProjects(List<ProjectDto> projects) {
        this.projects = projects;
    }

    public static EmployeeWithProjectsDto fromModel(Employee employee) {
        EmployeeWithProjectsDto dto = new EmployeeWithProjectsDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmployeeType(employee.getEmployeeType().getName());
        dto.setEmployeeLevel(employee.getEmployeeLevel().getName());
        dto.setProgrammerType(employee.getProgrammerType() == null ? "" : employee.getProgrammerType().getName());

        List<ProjectDto> projectDtos = new ArrayList<>();
        for (Project project : employee.getProjects()) {
            projectDtos.add(ProjectDto.fromModel(project));
        }
        dto.setProjects(projectDtos);

        return dto;
    }

    public static List<ProjectDto> getProjectDtoListFromModel(Employee employee) {
        List<ProjectDto> projectDtoList = new ArrayList<>();

        for (Project project : employee.getProjects()) {
            projectDtoList.add(ProjectDto.fromModel(project));
        }

        return projectDtoList;
    }
}
