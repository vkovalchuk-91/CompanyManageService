package org.company.kovalchuk.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.Team;

import java.util.ArrayList;
import java.util.List;

public class ProjectWithTeamsDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("teams")
    private List<TeamDto> teams;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<TeamDto> getTeams() {
        return teams;
    }

    public void setTeams(List<TeamDto> teams) {
        this.teams = teams;
    }

    public static ProjectWithTeamsDto fromModel(Project project) {
        ProjectWithTeamsDto dto = new ProjectWithTeamsDto();
        dto.setName(project.getName());
        List<TeamDto> employeeDtos = new ArrayList<>();

        for (Team team : project.getTeams()) {
            employeeDtos.add(TeamDto.fromModel(team));
        }

        dto.setTeams(employeeDtos);

        return dto;
    }

    public static List<TeamDto> getTeamDtoListFromModel(Project project) {
        List<TeamDto> teamDtoList = new ArrayList<>();

        for (Team team : project.getTeams()) {
            teamDtoList.add(TeamDto.fromModel(team));
        }

        return teamDtoList;
    }
}
