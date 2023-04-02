package org.company.kovalchuk.controller;

import org.company.kovalchuk.model.dto.ProjectWithTeamsDto;
import org.company.kovalchuk.service.ProjectService;
import org.springframework.http.HttpStatus;
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
    public List<ProjectWithTeamsDto> getProject() {
        return projectService.getAllProjects();
    }

    @GetMapping(value = "/{projectId:\\d+}")
    public ProjectWithTeamsDto getProject(@PathVariable long projectId) {
        return projectService.getProject(projectId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProject(@Valid @RequestBody ProjectRequest request) {
        projectService.createProject(request.name);
    }

    @PutMapping(value = "/{projectId:\\d+}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateProject(
            @Valid @RequestBody ProjectRequest request,
            @PathVariable long projectId
    ) {
        projectService.updateProject(projectId, request.name);
    }

    @DeleteMapping(value = "/{projectId:\\d+}")
    public void deleteProject(@PathVariable long projectId) {
        projectService.deleteProject(projectId);
    }
}