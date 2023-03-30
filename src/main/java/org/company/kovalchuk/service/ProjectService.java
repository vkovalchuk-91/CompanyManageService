package org.company.kovalchuk.service;

import org.company.kovalchuk.model.Project;

public interface ProjectService {
    Project getProject(int id);

    void createProject(String name);

    void updateProject(int id, String name);

    void deleteProject(int id);
}
