package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.TeamWithEmployeesDtoAndProjectDto;
import org.company.kovalchuk.model.request.TeamRequest;
import org.company.kovalchuk.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/teams")
public class TeamController {
    private final TeamService teamService;

    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping
    public List<TeamWithEmployeesDtoAndProjectDto> getTeam() {
        return teamService.getAllTeams();
    }

    @GetMapping(value = "/{teamId:\\d+}")
    public TeamWithEmployeesDtoAndProjectDto getTeam(@PathVariable long teamId) {
        return teamService.getTeam(teamId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createTeam(@Valid @RequestBody TeamRequest request) {
        teamService.createTeam(request.name);
    }

    @PutMapping(value = "/{teamId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTeam(
            @Valid @RequestBody TeamRequest request,
            @PathVariable long teamId
    ) {
        teamService.updateTeam(teamId, request.name);
    }

    @DeleteMapping(value = "/{teamId:\\d+}")
    public void deleteTeam(@PathVariable long teamId) {
        teamService.deleteTeam(teamId);
    }
}