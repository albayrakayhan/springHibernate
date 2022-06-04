package com.maybacth.springHibernate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.maybacth.springHibernate.model.Employee;
import com.maybacth.springHibernate.service.EmployeeService;

@RestController
@RequestMapping("/v1/api")
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping("/save")
	public String saveEmployee(@RequestBody Employee employee) {
		
		service.addEmployee(employee);
		return "Employee creted successfuly";
		
	} 
	
//	@GetMapping(value="/emp/{employee-id}")
//	public String getEmployee(@PathVariable("employee-id") Integer employeeId) {
//		service.get
//		return "Employee creted successfuly";
//	} 
	
	//@GetMapping(value="/product/{product-id}")
//	public Product getProduct(@PathVariable("product-id")String productId) {
//		return productService.getProduct(productId);
//	}
	
}
