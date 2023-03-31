package org.company.kovalchuk.service;

import org.company.kovalchuk.exception.ProjectNotFoundException;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.dto.ProjectWithEmployeesDto;
import org.company.kovalchuk.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public ProjectWithEmployeesDto getProject(long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        return ProjectWithEmployeesDto.fromModel(project);
    }

    @Override
    public void createProject(String name) {
        Project project = new Project();
        project.setName(name);
        projectRepository.save(project);
    }

    @Override
    public void updateProject(long id, String name) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        project.setName(name);
        projectRepository.save(project);
    }

    @Override
    public void deleteProject(long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));
        projectRepository.delete(project);
    }
}
