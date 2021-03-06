package com.binlogic.dao;

import java.util.List;

import com.binlogic.entity.EmployeeEntity;

public interface EmployeeDAO 
{
    public void addEmployee(EmployeeEntity employee);
    public List<EmployeeEntity> getAllEmployees();
    public List<EmployeeEntity> getAllEmployeesFromReadSession();
    public List<EmployeeEntity> getAllEmployeesNoTransact();
    public void deleteEmployee(Integer employeeId);
}