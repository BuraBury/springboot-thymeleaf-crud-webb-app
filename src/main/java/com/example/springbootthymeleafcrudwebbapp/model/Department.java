package com.example.springbootthymeleafcrudwebbapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotBlank(message = "Department name is mandatory.")
    @Size(min = 2, max = 35, message = "Department name must be 2-35 characters long.")
    private String name;

    public long getId() {
        return id;
    }

    @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ed_fk", referencedColumnName = "id")
    private List<Employee> employees;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
