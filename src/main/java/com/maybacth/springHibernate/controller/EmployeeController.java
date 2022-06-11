package com.maybacth.springHibernate.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.maybacth.springHibernate.model.AddEmployeeRequest;
import com.maybacth.springHibernate.model.Employee;
import com.maybacth.springHibernate.model.UpdateEmployeeRequest;
import com.maybacth.springHibernate.service.EmployeeService;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

	@Autowired
	  private EmployeeService service;

    @PostMapping("/save")
    public Employee saveEmployee(@RequestBody AddEmployeeRequest addEmployeeRequest) {
        return service.addEmployee(addEmployeeRequest);
    }

	
    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody UpdateEmployeeRequest updateEmployeeRequest) {
        return service.updateEmployee(updateEmployeeRequest);
    }

    @GetMapping(value = "/fetchEmployeeByEmail")
    public Employee fetchEmployeeByEmail(@RequestParam("email_id") String emailId) {
        return service.findByEmail(emailId);
    }

    @DeleteMapping(value = "/deleteEmployeeByEmail")
    public String deleteEmployeeByEmail(@RequestParam("email_id") String emailId) {
        service.deleteByEmail(emailId);
        return "Employee with email id " + emailId + " deleted successfully.";
    }

    @GetMapping(value = "/fetchEmployeeList")
    public List<Employee> fetchEmployeeList() {
        return service.employeeList();
    }
	 
}
