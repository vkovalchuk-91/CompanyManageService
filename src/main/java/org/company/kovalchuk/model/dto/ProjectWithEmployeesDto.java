package org.company.kovalchuk.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.company.kovalchuk.model.Employee;
import org.company.kovalchuk.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectWithEmployeesDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("employees")
    private List<EmployeeDto> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDto> getEmployees() {
        return employees;
    }

    public void setEmployees(List<EmployeeDto> employees) {
        this.employees = employees;
    }

    public static ProjectWithEmployeesDto fromModel(Project project) {
        ProjectWithEmployeesDto dto = new ProjectWithEmployeesDto();
        dto.setName(project.getName());
        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for (Employee employee : project.getEmployees()) {
            employeeDtos.add(EmployeeDto.fromModel(employee));
        }

        dto.setEmployees(employeeDtos);

        return dto;
    }

    public static List<EmployeeDto> getEmployeeDtoListFromModel(Project project) {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();

        for (Employee employee : project.getEmployees()) {
            employeeDtoList.add(EmployeeDto.fromModel(employee));
        }

        return employeeDtoList;
    }
}
