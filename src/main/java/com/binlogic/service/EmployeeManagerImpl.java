package com.binlogic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.binlogic.dao.EmployeeDAO;
import com.binlogic.entity.EmployeeEntity;

@Service
public class EmployeeManagerImpl implements EmployeeManager {
	
	@Autowired
    private EmployeeDAO employeeDAO;

	@Override
	@Transactional
	public void addEmployee(EmployeeEntity employee) {
		employeeDAO.addEmployee(employee);
	}

	@Override
	@Transactional
	public List<EmployeeEntity> getAllEmployees() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public List<EmployeeEntity> getAllEmployeesFromRead() {
		return employeeDAO.getAllEmployeesFromReadSession();
	}

	//no annotation here
	@Override
	public List<EmployeeEntity> getAllEmployeesNoTransact() {
		return employeeDAO.getAllEmployeesNoTransact();
	}

	@Transactional(readOnly = true, propagation = Propagation.NEVER)
	@Override
	public List<EmployeeEntity> getAllEmployeesNoPropagation() {
		return employeeDAO.getAllEmployees();
	}

	@Override
	@Transactional
	public void deleteEmployee(Integer employeeId) {
		employeeDAO.deleteEmployee(employeeId);
	}

	public void setEmployeeDAO(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
}
