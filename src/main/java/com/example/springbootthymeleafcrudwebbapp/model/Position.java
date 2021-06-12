package com.example.springbootthymeleafcrudwebbapp.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "position")
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    @Column(name = "name")
    @NotBlank(message = "Position name is mandatory.")
    @Size(min = 2, max = 35, message = "Position name must be 2-35 characters long.")
    private String name;

    @OneToMany(targetEntity = Employee.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "ep_fk", referencedColumnName = "id")
    private List<Employee> employees;

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
