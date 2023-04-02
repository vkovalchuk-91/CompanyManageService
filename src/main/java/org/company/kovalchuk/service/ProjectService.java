package org.company.kovalchuk.service;

import org.company.kovalchuk.model.dto.ProjectWithTeamsDto;

import java.util.List;

public interface ProjectService {
    List<ProjectWithTeamsDto> getAllProjects();

    ProjectWithTeamsDto getProject(long id);

    void createProject(String name);

    void updateProject(long id, String name);

    void deleteProject(long id);
}
