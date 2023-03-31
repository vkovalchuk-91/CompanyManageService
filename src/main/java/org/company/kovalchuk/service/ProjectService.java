package org.company.kovalchuk.service;

import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.dto.ProjectWithEmployeesDto;

public interface ProjectService {
    ProjectWithEmployeesDto getProject(long id);

    void createProject(String name);

    void updateProject(long id, String name);

    void deleteProject(long id);
}
