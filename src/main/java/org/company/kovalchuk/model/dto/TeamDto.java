package org.company.kovalchuk.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.company.kovalchuk.model.Team;

public class TeamDto {
    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static TeamDto fromModel(Team team) {
        TeamDto dto = new TeamDto();
        dto.setName(team.getName());
        return dto;
    }
}