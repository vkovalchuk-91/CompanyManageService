package org.company.kovalchuk.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;

public class ProjectDto {
    @JsonProperty("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static ProjectDto fromModel(Project project) {
        ProjectDto dto = new ProjectDto();
        dto.setName(project.getName());
        return dto;
    }
}