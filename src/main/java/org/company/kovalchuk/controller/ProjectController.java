package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.ProjectWithTeamsDto;
import org.company.kovalchuk.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.company.kovalchuk.model.request.ProjectRequest;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<ProjectWithTeamsDto>> handleGetAllProjects() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(projectService.getAllProjects());
    }

    @GetMapping(value = "/{projectId:\\d+}")
    public ResponseEntity<ProjectWithTeamsDto> handleGetProject(@PathVariable long projectId) {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(projectService.getProject(projectId));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void handleCreateProject(@Valid @RequestBody ProjectRequest request) {
        projectService.createProject(request.name);
    }

    @PutMapping(value = "/{projectId:\\d+}")
    @ResponseStatus(HttpStatus.OK)
    public void handleUpdateProject(
            @Valid @RequestBody ProjectRequest request,
            @PathVariable long projectId
    ) {
        projectService.updateProject(projectId, request.name);
    }

    @DeleteMapping(value = "/{projectId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDeleteProject(@PathVariable long projectId) {
        projectService.deleteProject(projectId);
    }
}