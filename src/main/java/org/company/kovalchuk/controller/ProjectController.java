package org.company.kovalchuk.controller;

import org.company.kovalchuk.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.request.ProjectRequest;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/projects")
public class ProjectController {
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping(value = "/{projectId:\\d+}")
    public Project getProject(@PathVariable int projectId) {
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
            @PathVariable int projectId
    ) {
        projectService.updateProject(projectId, request.name);
    }

    @DeleteMapping(value = "/{projectId:\\d+}")
    public void deleteProject(@PathVariable int projectId) {
        projectService.deleteProject(projectId);
    }
}