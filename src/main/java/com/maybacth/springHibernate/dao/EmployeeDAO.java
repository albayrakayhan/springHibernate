package com.maybacth.springHibernate.dao;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maybacth.springHibernate.model.Employee;

@Repository
@Transactional
public class EmployeeDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		if(session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	public void saveEmployee(Employee employee) {
		getSession().save(employee);
		
	}
	
	public Employee getEmployee(String employeeId) {
		Employee emp=	(Employee) getSession().get(employeeId, sessionFactory);
		return emp;
	}

}
