package org.company.kovalchuk.service.impl;

import org.company.kovalchuk.exception.TeamNotFoundException;
import org.company.kovalchuk.model.Team;
import org.company.kovalchuk.model.dto.TeamWithEmployeesDtoAndProjectDto;
import org.company.kovalchuk.repository.TeamRepository;
import org.company.kovalchuk.service.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamRepository;

    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }
    @Override
    public List<TeamWithEmployeesDtoAndProjectDto> getAllTeams() {
        List<Team> teamList = teamRepository.findAll();
        return teamList.stream()
                .map(TeamWithEmployeesDtoAndProjectDto::fromModel)
                .collect(Collectors.toList());
    }

    @Override
    public TeamWithEmployeesDtoAndProjectDto getTeam(long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
        return TeamWithEmployeesDtoAndProjectDto.fromModel(team);
    }

    @Override
    public void createTeam(String name) {
        Team team = new Team();
        team.setName(name);
        teamRepository.save(team);
    }

    @Override
    public void updateTeam(long id, String name) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
        team.setName(name);
        teamRepository.save(team);
    }

    @Override
    public void deleteTeam(long id) {
        Team team = teamRepository.findById(id)
                .orElseThrow(() -> new TeamNotFoundException(id));
        teamRepository.delete(team);
    }
}
