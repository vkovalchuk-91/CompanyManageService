package org.company.kovalchuk.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Team;

import java.util.ArrayList;
import java.util.List;

public class EmployeeWithTeamsDto {
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
    @JsonProperty("teams")
    private List<TeamDto> teams;

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

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }

    public static EmployeeWithTeamsDto fromModel(Employee employee) {
        EmployeeWithTeamsDto dto = new EmployeeWithTeamsDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmployeeType(employee.getEmployeeType().getName());
        dto.setEmployeeLevel(employee.getEmployeeLevel().getName());
        dto.setProgrammerType(employee.getProgrammerType() == null ? "" : employee.getProgrammerType().getName());

        List<TeamDto> teamDtosDtos = new ArrayList<>();
        for (Team team : employee.getTeams()) {
            teamDtosDtos.add(TeamDto.fromModel(team));
        }
        dto.setTeams(teamDtosDtos);

        return dto;
    }

    public static List<TeamDto> getTeamDtoListFromModel(Employee employee) {
        List<TeamDto> teamDtos = new ArrayList<>();

        for (Team team : employee.getTeams()) {
            teamDtos.add(TeamDto.fromModel(team));
        }

        return teamDtos;
    }
}
