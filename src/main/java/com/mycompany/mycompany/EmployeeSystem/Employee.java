package com.mycompany.mycompany.EmployeeSystem;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table
public class Employee {

    @Id
    @SequenceGenerator(
            name = ("employee_sequence"),
            sequenceName = "employee_sequence" ,
            allocationSize = 1
    )

    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "employee_sequence"
    )


    private Long employeeId ;

    private String name ;

    private String email ;

    private LocalDate startDate ;

    private Integer yearsOfEmployment ;

    public Employee(Long employeeId, String name, String email, LocalDate startDate) {

        this.employeeId = employeeId;
        this.name = name;
        this.email = email;
        this.startDate = startDate;
    }

    public Employee(String name, String email, LocalDate startDate) {
        this.name = name;
        this.email = email;
        this.startDate = startDate ;
    }

    public Employee() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    @Transient
    public Integer getYearsOfEmployment() {
        return Period.between(startDate, LocalDate.now()).getYears();
    }

    public Employee(String name, String email, LocalDate startDate, Integer yearsOfEmployment) {
        this.name = name;
        this.email = email;
        this.startDate = startDate;
        this.yearsOfEmployment = yearsOfEmployment;
    }

    public void setYearsOfEmployment(Integer yearsOfEmployment) {
        this.yearsOfEmployment = yearsOfEmployment;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", startDate=" + startDate +
                ", yearsOfEmployment=" + yearsOfEmployment +
                '}';
    }
}
