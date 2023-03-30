package org.company.kovalchuk.service;

import org.company.kovalchuk.exception.ProjectNotFoundException;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project getProject(int id) {
        return projectRepository.getProjectById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
    }

    @Override
    public void createProject(String name) {
        projectRepository.insertProject(name);
    }

    @Override
    public void updateProject(int id, String name) {
        projectRepository.getProjectById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        projectRepository.updateProject(id, name);
    }

    @Override
    public void deleteProject(int id) {
        projectRepository.getProjectById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        projectRepository.deleteProjectById(id);
    }
}
