package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.TeamWithEmployeesDtoAndProjectDto;
import org.company.kovalchuk.model.request.TeamRequest;
import org.company.kovalchuk.service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<TeamWithEmployeesDtoAndProjectDto>> handleGetAllTeams() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(teamService.getAllTeams());
    }

    @GetMapping(value = "/{teamId:\\d+}")
    public ResponseEntity<TeamWithEmployeesDtoAndProjectDto> handleGetTeam(@PathVariable long teamId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(teamService.getTeam(teamId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void handleCreateTeam(@Valid @RequestBody TeamRequest request) {
        teamService.createTeam(request.name);
    }

    @PutMapping(value = "/{teamId:\\d+}")
    @ResponseStatus(HttpStatus.OK)
    public void handleUpdateTeam(
            @Valid @RequestBody TeamRequest request,
            @PathVariable long teamId
    ) {
        teamService.updateTeam(teamId, request.name);
    }

    @DeleteMapping(value = "/{teamId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleteTeam(@PathVariable long teamId) {
        teamService.deleteTeam(teamId);
    }
}