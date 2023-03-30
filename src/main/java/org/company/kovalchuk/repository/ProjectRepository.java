package org.company.kovalchuk.repository;

import org.company.kovalchuk.model.Project;

import java.util.Optional;

public interface ProjectRepository {
    Optional<Project> getProjectById(int id);

    void insertProject(String name);

    void updateProject(int id, String name);

    void deleteProjectById(int id);
}
