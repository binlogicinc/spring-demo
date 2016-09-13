package com.binlogic.service;

import java.util.List;

import com.binlogic.entity.EmployeeEntity;

public interface EmployeeManager {
	public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public void deleteEmployee(Integer employeeId);
}
