package com.nagarro.employeemanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.employeemanagement.entity.Employee;
import com.nagarro.employeemanagement.exception.ResourceNotFoundException;
import com.nagarro.employeemanagement.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	//get all employees
	@GetMapping
	public List<Employee> getAllEmployees(){
		return this.employeeRepository.findAll();
	}
	
	//get employee by id
	@GetMapping("/{ecode}")
    public Employee getUserById(@PathVariable(value = "ecode") long userId) {
        return this.employeeRepository.findById(userId)
        .orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: "+ userId));
    }
	
	
	//create employee
	@PostMapping
	public Employee createEmployee(@RequestBody Employee employee) {
		return this.employeeRepository.save(employee);
	}
	
	
	
	//update employee
	@PutMapping("/{ecode}")
	public Employee updateEmployee(@RequestBody Employee employee, @PathVariable (value ="ecode") long id) {
		Employee existingEmployee = this.employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: "+ id));
		
		existingEmployee.setEname(employee.getEname());
		existingEmployee.setEdob(employee.getEdob());
		existingEmployee.setEmail(employee.getEmail());
		existingEmployee.setLocation(employee.getLocation());
		
		return this.employeeRepository.save(existingEmployee);
	}
	
	
	//delete employee by ecode
	@DeleteMapping("/{ecode}")
	public ResponseEntity<Employee> deleteEmployee( @PathVariable (value ="ecode") long id) {
		Employee existingEmployee = this.employeeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found with id: "+ id));
		
		this.employeeRepository.delete(existingEmployee);
		return ResponseEntity.ok().build();
	}
}