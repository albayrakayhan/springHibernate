package com.maybacth.springHibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybacth.springHibernate.dao.EmployeeDAO;
import com.maybacth.springHibernate.model.Employee;


@Service
public class EmployeeService {
	
	@Autowired
	EmployeeDAO dao;
	
	
	public void addEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}
	


}
