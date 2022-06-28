package com.i2p.employeemanagementsystem.service;

import com.i2p.employeemanagementsystem.models.Employee;
import com.i2p.employeemanagementsystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImp  {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAll(){
        return employeeRepository.getAllEmployees();
    }
    public void addEmployee(Employee product){employeeRepository.save(product); }
    
    public void deleteById(int id){employeeRepository.deleteById(id); }
    
    public Employee getById(int id){return employeeRepository.getEmployeeById(id); }
    

}
