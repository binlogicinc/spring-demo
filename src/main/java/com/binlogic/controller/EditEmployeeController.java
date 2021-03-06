package com.binlogic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.binlogic.entity.EmployeeEntity;
import com.binlogic.service.EmployeeManager;

@Controller
public class EditEmployeeController {
	
	@Autowired
	private EmployeeManager employeeManager;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listEmployees(ModelMap map) 
	{
		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeManager.getAllEmployees());
		
		return "editEmployeeList";
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String listEmployeesRead(ModelMap map)
	{
		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeManager.getAllEmployeesFromRead());

		return "editEmployeeList";
	}

	@RequestMapping(value = "/no-transact", method = RequestMethod.GET)
	public String listEmployeesNoTransact(ModelMap map)
	{
		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeManager.getAllEmployeesNoTransact());

		return "editEmployeeList";
	}

	@RequestMapping(value = "/no-propagation", method = RequestMethod.GET)
	public String listEmployeesNoPropagation(ModelMap map)
	{
		map.addAttribute("employee", new EmployeeEntity());
		map.addAttribute("employeeList", employeeManager.getAllEmployeesNoPropagation());

		return "editEmployeeList";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@ModelAttribute(value="employee") EmployeeEntity employee, BindingResult result) 
	{
		employeeManager.addEmployee(employee);
		return "redirect:/";
	}

	@RequestMapping("/delete/{employeeId}")
	public String deleteEmplyee(@PathVariable("employeeId") Integer employeeId)
	{
		employeeManager.deleteEmployee(employeeId);
		return "redirect:/";
	}

	public void setEmployeeManager(EmployeeManager employeeManager) {
		this.employeeManager = employeeManager;
	}
}
