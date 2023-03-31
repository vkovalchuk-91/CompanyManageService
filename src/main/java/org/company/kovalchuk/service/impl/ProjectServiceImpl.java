package org.company.kovalchuk.service.impl;

import org.company.kovalchuk.exception.ProjectNotFoundException;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;
import org.company.kovalchuk.model.dto.EmployeeWithProjectsDto;
import org.company.kovalchuk.model.dto.ProjectWithEmployeesDto;
import org.company.kovalchuk.repository.ProjectRepository;
import org.company.kovalchuk.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<ProjectWithEmployeesDto> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        return projectList.stream()
                .map(ProjectWithEmployeesDto::fromModel)
                .collect(Collectors.toList());
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
