package com.cg.ems.dao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

import com.cg.ems.dto.Employee;
import com.cg.ems.exception.EmployeeException;
import com.cg.ems.service.EmployeeService;
import com.cg.ems.util.DBUtil;


public class EmpDaoImpl implements EmployeeDao 
{
	Connection con=null;
	Statement st=null;
	PreparedStatement pst=null;
	ResultSet rs=null;	
	Scanner sc=new Scanner(System.in);
	@Override
	public int addEmployee(Employee ee) throws EmployeeException
	{
		try {
			con=DBUtil.getCon();
			pst=con.prepareStatement(QueryMapper.INSERTQRY3);
			pst.setInt(1, ee.getempId());
			pst.setString(2, ee.getEmpName());
			pst.setFloat(3, ee.getEmpsal());
			
			int data=pst.executeUpdate();
			if(data==1)
			{
				return ee.getempId();
			}
			else
			{
				return 0;
			}
		} 
		catch (Exception e) 
		{			
			e.printStackTrace();
			throw new EmployeeException(e.getMessage());
		}
		finally
		{
			
		}
	
	}
	@Override
	public HashSet<Employee> fetchAllEmp() 
	{ 
		HashSet<Employee> empSet=new HashSet<Employee>();
		try {
			con=DBUtil.getCon();
			st=con.createStatement();
			rs=st.executeQuery(QueryMapper.SELECTQRY1);
			while(rs.next())
			{
				int eid=rs.getInt("emp_id");
				String enm=rs.getString("emp_name");
				float sl=rs.getFloat("emp_sal");
				
				empSet.add(new Employee(eid,enm,sl,null));				
			}
		} 
		catch (Exception e)
		{			
			e.printStackTrace();
		}
		return empSet;
		
	}

	@Override
	public Employee getEmpById(int empId)
	{
		return null;		
	}

	@Override
	public HashSet<Employee> searchEmpByName(String name) 
	{
		return null;
	}

	@Override
	public int deleteEmp(int empId)
	{
		int flag=0;
		try {
			con=DBUtil.getCon();
			st=con.createStatement();
			rs=st.executeQuery(QueryMapper.SELECTQRY1);
			while(rs.next())
			{
				if(rs.getInt("emp_id")==empId)
				{
					pst=con.prepareStatement(QueryMapper.DELETEQRY1);
					pst.setInt(1, empId);
					int data=pst.executeUpdate();
					flag=empId;
				}
				else
				{
					flag=0;
				}
			}
		} 
		catch (Exception e)
		{			
			e.printStackTrace();
		}
		return empId;
	}

	@Override
	public Employee updateEmp(int empId, String newName, float newSal)
	{	
		try
		{
		con=DBUtil.getCon();
		pst=con.prepareStatement(QueryMapper.UPDATEQRY1);
		pst.setInt(3, empId);
		pst.setString(1, newName);
		pst.setFloat(2, newSal);
		int data=pst.executeUpdate();
		if(data==1)
		{
		System.out.println("Data is Updated");
		}
		else
		{
			System.out.println("record not found");
		}
		} 
		catch (Exception e) 
		{				
			e.printStackTrace();
		}
		return null ;	
	}
}

