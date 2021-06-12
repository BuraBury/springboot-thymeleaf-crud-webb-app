package com.example.springbootthymeleafcrudwebbapp.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "first_name")
    @Size(min = 2, max = 35, message = "Name must be 2-35 characters long.")
    private String firstName;

    @Column(name = "last_name")
    @Size(min = 2, max = 35, message = "Last name must be 2-35 characters long.")
    private String lastName;

    @Column(name = "email")
    @Email(message = "Enter valid email address")
    private String email;

    @Column(name = "hire_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "Hire date cannot be in the future.")
    private Date hireDate;

    @Column(name = "termination_date")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @FutureOrPresent(message = "Termination date cannot be in the past.")
    private Date terminationDate = null;

    @Column(name = "department_id")
    @NotBlank(message = "Department name is mandatory")

    private String department;

    @Column(name = "position_id")
    @NotBlank(message = "Position name is mandatory")
    private String position;

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Date getTerminationDate() {
        return terminationDate;
    }

    public void setTerminationDate(Date terminationDate) {
        this.terminationDate = terminationDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
