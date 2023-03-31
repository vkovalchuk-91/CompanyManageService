package org.company.kovalchuk.model;

import javax.persistence.*;

@Entity
@Table(name = "programmer_type")
public class ProgrammerType {
    @Id
    @GeneratedValue
    private long id;
    @Column(name = "programmer_type_name")
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