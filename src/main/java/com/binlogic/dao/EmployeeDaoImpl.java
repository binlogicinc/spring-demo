package com.binlogic.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.SessionFactoryUtils;
import org.springframework.stereotype.Repository;

import com.binlogic.entity.EmployeeEntity;

@Repository
public class EmployeeDaoImpl implements EmployeeDAO  {

	@Autowired
    private SessionFactory sessionFactory;

	@Autowired
	private SessionFactory sessionFactoryRead;

	@Override
	public void addEmployee(EmployeeEntity employee) {
		this.sessionFactory.getCurrentSession().save(employee);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getAllEmployees() {
		return this.sessionFactory.getCurrentSession().createQuery("from EmployeeEntity").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getAllEmployeesFromReadSession() {
		return this.sessionFactoryRead.getCurrentSession().createQuery("from EmployeeEntity").list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<EmployeeEntity> getAllEmployeesNoTransact() {
		Session session = this.sessionFactory.openSession();

		try {
			return session.createQuery("from EmployeeEntity").list();
		}
		finally {
			SessionFactoryUtils.closeSession(session);
		}
	}

	@Override
	public void deleteEmployee(Integer employeeId) {
		EmployeeEntity employee = (EmployeeEntity) sessionFactory.getCurrentSession().load(
				EmployeeEntity.class, employeeId);
        if (null != employee) {
        	this.sessionFactory.getCurrentSession().delete(employee);
        }
	}
	
	

}
