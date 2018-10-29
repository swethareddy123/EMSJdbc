package com.cg.ems.ui;
import java.time.LocalDate;
import java.time.Month;
import java.util.HashSet;
import java.util.TreeSet;

import com.cg.ems.dto.Employee;
public class TestHashSetDemo 
{
	public static void main(String[] args){
		
	HashSet<Employee> emps=new HashSet<Employee>();
	
	emps.add(new Employee(333,"Vaishali",1000.0F,LocalDate.of(2018, Month.JUNE, 19)));
	emps.add(new Employee(111,"Soumya",5000.0F,LocalDate.of(2018, Month.SEPTEMBER, 19)));
	emps.add(new Employee(222,"Srikar",78000.0F,LocalDate.of(2018, Month.OCTOBER, 12)));
	emps.add(new Employee(222,"Srikar",78000.0F,LocalDate.of(2018, Month.NOVEMBER, 13)));
	
	System.out.println(emps);
	
	System.out.println("*********************");
	TreeSet<String> cities=new TreeSet<String>();
	
	cities.add("Pune");
	cities.add("Noida");
	cities.add("Mumbai");
	cities.add("Hyderabad");
	cities.add("Pune");
	System.out.println(cities);
	
	System.out.println("************************");
	
	
	TreeSet<Employee> emps2=new TreeSet<Employee>();
	
	emps2.add(new Employee(333,"Vaishali",1000.0F,LocalDate.of(2018, Month.JUNE, 19)));
	emps2.add(new Employee(111,"Soumya",5000.0F,LocalDate.of(2018, Month.SEPTEMBER, 19)));
	emps2.add(new Employee(222,"Srikar",78000.0F,LocalDate.of(2018, Month.OCTOBER, 12)));
	emps2.add(new Employee(222,"Srikar",78000.0F,LocalDate.of(2018, Month.OCTOBER, 12)));
	emps2.add(new Employee(444,"Ravi",84000.0F,LocalDate.of(2018, Month.NOVEMBER, 13)));
	
	System.out.println(emps2);

}

}
