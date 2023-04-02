package org.company.kovalchuk.service;

import org.company.kovalchuk.model.dto.TeamWithEmployeesDtoAndProjectDto;

import java.util.List;

public interface TeamService {
    List<TeamWithEmployeesDtoAndProjectDto> getAllTeams();

    TeamWithEmployeesDtoAndProjectDto getTeam(long id);

    void createTeam(String name);

    void updateTeam(long id, String name);

    void deleteTeam(long id);
}
