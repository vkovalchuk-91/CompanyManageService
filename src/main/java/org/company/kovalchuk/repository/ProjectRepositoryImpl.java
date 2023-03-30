package org.company.kovalchuk.repository;

import org.springframework.stereotype.Repository;
import org.company.kovalchuk.model.Project;

import java.util.Optional;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {
    @Override
    public Optional<Project> getProjectById(int id) {
        return Optional.empty();
    }

    @Override
    public void insertProject(String name) {

    }

    @Override
    public void updateProject(int id, String name) {

    }

    @Override
    public void deleteProjectById(int id) {

    }
}
