package org.company.kovalchuk.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_level")
public class EmployeeLevel {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "employee_level_name")
    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}