package com.cg.ems.dto;

import java.time.LocalDate;

public class Employee implements Comparable<Employee>
{
	private int empId;
	private String empName;
	private float empsal;
	private LocalDate empDOJ; 
	
	
	public int getempId() {
		return empId;
	}
	public void setempId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public float getEmpsal() {
		return empsal;
	}
	public void setEmpsal(float empsal) {
		this.empsal = empsal;
	}
	public LocalDate getEmpDOJ() {
		return empDOJ;
	}
	public void setEmpDOJ(LocalDate empDOJ) {
		this.empDOJ = empDOJ;
	}
	
	
		
	public Employee(int empId, String empName, float empsal, LocalDate empDOJ) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empsal = empsal;
		this.empDOJ = empDOJ;
	}
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName
				+ ", empsal=" + empsal + ", empDOJ=" + empDOJ + "]";
	}
	
	public Employee() {
		super();
		
	}
	@Override
	public boolean equals(Object obj)
	{
		Employee emp=(Employee)obj;
		if(emp.empId==this.empId)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@Override
	public int hashCode()
	{
		return empId;
	}
	@Override
	public int compareTo(Employee emp)
	{
		if(emp.empId<this.empId)
		{
			return -1;
		}
		else if(emp.empId==this.empId)
		{
			return 0;
		}
		else
		{
			return +1;
		}
	}
}
