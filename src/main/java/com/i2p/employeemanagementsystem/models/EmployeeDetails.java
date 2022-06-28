package com.i2p.employeemanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "employee_details")
public class EmployeeDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    //This is a many to one relationship
    
    private String employeeDetail;

     @ManyToOne(cascade = CascadeType.ALL)
     @JsonIgnore
     @JoinColumn(name = "fk_employee")
     private Employee employee;
   
     //Setters and getters are placed below

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmployeeDetail() {
        return employeeDetail;
    }

    public void setEmployeeDetail(String employeeDetail) {
        this.employeeDetail = employeeDetail;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
