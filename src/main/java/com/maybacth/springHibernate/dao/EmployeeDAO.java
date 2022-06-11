package com.maybacth.springHibernate.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.maybacth.springHibernate.EmployeeDTO.EmployeeDTO;
import com.maybacth.springHibernate.model.UpdateEmployeeRequest;

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
	
	  public EmployeeDTO findByEmail(String emailId) {
	        return (EmployeeDTO) getSession().createQuery("From EmployeeDTO where email = '" + emailId + "'")
	                .getResultList().get(0);
	    }

	    public EmployeeDTO findById(long id) {
	        return (EmployeeDTO) getSession().createQuery("From EmployeeDTO where id = " + id + "")
	                .getResultList().get(0);
	    }

	    public void deleteByEmail(String emailId) {
	        EmployeeDTO employeeDTO = findByEmail(emailId);
	        getSession().delete(employeeDTO);
	    }

	    public void saveEmployee(EmployeeDTO employeeDTO) {
	        getSession().save(employeeDTO);
	    }
	    
	    
	    public void updateEmployee(EmployeeDTO employeeDTO) {
	        getSession().saveOrUpdate(employeeDTO);
	    }

	    public List<EmployeeDTO> employeeList() {
	        return getSession().createQuery("from EmployeeDTO").getResultList();
	    }
	
	
	
	

}
