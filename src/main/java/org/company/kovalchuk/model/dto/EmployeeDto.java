package org.company.kovalchuk.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.company.kovalchuk.model.Employee;

public class EmployeeDto {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String lastName;
    @JsonProperty("employeeType")
    private String employeeType;
    @JsonProperty("employeeLevel")
    private String employeeLevel;
    @JsonProperty("programmerType")
    private String programmerType;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(String employeeType) {
        this.employeeType = employeeType;
    }

    public String getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(String employeeLevel) {
        this.employeeLevel = employeeLevel;
    }

    public String getProgrammerType() {
        return programmerType;
    }

    public void setProgrammerType(String programmerType) {
        this.programmerType = programmerType;
    }

    public static EmployeeDto fromModel(Employee employee) {
        EmployeeDto dto = new EmployeeDto();
        dto.setFirstName(employee.getFirstName());
        dto.setLastName(employee.getLastName());
        dto.setEmployeeType(employee.getEmployeeType().getName());
        dto.setEmployeeLevel(employee.getEmployeeLevel().getName());
        dto.setProgrammerType(employee.getProgrammerType() == null ? "" : employee.getProgrammerType().getName());
        return dto;
    }
}