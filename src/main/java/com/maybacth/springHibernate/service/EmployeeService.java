package com.maybacth.springHibernate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maybacth.springHibernate.EmployeeDTO.EmployeeDTO;
import com.maybacth.springHibernate.dao.EmployeeDAO;
import com.maybacth.springHibernate.model.AddEmployeeRequest;
import com.maybacth.springHibernate.model.Employee;
import com.maybacth.springHibernate.model.UpdateEmployeeRequest;



@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDAO dao;
	

    public Employee addEmployee(AddEmployeeRequest addEmployeeRequest) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(addEmployeeRequest.getName());
        employeeDTO.setDesignation(addEmployeeRequest.getDesignation());
        employeeDTO.setEmail(addEmployeeRequest.getEmail());

        dao.saveEmployee(employeeDTO);
        return new Employee(employeeDTO.getId()
                , employeeDTO.getName(), employeeDTO.getEmail(), employeeDTO.getDesignation());
    }


    public Employee updateEmployee(UpdateEmployeeRequest updateEmployeeRequest) {
        EmployeeDTO employeeDTO = dao.findById(updateEmployeeRequest.getId());

        employeeDTO.setDesignation(updateEmployeeRequest.getDesignation());
        employeeDTO.setName(updateEmployeeRequest.getName());
        employeeDTO.setEmail(updateEmployeeRequest.getEmail());

        dao.updateEmployee(employeeDTO);
        return new Employee(employeeDTO.getId()
                , employeeDTO.getName(), employeeDTO.getEmail(), employeeDTO.getDesignation());
    }

    public Employee findByEmail(String emailId) {
        EmployeeDTO employeeDTO = dao.findByEmail(emailId);
        return new Employee(employeeDTO.getId()
                , employeeDTO.getName(), employeeDTO.getEmail(), employeeDTO.getDesignation());
    }

    public void deleteByEmail(String emailId) {
        dao.deleteByEmail(emailId);
    }

    public List<Employee> employeeList() {
    	
        List<EmployeeDTO> employeeDTOS = dao.employeeList();

        List<Employee> employees = new ArrayList<>();

        for (EmployeeDTO employeeDTO : employeeDTOS) {
            employees.add(new Employee(employeeDTO.getId()
                    , employeeDTO.getName(), employeeDTO.getEmail(), employeeDTO.getDesignation()));
        }

        return employees;
    }
}

