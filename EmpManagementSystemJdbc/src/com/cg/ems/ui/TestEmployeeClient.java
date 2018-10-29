package com.cg.ems.ui;
import java.util.HashSet;

import java.util.Iterator;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.service.EmployeeServiceImpl;
public class TestEmployeeClient
{
	static Scanner sc=null;
	static EmployeeService empSer=null;
	public static void main(String[] args) throws EmployeeException 
	{
		sc=new Scanner(System.in);
		empSer=new EmployeeServiceImpl();
		int choice=0;
		while(true)
		{
			System.out.println("What do you want to do?");
			System.out.println("1:Add Emp\t2:Fetch All Emp\n");
			System.out.println("3:Delete Emp\t4:Search Emp By Id\n");
			System.out.println("5:Search Emp By Name\t6:Update Emp\n");
			System.out.println("7:EXIT\n");
			System.out.println("Enter UR Choice");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:addEmp();break;
			case 2:showEmpInfo();break;
			case 3: deleteEmp();break;
			case 4:getEmpById();break;
			case 5:searchEmpByname();break;
			case 6:updateEmp();break;
			default:System.exit(0);
			}
		}

	}
	
	private static void updateEmp()
	{
		System.out.println("Enter empid to be updated");
		int empId=sc.nextInt();
		System.out.println("Enter new Emp name:");
		String newName=sc.next();
		System.out.println("Enter new Salary:");
		float newSal=sc.nextFloat();
		empSer.updateEmp(empId, newName, newSal);
		
	}

	private static void searchEmpByname()
	{
		System.out.println("Enter Employee name");
		String name=sc.next();
		empSer.searchEmpByName(name);	
		
	}

	private static void deleteEmp() 
	{
		System.out.println("Enter the Employee Id");
		int rem=sc.nextInt();
				empSer.deleteEmp(rem);
		
	}

	private static void getEmpById() 
	{
		System.out.println("Enter the Employee Id");
		int reqId=sc.nextInt();
				Employee e=empSer.getEmpById(reqId);
				System.out.println(e);
		
	}

	private static void showEmpInfo()
	{
			HashSet<Employee> empSet=empSer.fetchAllEmp();	
			Iterator<Employee> it=empSet.iterator();
			System.out.println("---------------------------");
			System.out.println("EMPId\t\t EMPName\t\tEMPSalary\t\tEMPDOJ");
			while(it.hasNext())
			{
				Employee ee= it.next();
				System.out.println(ee.getempId()+"\t\t"+ ee.getEmpName()+"\t\t"+ee.getEmpsal()+"\t\t"+ee.getEmpDOJ());
			}	
			System.out.println("------------------------");
	}
	private static void addEmp() 
	{		
		System.out.println("Enter Emp Id:");
		int eid=sc.nextInt();
		try
		{
			if(empSer.validateDigit(eid))
			{
				System.out.println("Enter Emp name:");
				String nm=sc.next();
				if(empSer.validateName(nm))
				{
					System.out.println("Enter Salary:");
					float sal=sc.nextFloat();
					System.out.println("Enter DOJ(dd-MM-yyyy)");
					String empDOJStr=sc.next();
					
					Employee ee=new Employee(eid,nm,sal, empSer.convertFromStrToLocalDate(empDOJStr));
					int empId=empSer.addEmployee(ee);
					System.out.println(empId + "Added Successfully");
				}
			}
		}
		catch(EmployeeException e)
		{
			e.printStackTrace();
		}
	}

}
