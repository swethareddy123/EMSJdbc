package com.cg.ems.service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.regex.Pattern;

import com.cg.ems.dao.EmpDaoImpl;
import com.cg.ems.dao.EmployeeDao;
import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;

public class EmployeeServiceImpl implements EmployeeService
{
	EmployeeDao empDao=null;
	public EmployeeServiceImpl()
	{
		empDao=new EmpDaoImpl();
	}
	@Override
	public int addEmployee(Employee ee) throws EmployeeException 
	{
		
		return empDao.addEmployee(ee);
	}

	@Override
	public HashSet<Employee> fetchAllEmp()
	{
		
		return empDao.fetchAllEmp();
	}

	@Override
	public Employee getEmpById(int empId) 
	{
				return empDao.getEmpById(empId);
	}

	@Override
	public HashSet<Employee> searchEmpByName(String name) 
	{		
		return empDao.searchEmpByName(name);
	}

	@Override
	public int deleteEmp(int empId)
	{		
		return empDao.deleteEmp(empId);
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal)
	{		
		return empDao.updateEmp(empId, newName, newSal);
	}

	@Override
	public boolean validateDigit(int num) throws EmployeeException 
	{
		Integer input=new Integer(num);
		String inputStr=input.toString();
		String digitPatter="[0-9]+";
		if (Pattern.matches(digitPatter, inputStr))
		{
			return true;
		}
		else
		{
			throw new EmployeeException("Invalid input Only digits are allowed ex. 4567");
		}
		
	}

	@Override
	public boolean validateName(String name) throws EmployeeException
	{
		String namePatter="[A-Z][a-z]+";
		if (Pattern.matches(namePatter, name))
		{
			return true;
		}
		else
		{
			throw new EmployeeException("Invalid input Only characters are allowed and should start with Captial ex. Tom");
		}
		
	}
	@Override
	public LocalDate convertFromStrToLocalDate(String dtStr)
	{
		DateTimeFormatter myFormat=DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate date=LocalDate.parse(dtStr, myFormat);
		return date;
	}
	

}
