package org.company.kovalchuk.model;

import javax.persistence.*;

@Entity
@Table(name = "employee_type")
public class EmployeeType {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "employee_type_name")
    private String name;

    public EmployeeType() {
    }

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