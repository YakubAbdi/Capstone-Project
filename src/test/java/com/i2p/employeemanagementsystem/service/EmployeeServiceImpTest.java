package com.i2p.employeemanagementsystem.service;

import com.i2p.employeemanagementsystem.models.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImpTest {
	

    @Autowired
    private EmployeeServiceImp employeeServiceImp;

    @Test
    void getAll() {
        List<Employee> employees = employeeServiceImp.getAll();
        assertEquals(0, employees.size(), "Expected size is 0");
    }

    @Test
    void getById() {
        Employee employees = employeeServiceImp.getById(1);
        assertEquals(null, employees, "Expected employee is null");
    }
    
    
}