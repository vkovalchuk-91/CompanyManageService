package org.company.kovalchuk.service;

import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.dto.ProjectWithEmployeesDto;

import java.util.List;

public interface ProjectService {
    List<ProjectWithEmployeesDto> getAllProjects();

    ProjectWithEmployeesDto getProject(long id);

    void createProject(String name);

    void updateProject(long id, String name);

    void deleteProject(long id);
}
