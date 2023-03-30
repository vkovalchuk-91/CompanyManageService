package org.company.kovalchuk.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue
    private long id;
    private String firstName;
    private String lastName;
    @OneToOne
    @JoinColumn(name = "employee_type_id")
    private EmployeeType employeeType;
    @OneToOne
    @JoinColumn(name = "employee_level_id")
    private EmployeeLevel employeeLevel;
    @OneToOne
    @JoinColumn(name = "programmer_type_id")
    private ProgrammerType programmerType;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "employee_project",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "project_id")})
    private Set<Project> projects;

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public EmployeeLevel getEmployeeLevel() {
        return employeeLevel;
    }

    public void setEmployeeLevel(EmployeeLevel programmerLevel) {
        this.employeeLevel = programmerLevel;
    }

    public ProgrammerType getProgrammerType() {
        return programmerType;
    }

    public void setProgrammerType(ProgrammerType programmerType) {
        this.programmerType = programmerType;
    }
}
