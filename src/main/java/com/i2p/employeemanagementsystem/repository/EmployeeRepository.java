package com.i2p.employeemanagementsystem.repository;

import com.i2p.employeemanagementsystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select employee from Employee employee where employee.id=?1")
	public Employee getEmployeeById(Integer id);
	
	@Query("select employee from Employee employee")
	public List<Employee> getAllEmployees();
}